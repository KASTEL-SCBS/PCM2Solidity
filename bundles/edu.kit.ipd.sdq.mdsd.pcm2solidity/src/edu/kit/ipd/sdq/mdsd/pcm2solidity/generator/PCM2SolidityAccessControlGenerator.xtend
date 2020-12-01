package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import org.palladiosimulator.pcm.repository.RepositoryComponent
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import edu.kit.kastel.scbs.rbac4smartcontracts.Role
import java.util.Set
import java.util.Collection
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessibleOperationByRoles
import java.util.ArrayList
import java.util.HashSet
import org.palladiosimulator.pcm.repository.OperationSignature
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCMLookupUtil.*;
import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.OperationProvidedRole
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation
import org.palladiosimulator.pcm.repository.Parameter
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.PrimitiveTypeEnum

class PCM2SolidityAccessControlGenerator {

	@Accessors(PUBLIC_SETTER) RepositoryComponent currentTarget;
	@Accessors(PUBLIC_SETTER) AccessControl4SmartContractsRepository acRepository;
	@Accessors(PUBLIC_SETTER) Collection<SystemComponent> currentSystem

	new(RepositoryComponent currentTarget, AccessControl4SmartContractsRepository acRepository,
		Collection<SystemComponent> currentSystem) {
		this.currentTarget = currentTarget;
		this.currentSystem = currentSystem;
		this.acRepository = acRepository;
	}

	def String generatePreconditionModifierDefinitions() {

		val accessibleRolesForComponent = filterAccessibleOperationsByRoleForComponent(
			acRepository.accessibleOperationsByRole, currentTarget);
		return generatePreconditionModifierDefinitions(accessibleRolesForComponent);
	}

	private def Collection<AccessibleOperationByRoles> filterAccessibleOperationsByRoleForComponent(
		Collection<AccessibleOperationByRoles> accesibleOperationsByRoles, RepositoryComponent component) {
		return accesibleOperationsByRoles.filter[x|x.smartContract.id.equals(component.id)].toList;
	}

	private def String generatePreconditionModifierDefinitions(
		Collection<AccessibleOperationByRoles> AccessibleOperationByRoles) {

		val necessaryPermutations = generateUsedPermutationsOfRolesForMethods(AccessibleOperationByRoles);

		return '''«FOR roles : necessaryPermutations»«generatePreconditionModifierForRoles(roles)»
			«ENDFOR»
			
		''';
	}

	private def Collection<Set<Role>> generateUsedPermutationsOfRolesForMethods(
		Collection<AccessibleOperationByRoles> accesibleOperationByRoles) {
		val necessaryPermutations = new ArrayList<Set<Role>>();

		for (element : accesibleOperationByRoles) {

			val necessaryRoles = new HashSet<Role>;

			for (role : element.role) {
				necessaryRoles.add(role);
			}

			if (!isPermutation(necessaryPermutations, necessaryRoles)) {
				// var sortedRoles = necessaryRoles.sortBy[x|x.name];
				necessaryPermutations.add(necessaryRoles);
			}
		}

		return necessaryPermutations;
	}

	private def boolean isPermutation(Collection<Set<Role>> computedPermutations, Collection<Role> toCheck) {

		for (necessaryPermutation : computedPermutations) {
			var isPermutation = true;
			if (toCheck.size.equals(necessaryPermutation.size)) {
				for (roleToCheck : toCheck) {
					isPermutation = isPermutation && necessaryPermutation.contains(roleToCheck);
				}

				if (isPermutation) {
					return true;
				}
			}
		}

		return false;
	}

	private def String generatePreconditionModifierForRoles(Collection<Role> roles) {
		val currentSystemComponent = findSystemComponentForCurrentTargetComponent(currentSystem, currentTarget);
		val requiredOperations = getAllRequiredOperationsFromComponent(currentTarget);
		val appliedAccessControlOperations = acRepository.accOperationDefs.filter [ x |
			requiredOperations.exists[y|x.operation.id.equals(y.id)]
		];
		var errorMSG = "";

		if (appliedAccessControlOperations.size > 1) {
			errorMSG = '''
				//Error: More than one Access Control function found in smart contract for the role permutation «roleNamesCollected(roles)». 
				//Cannot statically distinquish between them;
				//TODO: Manually create modifier body
				revert("TODO: auto-generated method stub")
			'''
		} else if (appliedAccessControlOperations.size == 0) {
			errorMSG = '''
				//Error: No access control function defined for role «roleNamesCollected(roles)» in this smart contract.
				//Call to access control cannot be established
				//TODO: Manually create modifier body
				revert("TODO: auto-generated method stub")
			'''
		}

		if (!errorMSG.empty) {
			return assembleModifierForRoles(roles, errorMSG);
		}

		val targetAccessControlOperation = appliedAccessControlOperations.head;

		if (targetAccessControlOperation.smartContract !== null) {
			return assembleModifierForRoles(roles, targetAccessControlOperation.smartContract,
				targetAccessControlOperation);
		}

		var connectedAccessControls = currentSystemComponent.componentsRequiredForCalls.filter [ x |
			x.repositoryComponent.allProvidedOperationsFromComponent.exists [ y |
				y.id.equals(targetAccessControlOperation.operation.id)
			]
		];

		if (connectedAccessControls.size > 1) {
			errorMSG = '''
				//Error: More than one Smart Contract for access control function found. 
				//Cannot statically decide which to use;
				//TODO: Manually create modifier body
				revert("TODO: auto-generated method stub")
			'''
		} else if (connectedAccessControls.size == 0) {
			errorMSG = '''
				//Error: No smart contract for access control found with corresponding function. 
				//TODO: Manually create modifier body
				revert("TODO: auto-generated method stub")
			'''
		}

		if (!errorMSG.empty) {
			return assembleModifierForRoles(roles, errorMSG);
		}

		return assembleModifierForRoles(roles, connectedAccessControls.head.repositoryComponent,
			targetAccessControlOperation);
	}

