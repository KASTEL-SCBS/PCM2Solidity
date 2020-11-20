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

class PCM2SolidityNaming {

	private new() {}
	

	static def dispatch String getTargetName(NamedElement namedElement, boolean pkg) {
		return namedElement.entityName
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
	
	static def String getTargetNameForDataType(DataType dt){
		if(dt instanceof PrimitiveDataType){
			return getTargetFileNameForPrimitiveDataType(dt);
		} else if (dt instanceof CompositeDataType){
			return dt.entityName;
		} else if (dt instanceof CollectionDataType){
			return dt.entityName;
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
	
	static def String getTargetFileNameForPrimitiveDataType(PrimitiveDataType pdt) {
		switch pdt.getType() {
			case PrimitiveTypeEnum::STRING : "string"
			case PrimitiveTypeEnum::LONG : "TODO: ERROR: long"
			case PrimitiveTypeEnum::INT: "int"
			case PrimitiveTypeEnum::BOOL: "bool"
			case PrimitiveTypeEnum::DOUBLE: "TODO: ERROR: No Double"
			case PrimitiveTypeEnum::BYTE: "byte"
			case PrimitiveTypeEnum::CHAR: "TODO: ERROR: No Char"
			default : ""
		}
	}
}