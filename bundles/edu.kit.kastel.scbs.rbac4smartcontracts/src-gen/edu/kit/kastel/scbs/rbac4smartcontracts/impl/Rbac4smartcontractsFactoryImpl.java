/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import edu.kit.kastel.scbs.rbac4smartcontracts.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Rbac4smartcontractsFactoryImpl extends EFactoryImpl implements Rbac4smartcontractsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Rbac4smartcontractsFactory init() {
		try {
			Rbac4smartcontractsFactory theRbac4smartcontractsFactory = (Rbac4smartcontractsFactory) EPackage.Registry.INSTANCE
					.getEFactory(Rbac4smartcontractsPackage.eNS_URI);
			if (theRbac4smartcontractsFactory != null) {
				return theRbac4smartcontractsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Rbac4smartcontractsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rbac4smartcontractsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY:
			return createAccessControl4SmartContractsRepository();
		case Rbac4smartcontractsPackage.ROLE:
			return createRole();
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES:
			return createOperationAccessibleByRoles();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION:
			return createAccessControlCheckingOperation();
		case Rbac4smartcontractsPackage.ALTERNATIVE_ENCODING:
			return createAlternativeEncoding();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControl4SmartContractsRepository createAccessControl4SmartContractsRepository() {
		AccessControl4SmartContractsRepositoryImpl accessControl4SmartContractsRepository = new AccessControl4SmartContractsRepositoryImpl();
		return accessControl4SmartContractsRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationAccessibleByRoles createOperationAccessibleByRoles() {
		OperationAccessibleByRolesImpl operationAccessibleByRoles = new OperationAccessibleByRolesImpl();
		return operationAccessibleByRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlCheckingOperation createAccessControlCheckingOperation() {
		AccessControlCheckingOperationImpl accessControlCheckingOperation = new AccessControlCheckingOperationImpl();
		return accessControlCheckingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlternativeEncoding createAlternativeEncoding() {
		AlternativeEncodingImpl alternativeEncoding = new AlternativeEncodingImpl();
		return alternativeEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rbac4smartcontractsPackage getRbac4smartcontractsPackage() {
		return (Rbac4smartcontractsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Rbac4smartcontractsPackage getPackage() {
		return Rbac4smartcontractsPackage.eINSTANCE;
	}

} //Rbac4smartcontractsFactoryImpl