	private def String roleNamesCollected(Collection<Role> roles) {
		var names = "";

		for (role : roles) {
			names += role.name + " ";
		}

		return names;
	}

	private def String assembleModifierForRoles(Collection<Role> roles, RepositoryComponent smartContract,
		AccessControlCheckingOperation checkingOperation) '''
		«createModifierHead(roles)» {
			«createModifierBody(roles, smartContract, checkingOperation)»
		}
	'''

	private def String assembleModifierForRoles(Collection<Role> roles, String error) '''
		«createModifierHead(roles)» {
			«error»
		}
	'''

	private def String createModifierHead(Collection<Role> roles) '''modifier «getModifierNameForRoles(roles)»'''

	private def String createModifierBody(Collection<Role> roles, RepositoryComponent smartContract,
		AccessControlCheckingOperation checkingOperation){
			if(roles.size > 1 && checkingOperation.accessDeterminingParameter === null){
				return '''
				//Error: no parameter that transfers the role information is provided in generation-model
				//Hoever multiple roles available ==> Generation of calls not Possible
				//TODO: Manually create modifier body
				revert("TODO: auto-generated method stub")
				'''
			}
			
			return '''«FOR role : roles AFTER '_;'»
require («smartContract.entityName.toFirstLower».«checkingOperation.operation.entityName»(«generateParameterAssigment(role, checkingOperation)») == true,
			"Call should only be made by the role «role.name»."); //TODO: verify auto-generated method stub
			«ENDFOR»
	'''
		}
	//TODO: Refine, however, for Demonstration Purposes good enough
	def String generateParameterAssigment(Role role, AccessControlCheckingOperation checkingOperation) {
		var assignment = "";
		
		var msgSenderAddressSet = false;
		for(parameter : checkingOperation.operation.parameters__OperationSignature){
			if(!msgSenderAddressSet && isAddressField(parameter, checkingOperation)){
				assignment += "msg.sender"
				msgSenderAddressSet = true;
			} else if(parameter.isAccessDetermining(checkingOperation)) {
				if(parameter.dataType__Parameter instanceof PrimitiveDataType){
					if ((parameter.dataType__Parameter as PrimitiveDataType).type.equals(PrimitiveTypeEnum::STRING)){
						assignment += String.format(", \"%s\"", role.name);
					} 
					//else {
					// TODO: See if other encoding, e.g byte, then handle.	
					//}
				} 
			}
		}
		
		
		//«IF checkingOperation.accessDeterminingParameter !== null && parameterExistsInOperation(checkingOperation.operation, checkingOperation.accessDeterminingParameter)», «role.name»«ENDIF»)

		return assignment;
	}
	
	private def boolean isAddressField(Parameter parameter, AccessControlCheckingOperation checkingOperation){
		return parameter.dataType__Parameter instanceof CompositeDataType && (parameter.dataType__Parameter as CompositeDataType).entityName.toLowerCase.equals("address");
	}
	
	private def boolean isAccessDetermining(Parameter parameter, AccessControlCheckingOperation checkingOperation){
		return checkingOperation.accessDeterminingParameter !== null && parameter.parameterName.equals(checkingOperation.accessDeterminingParameter.parameterName);
	}
		
		

	private def Collection<Role> filterUsedRolesInComponent() {
		var rolesInUse = new HashSet<Role>();

		for (element : acRepository.accessibleOperationsByRole) {
			if (element.smartContract.id.equals(currentTarget.id)) {
				rolesInUse.addAll(element.role);
			}
		}

		return rolesInUse;
	}

	def String generateModifierUsageDefitions(OperationSignature signature) {
		val fittingAccesibleOperationsByRole = filterAccessibleOperationsForOperationSignature(signature);

		val necessaryRoles = new HashSet<Role>();

		for (element : fittingAccesibleOperationsByRole) {
			necessaryRoles.addAll(element.role);
		}

		return '''«getModifierNameForRoles(necessaryRoles)»''';
	}

	private def Collection<AccessibleOperationByRoles> filterAccessibleOperationsForOperationSignature(
		OperationSignature signature) {
		var operationsForModifiersForComponent = filterOperationsForModifiersForComponent();
		var operationsForModifiersForSignature = new HashSet<AccessibleOperationByRoles>();
		for (element : operationsForModifiersForComponent) {
			if (element.operation.id.equals(signature.id)) {
				operationsForModifiersForSignature.add(element);
			}
		}

		return operationsForModifiersForSignature;
	}

	private def Collection<AccessibleOperationByRoles> filterOperationsForModifiersForComponent() {
		var accesibleOperationsElements = new ArrayList<AccessibleOperationByRoles>();
		for (element : acRepository.accessibleOperationsByRole) {
			if (element.smartContract.id.equals(currentTarget.id)) {
				val searchableElements = element.smartContract.providedRoles_InterfaceProvidingEntity.filter(
					OperationProvidedRole).map[it.providedInterface__OperationProvidedRole].map [
					it.signatures__OperationInterface
				].flatten.toList;

				if (searchableElements.exists[x|element.operation.id.equals(x.id)]) {
					accesibleOperationsElements.add(element);
				}
			}
		}

		return accesibleOperationsElements;
	}

}
