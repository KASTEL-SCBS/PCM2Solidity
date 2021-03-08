package edu.kit.ipd.sdq.mdsd.pcm2solidity.util

import org.palladiosimulator.pcm.core.entity.NamedElement
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.repository.PrimitiveTypeEnum
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.Repository

import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityConstants.*
import org.palladiosimulator.pcm.repository.Signature
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.CollectionDataType
import java.util.Collection
import edu.kit.kastel.scbs.rbac4smartcontracts.Role

class PCM2SolidityNaming {

	private new() {}
	

	static def dispatch String getTargetName(NamedElement namedElement, boolean pkg) {
		return namedElement.entityName
	}
	
	static def String getModifierNameForRoles(Collection<Role> roles){
		var modifierName = "";
		
		
		for(role : roles.sortBy[x | x.name]){
			modifierName += role.name;
		}
		
		if(modifierName.empty){
			return modifierName;
		} 
		
		return roleModifierPrefix + modifierName;
	}
	
	
	static def String getTargetNameForBasicComponent(BasicComponent bc, boolean pkg) {
		return getComponentsTargetPrefix(bc.repository__RepositoryComponent, pkg) + getSeparator(pkg) + bc.entityName + getSeparatorAtEnd(pkg)
	}
			
			
	static def String getTargetName(PrimitiveDataType pdt, boolean pkg) {
		switch pdt.getType() {
			case PrimitiveTypeEnum::STRING : "s"
			default : ""
		}
	}
	
	static def String getComponentsTargetPrefix(Repository repo, boolean pkg) {
		return getRepoTargetPrefix(repo, pkg) + getSeparator(pkg) + getComponentsTargetName()
	}
	
	static def String getRepoTargetPrefix(Repository repo, boolean pkg) {
		return (if (pkg) "" else getTargetFolderPrefix()) + getTargetName(repo, pkg)
	}
	
	static def String getTargetFileNameForNamedElement(NamedElement namedElement) {
		return namedElement.entityName.toFirstUpper
	}
	
	static def String getMethodName(Signature operationSignature) {
		return operationSignature.entityName.toFirstLower
	}
	
	static dispatch def String getTargetNameForDataType(PrimitiveDataType pdt) {
		switch pdt.getType() {
			case PrimitiveTypeEnum::STRING : "string"
			case PrimitiveTypeEnum::LONG : "//TODO: ERROR: long"
			case PrimitiveTypeEnum::INT: "int"
			case PrimitiveTypeEnum::BOOL: "bool"
			case PrimitiveTypeEnum::DOUBLE: "//TODO: ERROR: No Double"
			case PrimitiveTypeEnum::BYTE: "byte"
			case PrimitiveTypeEnum::CHAR: "//TODO: ERROR: No Char"
			default : ""
		}
	}
	
	static dispatch def String getTargetNameForDataType(CollectionDataType datatype){
		if(datatype.innerType_CollectionDataType instanceof CollectionDataType){
			return '''//TODO: ERROR: Double collections not allowed'''
		} else {
			return '''«datatype.innerType_CollectionDataType.targetNameForDataType»[]'''
		}
	}
	
	static dispatch def String getTargetNameForDataType(CompositeDataType datatype){
		return datatype.entityName;
	}
}