package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.system.System
import java.util.Collection
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent

import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityConstants.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;

class PCM2SolidityGeneratorHeadAndImports {
	@Accessors(PROTECTED_GETTER) BasicComponent currentTarget;
	@Accessors(PROTECTED_GETTER) SystemComponent currentTargetSystemComponent
	@Accessors(PROTECTED_GETTER) Collection<SystemComponent> currentSystem;
	
	def String generateImportsAndClassHead(BasicComponent component, Collection<SystemComponent> components) {
		
		currentTarget = component;
		currentSystem = components;
		
		for(sysComp : components){
			if(sysComp.componentId.equals(component.id)){
				currentTargetSystemComponent = sysComp;
			}
		}
		
		if(currentTargetSystemComponent === null){
			return "";
		}
		
		return generateImportsAndClassHead();
		
	}
	
	private def String generateImportsAndClassHead(){
		val pragma = '''pragma solidity «solidityVersion»''' + newLine + newLine;
		val importStatements = generateImportStatements + newLine;
		val contractHead = '''contract «currentTarget.entityName» '''
		
		
		return pragma + importStatements + contractHead;
	}
	
	private def String generateImportStatements() '''«
		FOR calledComponent : currentTargetSystemComponent.componentsRequiredForCalls	
		»import "./«getTargetFileNameForNamedElement(calledComponent.repositoryComponent)»«targetFileExt»";
		«ENDFOR»
'''
	
	
}