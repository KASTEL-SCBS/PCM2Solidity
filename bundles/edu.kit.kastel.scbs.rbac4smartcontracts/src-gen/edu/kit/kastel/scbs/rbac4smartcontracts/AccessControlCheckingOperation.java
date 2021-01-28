/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control Checking Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getRoleDetermining <em>Role Determining</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperationprovidedrole <em>Operationprovidedrole</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getIdentity <em>Identity</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControlCheckingOperation()
 * @model
 * @generated
 */
public interface AccessControlCheckingOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(OperationSignature)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControlCheckingOperation_Operation()
	 * @model required="true"
	 * @generated
	 */
	OperationSignature getOperation();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(OperationSignature value);

	/**
	 * Returns the value of the '<em><b>Role Determining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Determining</em>' reference.
	 * @see #setRoleDetermining(Parameter)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControlCheckingOperation_RoleDetermining()
	 * @model
	 * @generated
	 */
	Parameter getRoleDetermining();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getRoleDetermining <em>Role Determining</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Determining</em>' reference.
	 * @see #getRoleDetermining()
	 * @generated
	 */
	void setRoleDetermining(Parameter value);

	/**
	 * Returns the value of the '<em><b>Operationprovidedrole</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operationprovidedrole</em>' reference.
	 * @see #setOperationprovidedrole(OperationProvidedRole)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControlCheckingOperation_Operationprovidedrole()
	 * @model required="true"
	 * @generated
	 */
	OperationProvidedRole getOperationprovidedrole();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getOperationprovidedrole <em>Operationprovidedrole</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operationprovidedrole</em>' reference.
	 * @see #getOperationprovidedrole()
	 * @generated
	 */
	void setOperationprovidedrole(OperationProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identity</em>' reference.
	 * @see #setIdentity(Parameter)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAccessControlCheckingOperation_Identity()
	 * @model
	 * @generated
	 */
	Parameter getIdentity();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation#getIdentity <em>Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identity</em>' reference.
	 * @see #getIdentity()
	 * @generated
	 */
	void setIdentity(Parameter value);

} // AccessControlCheckingOperation
