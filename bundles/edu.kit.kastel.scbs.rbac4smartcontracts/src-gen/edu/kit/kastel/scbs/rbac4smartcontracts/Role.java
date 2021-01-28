/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import edu.kit.ipd.sdq.composition.securityanalyses.basic.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.Role#getAlternativeEncoding <em>Alternative Encoding</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Alternative Encoding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Encoding</em>' containment reference.
	 * @see #setAlternativeEncoding(AlternativeEncoding)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getRole_AlternativeEncoding()
	 * @model containment="true"
	 * @generated
	 */
	AlternativeEncoding getAlternativeEncoding();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.Role#getAlternativeEncoding <em>Alternative Encoding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternative Encoding</em>' containment reference.
	 * @see #getAlternativeEncoding()
	 * @generated
	 */
	void setAlternativeEncoding(AlternativeEncoding value);

} // Role
