/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import edu.kit.kastel.scbs.rbac4smartcontracts.OperationAccessibleByRoles;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage;
import edu.kit.kastel.scbs.rbac4smartcontracts.Role;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Accessible By Roles</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl#getRole <em>Role</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.OperationAccessibleByRolesImpl#getOperationprovidedrole <em>Operationprovidedrole</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationAccessibleByRolesImpl extends MinimalEObjectImpl.Container implements OperationAccessibleByRoles {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> role;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected OperationSignature operation;

	/**
	 * The cached value of the '{@link #getOperationprovidedrole() <em>Operationprovidedrole</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationprovidedrole()
	 * @generated
	 * @ordered
	 */
	protected OperationProvidedRole operationprovidedrole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationAccessibleByRolesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Rbac4smartcontractsPackage.Literals.OPERATION_ACCESSIBLE_BY_ROLES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getRole() {
		if (role == null) {
			role = new EObjectResolvingEList<Role>(Role.class, this,
					Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__ROLE);
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationSignature getOperation() {
		if (operation != null && ((EObject) operation).eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject) operation;
			operation = (OperationSignature) eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION, oldOperation,
							operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(OperationSignature newOperation) {
		OperationSignature oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationProvidedRole getOperationprovidedrole() {
		if (operationprovidedrole != null && ((EObject) operationprovidedrole).eIsProxy()) {
			InternalEObject oldOperationprovidedrole = (InternalEObject) operationprovidedrole;
			operationprovidedrole = (OperationProvidedRole) eResolveProxy(oldOperationprovidedrole);
			if (operationprovidedrole != oldOperationprovidedrole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE,
							oldOperationprovidedrole, operationprovidedrole));
			}
		}
		return operationprovidedrole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationProvidedRole basicGetOperationprovidedrole() {
		return operationprovidedrole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationprovidedrole(OperationProvidedRole newOperationprovidedrole) {
		OperationProvidedRole oldOperationprovidedrole = operationprovidedrole;
		operationprovidedrole = newOperationprovidedrole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE,
					oldOperationprovidedrole, operationprovidedrole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__ROLE:
			return getRole();
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION:
			if (resolve)
				return getOperation();
			return basicGetOperation();
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE:
			if (resolve)
				return getOperationprovidedrole();
			return basicGetOperationprovidedrole();
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
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__ROLE:
			getRole().clear();
			getRole().addAll((Collection<? extends Role>) newValue);
			return;
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION:
			setOperation((OperationSignature) newValue);
			return;
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE:
			setOperationprovidedrole((OperationProvidedRole) newValue);
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
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__ROLE:
			getRole().clear();
			return;
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION:
			setOperation((OperationSignature) null);
			return;
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE:
			setOperationprovidedrole((OperationProvidedRole) null);
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
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__ROLE:
			return role != null && !role.isEmpty();
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATION:
			return operation != null;
		case Rbac4smartcontractsPackage.OPERATION_ACCESSIBLE_BY_ROLES__OPERATIONPROVIDEDROLE:
			return operationprovidedrole != null;
		}
		return super.eIsSet(featureID);
	}

} //OperationAccessibleByRolesImpl
