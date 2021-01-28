/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.repository.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Encoding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getDataType <em>Data Type</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAlternativeEncoding()
 * @model
 * @generated
 */
public interface AlternativeEncoding extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(DataType)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAlternativeEncoding_DataType()
	 * @model required="true"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage#getAlternativeEncoding_Content()
	 * @model required="true"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // AlternativeEncoding
