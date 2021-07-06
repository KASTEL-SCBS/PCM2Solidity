package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol

import org.palladiosimulator.pcm.repository.RepositoryComponent
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import edu.kit.kastel.scbs.rbac4smartcontracts.Role
import java.util.Set
import java.util.Collection
import java.util.ArrayList
import java.util.HashSet
import org.palladiosimulator.pcm.repository.OperationSignature
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCMLookupUtil.*;
import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.OperationProvidedRole
import org.palladiosimulator.pcm.repository.Parameter
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.PrimitiveTypeEnum
import edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles
import edu.kit.kastel.scbs.rbac4smartcontracts.Storage
import edu.kit.kastel.scbs.rbac4smartcontracts.StorageVariable
import org.palladiosimulator.pcm.repository.CollectionDataType
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.AccessControlGenerator

class ModifierAndContractGenerator {

	@Accessors(PUBLIC_SETTER) RepositoryComponent currentTarget;
	@Accessors(PUBLIC_GETTER) AccessControl4SmartContractsRepository acRepository;
	private Collection<SystemComponent> currentSystem

	private final String solcVerifyPostConditionPrelude = '''/// @notice postcondition'''
	private final String solcVerifyOld = '''__verifier_old_'''

	new(AccessControl4SmartContractsRepository acRepository,
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

	private def Collection<OperationAccessibleByRoles> filterAccessibleOperationsByRoleForComponent(
		Collection<OperationAccessibleByRoles> accesibleOperationsByRoles, RepositoryComponent component) {
		return accesibleOperationsByRoles.filter [ x |
			x.operationprovidedrole.providingEntity_ProvidedRole.id.equals(component.id)
		].toList;
	}

	private def String generatePreconditionModifierDefinitions(
		Collection<OperationAccessibleByRoles> AccessibleOperationByRoles) {

		val necessaryPermutations = generateUsedPermutationsOfRolesForMethods(AccessibleOperationByRoles);

		return '''«FOR roles : necessaryPermutations»«generatePreconditionModifierForRoles(roles)»
			«ENDFOR»
			
		''';
	}

	private def Collection<Set<Role>> generateUsedPermutationsOfRolesForMethods(
		Collection<OperationAccessibleByRoles> accesibleOperationByRoles) {
		val necessaryPermutations = new ArrayList<Set<Role>>();

		for (element : accesibleOperationByRoles) {

			val necessaryRoles = new HashSet<Role>;

			for (role : element.role) {
				necessaryRoles.add(role);
			}

			if (!isPermutation(necessaryPermutations, necessaryRoles)) {
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
		return assembleModifierForRoles(roles);
	}

	private def String assembleModifierForRoles(Collection<Role> roles) '''
		«createModifierHead(roles)» {
			«createModifierBody(roles)»
		}
	'''


	private def String createModifierHead(Collection<Role> roles) '''modifier «getModifierNameForRoles(roles)»'''

	private def String createModifierBody(Collection<Role> roles) {

		var requireQuery = '''«FOR role : roles SEPARATOR " || \n"»«buildAccessControlQuery(role)»«ENDFOR»'''

		return '''

require(«requireQuery»,
			"Access denied");
_;
			'''
	}

	def String buildAccessControlQuery(Role role) {
		return '''«AccessControlGenerator.accessControlName.toFirstLower».«AccessControlGenerator.accessCheckingFunctionName»(msg.sender, «AccessControlGenerator.accessControlName.toFirstLower».«AccessControlGenerator.rolesEnumName».«role.entityName.toUpperCase»)''';
	}

	def String generateModifierUsageDefitions(OperationSignature signature) {
		val fittingAccesibleOperationsByRole = filterAccessibleOperationsForOperationSignature(signature);

		val necessaryRoles = new HashSet<Role>();

		for (element : fittingAccesibleOperationsByRole) {
			necessaryRoles.addAll(element.role);
		}

		return '''«getModifierNameForRoles(necessaryRoles)»''';
	}

	private def Collection<OperationAccessibleByRoles> filterAccessibleOperationsForOperationSignature(
		OperationSignature signature) {
		var operationsForModifiersForComponent = filterOperationsForModifiersForComponent();
		var operationsForModifiersForSignature = new HashSet<OperationAccessibleByRoles>();
		for (element : operationsForModifiersForComponent) {
			if (element.operation.id.equals(signature.id)) {
				operationsForModifiersForSignature.add(element);
			}
		}

		return operationsForModifiersForSignature;
	}

	private def Collection<OperationAccessibleByRoles> filterOperationsForModifiersForComponent() {
		var accesibleOperationsElements = new ArrayList<OperationAccessibleByRoles>();
		for (element : acRepository.accessibleOperationsByRole) {
			if (element.operationprovidedrole.providingEntity_ProvidedRole.id.equals(currentTarget.id)) {
				val searchableElements = element.operationprovidedrole.providingEntity_ProvidedRole.
					providedRoles_InterfaceProvidingEntity.filter(OperationProvidedRole).map [
						it.providedInterface__OperationProvidedRole
					].map [
						it.signatures__OperationInterface
					].flatten.toList;

				if (searchableElements.exists[x|element.operation.id.equals(x.id)]) {
					accesibleOperationsElements.add(element);
				}
			}
		}

		return accesibleOperationsElements;
	}

	private def String generateNotModificationProofObligation(OperationSignature opSig) {
		var allStorageVariablesForComponent = getAllStorageVariablesInStorages(getStoragesForComponent());
		var opAccessibleByRoles = filterAccessibleOperationsForOperationSignature(opSig);
		var oldClauses = "";

		for (storagevariable : allStorageVariablesForComponent) {
			if (!opAccessibleByRoles.empty) {
				for (opAccessible : opAccessibleByRoles) {
					if (!opAccessible.isSubsetOf(storagevariable)) {
						oldClauses = String.format("%s%n%s", oldClauses,
							generateUnmodifyingProofObligationForStorageVariable(storagevariable));
					}
				}
			} else {
				oldClauses = String.format("%s%n%s", oldClauses,
					generateUnmodifyingProofObligationForStorageVariable(storagevariable));
			}
		}

		return oldClauses;
	}

	// TODO: Make this possible to configurate by Generator-Elemen usage (Common Interface)
	public def String generateProofObligationsForOperation(OperationSignature opSig) {

		var proofObligationsForOperation = "";

		proofObligationsForOperation = generateNotModificationProofObligation(opSig);

		return proofObligationsForOperation;
	}

	public def Collection<Storage> getStoragesForComponent(RepositoryComponent component,
		AccessControl4SmartContractsRepository repository) {
		var storage = repository.storage.filter[storage|storage.smartContract.id.equals(component.id)].toList;
		return storage;
	}

	private def Collection<Storage> getStoragesForComponent() {
		return getStoragesForComponent(currentTarget, acRepository);
	}

	public def Collection<StorageVariable> getAllStorageVariablesInStorages(Collection<Storage> storages) {
		return storages.map[it.storagevariable].flatten.toSet;
	}

	private def boolean isSubsetOf(OperationAccessibleByRoles rf, StorageVariable storagevariable) {
		for (role : rf.role) {
			if (!storagevariable.roles.contains(role)) {
				return false;
			}
		}

		return true;
	}

	private def String generateUnmodifyingProofObligationForStorageVariable(StorageVariable storageVariable) {
		if (!(storageVariable.dataType instanceof CollectionDataType)) {
			generateUnmodifyingProofObligationForSingleTypeStorageVariable(storageVariable);
		} else {
			generateUnmodifyingProofObligationForCollectionTypeStorageVariable(storageVariable);
		}
	}

	private def String generateUnmodifyingProofObligationForSingleTypeStorageVariable(StorageVariable storageVariable) {
		if (!(storageVariable.dataType instanceof CollectionDataType) &&
			storageVariable.dataType.checkForSolcComparisonCompatibility) {
			return '''«solcVerifyPostConditionPrelude» «storageVariable.entityName» == «solcVerifyOld»«getTargetNameForDataType(storageVariable.dataType)»(«storageVariable.entityName»)'''
		}

		return "";
	}

	private def String generateUnmodifyingProofObligationForCollectionTypeStorageVariable(
		StorageVariable storageVariable) {

		if (storageVariable.dataType instanceof CollectionDataType &&
			storageVariable.dataType.checkForSolcComparisonCompatibility) {
			return '''«solcVerifyPostConditionPrelude» forall (uint i) (!( 0 <= i && i < «storageVariable.entityName».length) || «storageVariable.entityName»[i] == «solcVerifyOld»«getTargetNameForDataType((storageVariable.dataType as CollectionDataType).innerType_CollectionDataType)»(«storageVariable.entityName»[i]))'''
		}

		return "";

	}

	private dispatch def boolean checkForSolcComparisonCompatibility(PrimitiveDataType dataType) {
		return dataType.type.equals(PrimitiveTypeEnum.BOOL) || dataType.type.equals(PrimitiveTypeEnum.INT)
	}

	private dispatch def boolean checkForSolcComparisonCompatibility(CollectionDataType dataType) {
		return checkForSolcComparisonCompatibility(dataType.innerType_CollectionDataType);
	}

	private dispatch def boolean checkForSolcComparisonCompatibility(CompositeDataType dataType) {
		return dataType.entityName.equals("address");
	}

}
