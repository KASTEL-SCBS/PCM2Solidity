/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Accessible By Roles</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getRole <em>Role</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperationprovidedrole <em>Operationprovidedrole</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getOperationAccessibleByRoles()
 * @model
 * @generated
 */
public interface OperationAccessibleByRoles extends EObject {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.scbs.rbac4smartcontracts.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference list.
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getOperationAccessibleByRoles_Role()
	 * @model required="true"
	 * @generated
	 */
	EList<Role> getRole();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(OperationSignature)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getOperationAccessibleByRoles_Operation()
	 * @model required="true"
	 * @generated
	 */
	OperationSignature getOperation();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(OperationSignature value);

	/**
	 * Returns the value of the '<em><b>Operationprovidedrole</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operationprovidedrole</em>' reference.
	 * @see #setOperationprovidedrole(OperationProvidedRole)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getOperationAccessibleByRoles_Operationprovidedrole()
	 * @model required="true"
	 * @generated
	 */
	OperationProvidedRole getOperationprovidedrole();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles#getOperationprovidedrole <em>Operationprovidedrole</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operationprovidedrole</em>' reference.
	 * @see #getOperationprovidedrole()
	 * @generated
	 */
	void setOperationprovidedrole(OperationProvidedRole value);

} // OperationAccessibleByRoles
