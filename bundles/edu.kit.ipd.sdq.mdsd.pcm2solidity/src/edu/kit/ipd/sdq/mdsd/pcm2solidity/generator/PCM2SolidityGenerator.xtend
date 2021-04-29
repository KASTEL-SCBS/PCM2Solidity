package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGenerator
import org.eclipse.emf.ecore.resource.Resource
import java.util.List
import org.eclipse.core.resources.IFile
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import org.palladiosimulator.pcm.system.System
import org.eclipse.internal.xtend.util.Triplet
import org.palladiosimulator.pcm.repository.BasicComponent
import org.eclipse.emf.ecore.EObject

import static extension edu.kit.ipd.sdq.commons.util.org.eclipse.emf.ecore.resource.ResourceUtil.getAllContentsIterable;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityConstants.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import java.util.Collection
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemStructureBuilder
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.AccessControlGenerator
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates.SolidityClassGenerationTemplate
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates.ClassGenerationTemplate

class PCM2SolidityGenerator extends AbstractEcore2TxtGenerator {

	private System targetSystem;
	private Collection<SystemComponent> systemComponents;
	private SystemStructureBuilder builder;
	private AccessControl4SmartContractsRepository acRepository; 
	private AccessControlGenerator acGenerator;
	private SolidityContractGenerator contractGenerator;

	public new() {
		this.builder = new SystemStructureBuilder;
	}

	override generateContentsFromResource(Resource inputResource) {

		val contents = new ArrayList<Triplet<String, String, String>>;
		for (element : inputResource.contents) {
			if (element instanceof System) {
				if (targetSystem === null) {
					this.targetSystem = element;
					this.systemComponents = builder.generateSystemComponents(targetSystem);
					//contentGenerator.currentSystem = systemComponents;
					return contents;
				}
			} else if (element instanceof AccessControl4SmartContractsRepository){
				this.acRepository = element;
				return contents;
			}
		}

		generateAndAddContents(inputResource, contents);

		return contents;
	}

	private def void generateAndAddContents(Resource resource, List<Triplet<String, String, String>> contents) {
		this.contractGenerator = new SolidityContractGenerator(systemComponents, acRepository)
		
		//TODO: Could reduce redundancy by passing contents and add in central method
		acGenerator = new AccessControlGenerator(acRepository, true);
		var acContent = acGenerator.generate();
		if (acContent !== null && !acContent.equals("")) {
			contents.add(generateContentTriplet(acContent, AccessControlGenerator.accessControlName));
		}
		
		for (element : resource.getAllContentsIterable()) {
			if (element instanceof BasicComponent) {
				val content = generateContent(element);

				if (content !== null && !content.equals("")) {
					contents.add(generateContentTriplet(content, element));
				}
			}
		}

		contents.generateAndAddOptionalContents;
	}
	
	
	private def Triplet<String, String, String> generateContentTriplet(String content, String fileName){
		val folderName = targetFolderPrefix;
		val fileNameWithExtension = fileName + getTargetFileExt();
		val contentAndFileName = new Triplet<String, String, String>(content, folderName, fileNameWithExtension);
		
		return contentAndFileName;
	}
	
	private def Triplet<String, String, String> generateContentTriplet(String content, BasicComponent component){
		return generateContentTriplet(content, getTargetFileNameForNamedElement(component));
	}
	
	

	override getFileNameForResource(Resource inputResource) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getFolderNameForResource(Resource inputResource) {
		return "src-gen"
	}

	override postProcessGeneratedContents(String contents) {
		// No postprocessing necessary
		return contents;
	}

	override preprocessInputFiles(List<IFile> inputFiles) {
		return sortInputFiles(inputFiles)
	}

	private def List<IFile> sortInputFiles(List<IFile> inputFiles) {
		val preprocessedInputFiles = new ArrayList(inputFiles.size)
		preprocessedInputFiles.addAll(inputFiles)
		Collections.sort(preprocessedInputFiles, new Comparator<IFile>() {
			override compare(IFile o1, IFile o2) {
				val fileExtIndex1 = fileExt2Index(o1.fileExtension)
				val fileExtIndex2 = fileExt2Index(o2.fileExtension)
				return fileExtIndex1.compareTo(fileExtIndex2)
			}

			def private int fileExt2Index(String fileExt) {
				switch fileExt {
					case 'system': 0
					case 'rbac4smartcontracts' : 1
					case 'repository': 2
				}
			}
		})
		return preprocessedInputFiles
	}

	private def String generateContent(EObject element) {
		switch element {
			BasicComponent: postProcessGeneratedContents(generateContract(element))
			EObject: generateContentUnexpectedEObject(element)
		}
	}
	
	private def String generateContract(BasicComponent component){
		contractGenerator.currentTarget = component;
		return contractGenerator.generate();
	}

	def generateContentUnexpectedEObject(EObject object) {
		"" // "Cannot generate content for generic EObject '" + object + "'!"
	}

	protected def void generateAndAddOptionalContents(
		List<Triplet<String, String, String>> contentsForFolderAndFileNames) {
		// No optional content needed
	}

}
