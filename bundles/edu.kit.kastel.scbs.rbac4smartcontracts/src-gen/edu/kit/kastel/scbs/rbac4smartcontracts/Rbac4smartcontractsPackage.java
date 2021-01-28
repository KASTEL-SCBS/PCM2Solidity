/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import edu.kit.ipd.sdq.composition.securityanalyses.basic.BasicPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsFactory
 * @model kind="package"
 * @generated
 */
public interface Rbac4smartcontractsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rbac4smartcontracts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/rbac4smartcontracts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rbac4smartcontracts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Rbac4smartcontractsPackage eINSTANCE = edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl <em>Access Control4 Smart Contracts Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAccessControl4SmartContractsRepository()
	 * @generated
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES = 0;

	/**
	 * The feature id for the '<em><b>Accessible Operations By Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE = 1;

	/**
	 * The feature id for the '<em><b>Acc Operation Defs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS = 2;

	/**
	 * The number of structural features of the '<em>Access Control4 Smart Contracts Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Access Control4 Smart Contracts Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.RoleImpl
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = BasicPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = BasicPackage.ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Alternative Encoding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ALTERNATIVE_ENCODING = BasicPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = BasicPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = BasicPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl <em>Operation Accessible By Roles</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getOperationAccessibleByRoles()
	 * @generated
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES = 2;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES__ROLE = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES__OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Operationprovidedrole</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE = 2;

	/**
	 * The number of structural features of the '<em>Operation Accessible By Roles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Accessible By Roles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ACCESSIBLE_BY_ROLES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl <em>Access Control Checking Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAccessControlCheckingOperation()
	 * @generated
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Role Determining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING = 1;

	/**
	 * The feature id for the '<em><b>Operationprovidedrole</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE = 2;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY = 3;

	/**
	 * The number of structural features of the '<em>Access Control Checking Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Access Control Checking Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHECKING_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AlternativeEncodingImpl <em>Alternative Encoding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AlternativeEncodingImpl
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAlternativeEncoding()
	 * @generated
	 */
	int ALTERNATIVE_ENCODING = 4;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_ENCODING__DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_ENCODING__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Alternative Encoding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_ENCODING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Alternative Encoding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_ENCODING_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository <em>Access Control4 Smart Contracts Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control4 Smart Contracts Repository</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
	 * @generated
	 */
	EClass getAccessControl4SmartContractsRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getRoles()
	 * @see #getAccessControl4SmartContractsRepository()
	 * @generated
	 */
	EReference getAccessControl4SmartContractsRepository_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccessibleOperationsByRole <em>Accessible Operations By Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Accessible Operations By Role</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccessibleOperationsByRole()
	 * @see #getAccessControl4SmartContractsRepository()
	 * @generated
	 */
	EReference getAccessControl4SmartContractsRepository_AccessibleOperationsByRole();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccOperationDefs <em>Acc Operation Defs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acc Operation Defs</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccOperationDefs()
	 * @see #getAccessControl4SmartContractsRepository()
	 * @generated
	 */
	EReference getAccessControl4SmartContractsRepository_AccOperationDefs();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.scbs.rbac4smartcontracts.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.Role#getAlternativeEncoding <em>Alternative Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alternative Encoding</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Role#getAlternativeEncoding()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_AlternativeEncoding();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles <em>Operation Accessible By Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Accessible By Roles</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles
	 * @generated
	 */
	EClass getOperationAccessibleByRoles();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Role</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getRole()
	 * @see #getOperationAccessibleByRoles()
	 * @generated
	 */
	EReference getOperationAccessibleByRoles_Role();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperation()
	 * @see #getOperationAccessibleByRoles()
	 * @generated
	 */
	EReference getOperationAccessibleByRoles_Operation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperationprovidedrole <em>Operationprovidedrole</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operationprovidedrole</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperationprovidedrole()
	 * @see #getOperationAccessibleByRoles()
	 * @generated
	 */
	EReference getOperationAccessibleByRoles_Operationprovidedrole();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation <em>Access Control Checking Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control Checking Operation</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation
	 * @generated
	 */
	EClass getAccessControlCheckingOperation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperation()
	 * @see #getAccessControlCheckingOperation()
	 * @generated
	 */
	EReference getAccessControlCheckingOperation_Operation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getRoleDetermining <em>Role Determining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role Determining</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getRoleDetermining()
	 * @see #getAccessControlCheckingOperation()
	 * @generated
	 */
	EReference getAccessControlCheckingOperation_RoleDetermining();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperationprovidedrole <em>Operationprovidedrole</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operationprovidedrole</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperationprovidedrole()
	 * @see #getAccessControlCheckingOperation()
	 * @generated
	 */
	EReference getAccessControlCheckingOperation_Operationprovidedrole();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identity</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getIdentity()
	 * @see #getAccessControlCheckingOperation()
	 * @generated
	 */
	EReference getAccessControlCheckingOperation_Identity();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding <em>Alternative Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Encoding</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding
	 * @generated
	 */
	EClass getAlternativeEncoding();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getDataType()
	 * @see #getAlternativeEncoding()
	 * @generated
	 */
	EReference getAlternativeEncoding_DataType();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getContent()
	 * @see #getAlternativeEncoding()
	 * @generated
	 */
	EAttribute getAlternativeEncoding_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Rbac4smartcontractsFactory getRbac4smartcontractsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl <em>Access Control4 Smart Contracts Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAccessControl4SmartContractsRepository()
		 * @generated
		 */
		EClass ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY = eINSTANCE.getAccessControl4SmartContractsRepository();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES = eINSTANCE
				.getAccessControl4SmartContractsRepository_Roles();

		/**
		 * The meta object literal for the '<em><b>Accessible Operations By Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE = eINSTANCE
				.getAccessControl4SmartContractsRepository_AccessibleOperationsByRole();

		/**
		 * The meta object literal for the '<em><b>Acc Operation Defs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS = eINSTANCE
				.getAccessControl4SmartContractsRepository_AccOperationDefs();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.RoleImpl
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Alternative Encoding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__ALTERNATIVE_ENCODING = eINSTANCE.getRole_AlternativeEncoding();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl <em>Operation Accessible By Roles</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getOperationAccessibleByRoles()
		 * @generated
		 */
		EClass OPERATION_ACCESSIBLE_BY_ROLES = eINSTANCE.getOperationAccessibleByRoles();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_ACCESSIBLE_BY_ROLES__ROLE = eINSTANCE.getOperationAccessibleByRoles_Role();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_ACCESSIBLE_BY_ROLES__OPERATION = eINSTANCE.getOperationAccessibleByRoles_Operation();

		/**
		 * The meta object literal for the '<em><b>Operationprovidedrole</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE = eINSTANCE
				.getOperationAccessibleByRoles_Operationprovidedrole();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl <em>Access Control Checking Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAccessControlCheckingOperation()
		 * @generated
		 */
		EClass ACCESS_CONTROL_CHECKING_OPERATION = eINSTANCE.getAccessControlCheckingOperation();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CHECKING_OPERATION__OPERATION = eINSTANCE
				.getAccessControlCheckingOperation_Operation();

		/**
		 * The meta object literal for the '<em><b>Role Determining</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING = eINSTANCE
				.getAccessControlCheckingOperation_RoleDetermining();

		/**
		 * The meta object literal for the '<em><b>Operationprovidedrole</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE = eINSTANCE
				.getAccessControlCheckingOperation_Operationprovidedrole();

		/**
		 * The meta object literal for the '<em><b>Identity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY = eINSTANCE.getAccessControlCheckingOperation_Identity();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AlternativeEncodingImpl <em>Alternative Encoding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.AlternativeEncodingImpl
		 * @see edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsPackageImpl#getAlternativeEncoding()
		 * @generated
		 */
		EClass ALTERNATIVE_ENCODING = eINSTANCE.getAlternativeEncoding();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE_ENCODING__DATA_TYPE = eINSTANCE.getAlternativeEncoding_DataType();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALTERNATIVE_ENCODING__CONTENT = eINSTANCE.getAlternativeEncoding_Content();

	}

} //Rbac4smartcontractsPackage
