package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGenerator
import org.eclipse.emf.ecore.resource.Resource
import java.util.List
import org.eclipse.core.resources.IFile
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import org.palladiosimulator.pcm.system.System
import org.eclipse.xtend.lib.annotations.Accessors
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

class PCM2SolidityGenerator extends AbstractEcore2TxtGenerator {

	private System targetSystem;
	private Collection<SystemComponent> systemComponents;
	private SystemStructureBuilder builder;
	private PCM2SolidityGeneratorContent contentGenerator;
	private AccessControl4SmartContractsRepository acRepository;

	public new() {
		this.builder = new SystemStructureBuilder;
		this.contentGenerator = new PCM2SolidityGeneratorContent;
	}

	override generateContentsFromResource(Resource inputResource) {

		val contents = new ArrayList<Triplet<String, String, String>>;
		for (element : inputResource.contents) {
			if (element instanceof System) {
				if (targetSystem === null) {
					this.targetSystem = element;
					this.systemComponents = builder.generateSystemComponents(targetSystem);
					contentGenerator.currentSystem = systemComponents;
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
		for (element : resource.getAllContentsIterable()) {
			if (element instanceof BasicComponent) {
				val content = generateContent(element);

				if (content !== null && !content.equals("")) {
					val folderName = targetFolderPrefix;
					val fileName = getTargetFileNameForNamedElement(element) + getTargetFileExt();
					val contentAndFileName = new Triplet<String, String, String>(content, folderName, fileName);
					contents.add(contentAndFileName);
				}
			}
		}

		contents.generateAndAddOptionalContents;
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
			BasicComponent: postProcessGeneratedContents(contentGenerator.generateContent(element, systemComponents, acRepository))
			EObject: generateContentUnexpectedEObject(element)
		}
	}

	def generateContentUnexpectedEObject(EObject object) {
		"" // "Cannot generate content for generic EObject '" + object + "'!"
	}

	protected def void generateAndAddOptionalContents(
		List<Triplet<String, String, String>> contentsForFolderAndFileNames) {
		// No optional content needed for plain pcm2java
	}

}
