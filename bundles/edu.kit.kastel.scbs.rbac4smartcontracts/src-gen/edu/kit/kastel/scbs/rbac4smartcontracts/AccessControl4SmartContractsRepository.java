/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control4 Smart Contracts Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getRoles <em>Roles</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccessibleOperationsByRole <em>Accessible Operations By Role</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccOperationDefs <em>Acc Operation Defs</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControl4SmartContractsRepository()
 * @model
 * @generated
 */
public interface AccessControl4SmartContractsRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.scbs.rbac4smartcontracts.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControl4SmartContractsRepository_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Accessible Operations By Role</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessible Operations By Role</em>' containment reference list.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControl4SmartContractsRepository_AccessibleOperationsByRole()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationAccessibleByRoles> getAccessibleOperationsByRole();

	/**
	 * Returns the value of the '<em><b>Acc Operation Defs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Operation Defs</em>' containment reference.
	 * @see #setAccOperationDefs(AccessControlCheckingOperation)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControl4SmartContractsRepository_AccOperationDefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AccessControlCheckingOperation getAccOperationDefs();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository#getAccOperationDefs <em>Acc Operation Defs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Operation Defs</em>' containment reference.
	 * @see #getAccOperationDefs()
	 * @generated
	 */
	void setAccOperationDefs(AccessControlCheckingOperation value);

} // AccessControl4SmartContractsRepository
