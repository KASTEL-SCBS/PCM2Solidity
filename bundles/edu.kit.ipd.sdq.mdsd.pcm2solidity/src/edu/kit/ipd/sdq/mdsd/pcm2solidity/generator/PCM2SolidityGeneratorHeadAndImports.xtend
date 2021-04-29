package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.BasicComponent
import java.util.Collection
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent

import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityConstants.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.AccessControlGenerator

class PCM2SolidityGeneratorHeadAndImports {
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) Collection<SystemComponent> currentSystem;
	
	new(Collection<SystemComponent> currentSystem){
		this.currentSystem = currentSystem;
	}
	
	def String generateImportsAndClassHead(BasicComponent component) {
		
		
		var systemComponent = getSystemComponentForComponent(component);	
		if(systemComponent === null){
			return generatePragma();
		}
		
		return generateImportsAndClassHead(component, systemComponent);
		
	}
	
	private def String generateImportsAndClassHead(BasicComponent component, SystemComponent systemComponent){
		val pragma = generatePragma;
		val importStatements = generateImportStatements(systemComponent) + newLine;
		val contractHead = generateContractDefinition(component);
		
		
		return pragma + importStatements + contractHead;
	}
	
	public def generatePragma(){
		return '''pragma solidity «solidityVersion»;''' + newLine + newLine;
	}
	
	public def generateContractDefinition(String contractName){
		return '''contract «contractName»'''
	}
	
	public def generateContractDefinition(BasicComponent component){
		return generateContractDefinition(component.entityName);
	}
	
	public def String generateImportStatements(SystemComponent systemComponent) '''
	«generateAccessControlImportStatements»
	«generateImportsFromConnectedComponents(systemComponent)»
	'''
	
	public def String generateImportStatements(BasicComponent component){
		var systemComponent = getSystemComponentForComponent(component);
		
		if(systemComponent === null){
			return "";
		}
		
		return generateImportStatements(systemComponent);
	}
	
	private def String generateAccessControlImportStatements() '''
	import "./«AccessControlGenerator.accessControlName»«targetFileExt»"
'''

	private def String generateImportsFromConnectedComponents(SystemComponent systemComponent)'''«
		FOR calledComponent : systemComponent.componentsRequiredForCalls	
		»import "./«getTargetFileNameForNamedElement(calledComponent.repositoryComponent)»«targetFileExt»";
		«ENDFOR»
'''

	private def SystemComponent getSystemComponentForComponent(BasicComponent component){
		return currentSystem.findFirst[systemComponent | systemComponent.componentId.equals(component.id)]
	}
	
	
}