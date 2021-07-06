package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates.SolidityClassGenerationTemplate
import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.BasicComponent
import java.util.Collection
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.ModifierAndContractGenerator
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.AccessControlGenerator
import edu.kit.kastel.scbs.rbac4smartcontracts.StorageVariable

import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCMLookupUtil.*;
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.CollectionDataType
import org.palladiosimulator.pcm.repository.OperationSignature

class SolidityContractGenerator extends SolidityClassGenerationTemplate{
	
	@Accessors(PRIVATE_GETTER) BasicComponent currentTarget;
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) Collection<SystemComponent> currentSystem;
	@Accessors(PRIVATE_GETTER) PCM2SolidityGeneratorHeadAndImports generatorHeadAndImports;
	@Accessors(PRIVATE_GETTER) AccessControl4SmartContractsRepository acRepository;
	@Accessors(PRIVATE_GETTER) ModifierAndContractGenerator acGenerator;
	@Accessors(PRIVATE_GETTER) SpecifiedMethodGenerator methodGenerator;
	
	new(Collection<SystemComponent> currentSystem, AccessControl4SmartContractsRepository acRepository){
		this.currentSystem = currentSystem;
		this.acRepository = acRepository;
		this.acGenerator = new ModifierAndContractGenerator(acRepository, currentSystem);
		this.generatorHeadAndImports = new PCM2SolidityGeneratorHeadAndImports(currentSystem);
		this.methodGenerator = new SpecifiedMethodGenerator(acGenerator);
	}
	
	override protected generatePragma() {
		return generatorHeadAndImports.generatePragma;
	}
	
	override protected generateModifiers() {
		acGenerator.currentTarget = currentTarget;
		return acGenerator.generatePreconditionModifierDefinitions();
	}
	
	override protected generatePackage() {
		return "";
	}
	
	override protected generateImports() {
		return generatorHeadAndImports.generateImportStatements(currentTarget);
	}
	
	override protected generateDeclaration() {
		return generatorHeadAndImports.generateContractDefinition(currentTarget);
	}
	
	override protected generateConstructors() {
		return "";
	}
	
	override protected generateFields() {
		return '''
«generateFieldsFromAssembly»
«generateFieldForAccessControl»
«generateFieldsFromStorageVariables»'''
	}
	

	
	private def String generateFieldsFromAssembly(){
		val systemCmponent = findSystemComponentForCurrentTargetComponent();
		var retText = "";

		if (systemCmponent !== null) {
			retText = '''«FOR requiredComponent : systemCmponent.componentsRequiredForCalls»
			«requiredComponent.targetComponentName» «requiredComponent.targetComponentName.toFirstLower»; //TODO: Auto-generated Field«ENDFOR»
'''
		}

		return retText;
	}
	
	private def generateFieldForAccessControl() {
		return '''«AccessControlGenerator.accessControlName» «AccessControlGenerator.accessControlName.toFirstLower»'''
	}
	
	private def String generateFieldsFromStorageVariables(){
		val storages = acGenerator.getStoragesForComponent(currentTarget, acRepository);
		val storageVariables = acGenerator.getAllStorageVariablesInStorages(storages);
		
		return '''«FOR storageVariable : storageVariables»
		«generateRoleCommentForFields(storageVariable)»
		«getTargetNameForDataType(storageVariable.dataType)» «storageVariable.entityName.toFirstLower»; //TODO: Auto-generated Field«ENDFOR»'''
	}
	
	private def String generateRoleCommentForFields(StorageVariable storageVariable){
		var comment = "//Modifiable by: ";
		
		if(storageVariable.roles.empty){
			return comment + "Nothing"
		}
		
		var roles = '''«FOR role : storageVariable.roles SEPARATOR', '»«role.entityName»«ENDFOR»''';
	
		return comment + roles; 	
	}
	
	private def SystemComponent findSystemComponentForCurrentTargetComponent() {
		return currentSystem.findFirst[component|component.componentId.equals(currentTarget.id)];
	}
	
	
	override protected generateMethods() {
		val operationSignatures = getAllProvidedOperationsFromComponent(currentTarget);
		val methodDefinitions = generateMethodDefinitions(operationSignatures).toString;
		return methodDefinitions;
	}
	
	private def String generateMethodDefinitions(Iterable<OperationSignature> operationSignatures)'''
	«FOR signature : operationSignatures SEPARATOR "\n"»
	«executeMethodGeneration(signature)»
	«ENDFOR»
	'''
	
	protected def String executeMethodGeneration(OperationSignature signature){
		methodGenerator.currentTarget = signature;
		return methodGenerator.generate;
	}
	
	private dispatch def String handleReturnDataType(
		PrimitiveDataType dt) '''«getTargetNameForDataType(dt)»'''

	private dispatch def String handleReturnDataType(CompositeDataType dt) {
		var returnTypes = "";

		if (dt.entityName.toFirstLower.equals("address")) {
			return "address"
		}

		returnTypes = '''«FOR composingType : dt.innerDeclaration_CompositeDataType SEPARATOR ', '»«handleReturnDataType(composingType.datatype_InnerDeclaration)»«ENDFOR»'''
		return returnTypes;
	}

	private dispatch def String handleReturnDataType(CollectionDataType dt) '''«getTargetNameForDataType(dt)»'''
	
	override setCurrentTarget(BasicComponent component) {
		this.currentTarget = component;
		acGenerator.currentTarget = component;
	}
	
}