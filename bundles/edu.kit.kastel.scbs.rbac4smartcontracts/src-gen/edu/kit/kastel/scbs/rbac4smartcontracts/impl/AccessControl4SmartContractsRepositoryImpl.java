/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository;
import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation;
import edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage;
import edu.kit.kastel.scbs.rbac4smartcontracts.Role;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Control4 Smart Contracts Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl#getAccessibleOperationsByRole <em>Accessible Operations By Role</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControl4SmartContractsRepositoryImpl#getAccOperationDefs <em>Acc Operation Defs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessControl4SmartContractsRepositoryImpl extends MinimalEObjectImpl.Container
		implements AccessControl4SmartContractsRepository {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getAccessibleOperationsByRole() <em>Accessible Operations By Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessibleOperationsByRole()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationAccessibleByRoles> accessibleOperationsByRole;

	/**
	 * The cached value of the '{@link #getAccOperationDefs() <em>Acc Operation Defs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccOperationDefs()
	 * @generated
	 * @ordered
	 */
	protected AccessControlCheckingOperation accOperationDefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControl4SmartContractsRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Rbac4smartcontractsPackage.Literals.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this,
					Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OperationAccessibleByRoles> getAccessibleOperationsByRole() {
		if (accessibleOperationsByRole == null) {
			accessibleOperationsByRole = new EObjectContainmentEList<OperationAccessibleByRoles>(
					OperationAccessibleByRoles.class, this,
					Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE);
		}
		return accessibleOperationsByRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlCheckingOperation getAccOperationDefs() {
		return accOperationDefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccOperationDefs(AccessControlCheckingOperation newAccOperationDefs,
			NotificationChain msgs) {
		AccessControlCheckingOperation oldAccOperationDefs = accOperationDefs;
		accOperationDefs = newAccOperationDefs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS,
					oldAccOperationDefs, newAccOperationDefs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccOperationDefs(AccessControlCheckingOperation newAccOperationDefs) {
		if (newAccOperationDefs != accOperationDefs) {
			NotificationChain msgs = null;
			if (accOperationDefs != null)
				msgs = ((InternalEObject) accOperationDefs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS,
						null, msgs);
			if (newAccOperationDefs != null)
				msgs = ((InternalEObject) newAccOperationDefs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS,
						null, msgs);
			msgs = basicSetAccOperationDefs(newAccOperationDefs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS,
					newAccOperationDefs, newAccOperationDefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES:
			return ((InternalEList<?>) getRoles()).basicRemove(otherEnd, msgs);
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE:
			return ((InternalEList<?>) getAccessibleOperationsByRole()).basicRemove(otherEnd, msgs);
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS:
			return basicSetAccOperationDefs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES:
			return getRoles();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE:
			return getAccessibleOperationsByRole();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS:
			return getAccOperationDefs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES:
			getRoles().clear();
			getRoles().addAll((Collection<? extends Role>) newValue);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE:
			getAccessibleOperationsByRole().clear();
			getAccessibleOperationsByRole().addAll((Collection<? extends OperationAccessibleByRoles>) newValue);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS:
			setAccOperationDefs((AccessControlCheckingOperation) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES:
			getRoles().clear();
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE:
			getAccessibleOperationsByRole().clear();
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS:
			setAccOperationDefs((AccessControlCheckingOperation) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ROLES:
			return roles != null && !roles.isEmpty();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACCESSIBLE_OPERATIONS_BY_ROLE:
			return accessibleOperationsByRole != null && !accessibleOperationsByRole.isEmpty();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL4_SMART_CONTRACTS_REPOSITORY__ACC_OPERATION_DEFS:
			return accOperationDefs != null;
		}
		return super.eIsSet(featureID);
	}

} //AccessControl4SmartContractsRepositoryImpl
