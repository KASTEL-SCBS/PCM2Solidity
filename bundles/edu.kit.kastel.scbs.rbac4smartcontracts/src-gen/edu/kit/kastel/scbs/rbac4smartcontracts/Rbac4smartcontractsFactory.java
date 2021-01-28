/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage
 * @generated
 */
public interface Rbac4smartcontractsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Rbac4smartcontractsFactory eINSTANCE = edu.kit.kastel.scbs.rbac4smartcontracts.impl.Rbac4smartcontractsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Access Control4 Smart Contracts Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Control4 Smart Contracts Repository</em>'.
	 * @generated
	 */
	AccessControl4SmartContractsRepository createAccessControl4SmartContractsRepository();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns a new object of class '<em>Operation Accessible By Roles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Accessible By Roles</em>'.
	 * @generated
	 */
	OperationAccessibleByRoles createOperationAccessibleByRoles();

	/**
	 * Returns a new object of class '<em>Access Control Checking Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Control Checking Operation</em>'.
	 * @generated
	 */
	AccessControlCheckingOperation createAccessControlCheckingOperation();

	/**
	 * Returns a new object of class '<em>Alternative Encoding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative Encoding</em>'.
	 * @generated
	 */
	AlternativeEncoding createAlternativeEncoding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Rbac4smartcontractsPackage getRbac4smartcontractsPackage();

} //Rbac4smartcontractsFactory
