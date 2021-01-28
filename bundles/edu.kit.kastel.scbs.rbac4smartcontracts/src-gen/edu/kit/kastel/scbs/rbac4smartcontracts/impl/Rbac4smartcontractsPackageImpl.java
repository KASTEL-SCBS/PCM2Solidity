/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import edu.kit.ipd.sdq.composition.securityanalyses.basic.BasicPackage;

import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository;
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation;
import edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding;
import edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsFactory;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage;
import edu.kit.kastel.scbs.rbac4smartcontracts.Role;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Rbac4smartcontractsPackageImpl extends EPackageImpl implements Rbac4smartcontractsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessControl4SmartContractsRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationAccessibleByRolesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessControlCheckingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeEncodingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Rbac4smartcontractsPackageImpl() {
		super(eNS_URI, Rbac4smartcontractsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Rbac4smartcontractsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Rbac4smartcontractsPackage init() {
		if (isInited)
			return (Rbac4smartcontractsPackage) EPackage.Registry.INSTANCE
					.getEPackage(Rbac4smartcontractsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRbac4smartcontractsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Rbac4smartcontractsPackageImpl theRbac4smartcontractsPackage = registeredRbac4smartcontractsPackage instanceof Rbac4smartcontractsPackageImpl
				? (Rbac4smartcontractsPackageImpl) registeredRbac4smartcontractsPackage
				: new Rbac4smartcontractsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRbac4smartcontractsPackage.createPackageContents();

		// Initialize created meta-data
		theRbac4smartcontractsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRbac4smartcontractsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Rbac4smartcontractsPackage.eNS_URI, theRbac4smartcontractsPackage);
		return theRbac4smartcontractsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessControl4SmartContractsRepository() {
		return accessControl4SmartContractsRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControl4SmartContractsRepository_Roles() {
		return (EReference) accessControl4SmartContractsRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControl4SmartContractsRepository_AccessibleOperationsByRole() {
		return (EReference) accessControl4SmartContractsRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControl4SmartContractsRepository_AccOperationDefs() {
		return (EReference) accessControl4SmartContractsRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_AlternativeEncoding() {
		return (EReference) roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationAccessibleByRoles() {
		return operationAccessibleByRolesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationAccessibleByRoles_Role() {
		return (EReference) operationAccessibleByRolesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationAccessibleByRoles_Operation() {
		return (EReference) operationAccessibleByRolesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationAccessibleByRoles_Operationprovidedrole() {
		return (EReference) operationAccessibleByRolesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessControlCheckingOperation() {
		return accessControlCheckingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlCheckingOperation_Operation() {
		return (EReference) accessControlCheckingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlCheckingOperation_RoleDetermining() {
		return (EReference) accessControlCheckingOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlCheckingOperation_Operationprovidedrole() {
		return (EReference) accessControlCheckingOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlCheckingOperation_Identity() {
		return (EReference) accessControlCheckingOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAlternativeEncoding() {
		return alternativeEncodingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAlternativeEncoding_DataType() {
		return (EReference) alternativeEncodingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlternativeEncoding_Content() {
		return (EAttribute) alternativeEncodingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rbac4smartcontractsFactory getRbac4smartcontractsFactory() {
		return (Rbac4smartcontractsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		accessControl4SmartContractsRepositoryEClass = createEClass(ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY);
		createEReference(accessControl4SmartContractsRepositoryEClass,
				ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES);
		createEReference(accessControl4SmartContractsRepositoryEClass,
				ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE);
		createEReference(accessControl4SmartContractsRepositoryEClass,
				ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__ALTERNATIVE_ENCODING);

		operationAccessibleByRolesEClass = createEClass(OPERATION_ACCESSIBLE_BY_ROLES);
		createEReference(operationAccessibleByRolesEClass, OPERATION_ACCESSIBLE_BY_ROLES__ROLE);
		createEReference(operationAccessibleByRolesEClass, OPERATION_ACCESSIBLE_BY_ROLES__OPERATION);
		createEReference(operationAccessibleByRolesEClass, OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE);

		accessControlCheckingOperationEClass = createEClass(ACCESS_CONTROL_CHECKING_OPERATION);
		createEReference(accessControlCheckingOperationEClass, ACCESS_CONTROL_CHECKING_OPERATION__OPERATION);
		createEReference(accessControlCheckingOperationEClass, ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING);
		createEReference(accessControlCheckingOperationEClass,
				ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE);
		createEReference(accessControlCheckingOperationEClass, ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY);

		alternativeEncodingEClass = createEClass(ALTERNATIVE_ENCODING);
		createEReference(alternativeEncodingEClass, ALTERNATIVE_ENCODING__DATA_TYPE);
		createEAttribute(alternativeEncodingEClass, ALTERNATIVE_ENCODING__CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasicPackage theBasicPackage = (BasicPackage) EPackage.Registry.INSTANCE.getEPackage(BasicPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		roleEClass.getESuperTypes().add(theBasicPackage.getEntity());

		// Initialize classes, features, and operations; add parameters
		initEClass(accessControl4SmartContractsRepositoryEClass, AccessControl4SmartContractsRepository.class,
				"AccessControl4SmartContractsRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessControl4SmartContractsRepository_Roles(), this.getRole(), null, "roles", null, 0, -1,
				AccessControl4SmartContractsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControl4SmartContractsRepository_AccessibleOperationsByRole(),
				this.getOperationAccessibleByRoles(), null, "accessibleOperationsByRole", null, 0, -1,
				AccessControl4SmartContractsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControl4SmartContractsRepository_AccOperationDefs(),
				this.getAccessControlCheckingOperation(), null, "accOperationDefs", null, 1, 1,
				AccessControl4SmartContractsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_AlternativeEncoding(), this.getAlternativeEncoding(), null, "alternativeEncoding", null,
				0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationAccessibleByRolesEClass, OperationAccessibleByRoles.class, "OperationAccessibleByRoles",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationAccessibleByRoles_Role(), this.getRole(), null, "role", null, 1, -1,
				OperationAccessibleByRoles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationAccessibleByRoles_Operation(), theRepositoryPackage.getOperationSignature(), null,
				"operation", null, 1, 1, OperationAccessibleByRoles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationAccessibleByRoles_Operationprovidedrole(),
				theRepositoryPackage.getOperationProvidedRole(), null, "operationprovidedrole", null, 1, 1,
				OperationAccessibleByRoles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessControlCheckingOperationEClass, AccessControlCheckingOperation.class,
				"AccessControlCheckingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessControlCheckingOperation_Operation(), theRepositoryPackage.getOperationSignature(),
				null, "operation", null, 1, 1, AccessControlCheckingOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlCheckingOperation_RoleDetermining(), theRepositoryPackage.getParameter(), null,
				"roleDetermining", null, 0, 1, AccessControlCheckingOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlCheckingOperation_Operationprovidedrole(),
				theRepositoryPackage.getOperationProvidedRole(), null, "operationprovidedrole", null, 1, 1,
				AccessControlCheckingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlCheckingOperation_Identity(), theRepositoryPackage.getParameter(), null,
				"identity", null, 0, 1, AccessControlCheckingOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternativeEncodingEClass, AlternativeEncoding.class, "AlternativeEncoding", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternativeEncoding_DataType(), theRepositoryPackage.getDataType(), null, "dataType", null, 1,
				1, AlternativeEncoding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlternativeEncoding_Content(), theEcorePackage.getEString(), "content", null, 1, 1,
				AlternativeEncoding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Rbac4smartcontractsPackageImpl
