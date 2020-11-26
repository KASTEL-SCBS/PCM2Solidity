package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import org.palladiosimulator.pcm.repository.BasicComponent
import org.eclipse.xtend.lib.annotations.Accessors
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent
import java.util.Collection
import java.util.ArrayList
import org.palladiosimulator.pcm.repository.OperationSignature
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.CollectionDataType
import org.palladiosimulator.pcm.repository.EventType
import org.palladiosimulator.pcm.repository.OperationProvidedRole
import org.palladiosimulator.pcm.repository.SourceRole
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessbleOperationByRole
import org.palladiosimulator.pcm.repository.OperationRequiredRole
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsFactory
import edu.kit.kastel.scbs.rbac4smartcontracts.Role
import java.util.Set
import java.util.HashSet

class PCM2SolidityGeneratorContent {
	@Accessors(PRIVATE_GETTER) BasicComponent currentTarget;
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) Collection<SystemComponent> currentSystem;
	@Accessors(PRIVATE_GETTER) PCM2SolidityGeneratorHeadAndImports generatorHeadAndImports;
	@Accessors(PRIVATE_GETTER) AccessControl4SmartContractsRepository acRepository;

	new() {
		this.generatorHeadAndImports = new PCM2SolidityGeneratorHeadAndImports;
		currentSystem = new ArrayList<SystemComponent>();
	}

	new(Collection<SystemComponent> system) {
		this.generatorHeadAndImports = new PCM2SolidityGeneratorHeadAndImports;
		this.currentSystem = system;
	}

	def String generateContent(BasicComponent bc, Collection<SystemComponent> systemComponents) {
		java.lang.System.out.println("BC: " + bc.entityName);
		currentTarget = bc;
		currentSystem = systemComponents;

		val importsAndClassifierHead = generatorHeadAndImports.generateImportsAndClassHead(currentTarget,
			currentSystem);
		val localVariables = generateLocalVariables();
		val events = generateEventDefinitions();
		val functions = generateMethodDefinitions();

		return '''«importsAndClassifierHead»{
			
	«localVariables»
			
	«events»
	 
	«functions»
} ''';
	}
	
	private def String generateLocalVariables(){
		val systemCmponent = currentSystem.findFirst[component | component.componentId.equals(currentTarget.id)];
		var retText = "";
		
		
		if(systemCmponent !== null){
			retText = '''«FOR requiredComponent : systemCmponent.componentsRequiredForCalls»
			«requiredComponent.targetComponentName» public «requiredComponent.targetComponentName.toLowerCase» \\TODO: Verify Name«ENDFOR»
'''
		}
		
		return retText;
	}
	
	private def String generatePreconditionModifierDefinitions(){
		
		val rolesInUse = filterUsedRolesInComponent();
		
		return '''«FOR role : rolesInUse»
		«generatePreconditionModifierForRole(role)»«ENDFOR»
		'''
	}
	
	//TODO: This method is not finished yet
	private def String generatePreconditionModifierForRole(Role role)'''
	modifier only«role.name.toFirstUpper»() {
		require (...(msg.sender) == true,
		"Call should only be made by the role «role.name».");
	}
	'''

	private def Collection<AccessbleOperationByRole> filterOperationsForModifiers(){
		var accesibleOperationsElements = new ArrayList<AccessbleOperationByRole>();
		for (element : acRepository.accessibleOperationsByRole){
			if(element.smartContract.id.equals(currentTarget.id)){
				val searchableElements = element.smartContract.requiredRoles_InterfaceRequiringEntity.filter(OperationRequiredRole).map[it.requiredInterface__OperationRequiredRole].map[it.signatures__OperationInterface].flatten;
				
				if(searchableElements.exists[x | element.operation.id.equals(x.id)]){
					accesibleOperationsElements.add(element);
				}
			}
		}
		
		return accesibleOperationsElements;
	}
	
	private def Collection<Role> filterUsedRolesInComponent(){
		var rolesInUse = new HashSet<Role>();
		
		for(element : acRepository.accessibleOperationsByRole){
			rolesInUse.add(element.role);
		}
		
		return rolesInUse;
	}

	private def String generateMethodDefinitions() {
		val operationSignatures = currentTarget.providedRoles_InterfaceProvidingEntity.filter(OperationProvidedRole).map [
			it.providedInterface__OperationProvidedRole
		].map[it.signatures__OperationInterface].flatten
		val methodDefinitions = generateMethodDefinitions(operationSignatures).toString;
		return methodDefinitions;
	}

	private def generateMethodDefinitions(
		Iterable<OperationSignature> operationSignatures) '''«FOR operationSignature : operationSignatures SEPARATOR '{
	// TODO: implement and verify auto-generated method stub
	revert("TODO: auto-generated method stub")
}

' AFTER '{
	// TODO: implement and verify auto-generated method stub
	revert("TODO: auto-generated method stub")
}

'»
	«generateCommentsForMethod(operationSignature)»
	«generateMethodDeclarationWithoutSemicolon(operationSignature)»«ENDFOR»
	'''

	private def String generateEventDefinitions() {
		val eventTypes = currentTarget.requiredRoles_InterfaceRequiringEntity.filter(SourceRole).map [
			it.eventGroup__SourceRole
		].map[it.eventTypes__EventGroup].flatten;
		val eventDefinitions = generateEventDefinitions(eventTypes).toString;

		return eventDefinitions
	}

	private def String generateEventDefinitions(Iterable<EventType> eventTypes) '''«FOR eventtype : eventTypes»
	«generateCommentsForEvents(eventtype)»
	«generateEventDeclarationWithoutSemicolon(eventtype)»; // TODO: verify auto-generated parameters«ENDFOR»
'''

	protected def String generateCommentsForMethod(OperationSignature signature) {
		return ""
	}

	protected def String generateCommentsForEvents(EventType eventtype) {
		return "";
	}

	protected def String generateMethodDeclarationWithoutSemicolon(OperationSignature operationSignature) {
		val returnType = generateReturn(operationSignature);
		val methodName = operationSignature.getMethodName
		val parameterDeclarations = '''«FOR parameter : operationSignature.parameters__OperationSignature SEPARATOR ', '»«parameter.dataType__Parameter.handleDataTypeName» «parameter.getParameterName»«ENDFOR»'''
		return '''function «methodName»(«parameterDeclarations») «returnType»'''
	}

	protected def String generateEventDeclarationWithoutSemicolon(EventType eventtype) {
		val eventName = eventtype.entityName;
		val eventTypeParam = eventtype.parameter__EventType;

		var eventtypeParameters = "\"TODO: Fill-in correct parameters here\"";

		if (eventTypeParam !== null) {
			val eventDataType = eventTypeParam.dataType__Parameter;

			if (eventDataType !== null && eventDataType instanceof CompositeDataType) {
				eventtypeParameters = generateEventTypeParameterList(eventDataType as CompositeDataType);
			}
		}
		return '''event «eventName»(«eventtypeParameters»)'''
	}

	def String generateEventTypeParameterList(CompositeDataType type) '''
	«FOR innerType : type.innerDeclaration_CompositeDataType SEPARATOR ', '»«innerType.datatype_InnerDeclaration.handleReturnDataType» «innerType.entityName»«ENDFOR»'''

	private def String generateReturn(OperationSignature opSig) {

		var returnType = opSig.returnType__OperationSignature;

		if (returnType === null) {
			return "";
		}

		var returnedTypes = handleReturnDataType(returnType);

		return '''public returns («returnedTypes»)''';
	}

	private dispatch def String handleDataTypeName(PrimitiveDataType dt) {
		// Not Nice, but for prototyping ok.
		return handleReturnDataType(dt);
	}

	private dispatch def String handleDataTypeName(CompositeDataType dt) {
		if (dt.entityName.toFirstLower.equals("address")) {
			return "address"
		}

		return '''«dt.entityName»'''
	}

	private dispatch def String handleDataTypeName(CollectionDataType dt) {
		// Not Nice, but for prototyping ok.
		return handleReturnDataType(dt);
	}

	private dispatch def String handleReturnDataType(
		PrimitiveDataType dt) '''«getTargetFileNameForPrimitiveDataType(dt)»'''

	private dispatch def String handleReturnDataType(CompositeDataType dt) {
		var returnTypes = "";

		if (dt.entityName.toFirstLower.equals("address")) {
			return "address"
		}

		returnTypes = '''«FOR composingType : dt.innerDeclaration_CompositeDataType SEPARATOR ', '»«handleReturnDataType(composingType.datatype_InnerDeclaration)»«ENDFOR»'''
		return returnTypes;
	}

	private dispatch def String handleReturnDataType(CollectionDataType dt) '''«getTargetNameForDataType(dt)»[]'''

}
