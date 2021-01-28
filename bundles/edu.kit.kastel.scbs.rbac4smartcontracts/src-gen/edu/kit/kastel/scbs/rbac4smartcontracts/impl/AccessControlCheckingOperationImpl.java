/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControlCheckingOperation;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Control Checking Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl#getRoleDetermining <em>Role Determining</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl#getOperationprovidedrole <em>Operationprovidedrole</em>}</li>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.AccessControlCheckingOperationImpl#getIdentity <em>Identity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessControlCheckingOperationImpl extends MinimalEObjectImpl.Container
		implements AccessControlCheckingOperation {
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
	 * The cached value of the '{@link #getRoleDetermining() <em>Role Determining</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleDetermining()
	 * @generated
	 * @ordered
	 */
	protected Parameter roleDetermining;

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
	 * The cached value of the '{@link #getIdentity() <em>Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentity()
	 * @generated
	 * @ordered
	 */
	protected Parameter identity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlCheckingOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Rbac4smartcontractsPackage.Literals.ACCESS_CONTROL_CHECKING_OPERATION;
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
							Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION, oldOperation,
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
					Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getRoleDetermining() {
		if (roleDetermining != null && ((EObject) roleDetermining).eIsProxy()) {
			InternalEObject oldRoleDetermining = (InternalEObject) roleDetermining;
			roleDetermining = (Parameter) eResolveProxy(oldRoleDetermining);
			if (roleDetermining != oldRoleDetermining) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING,
							oldRoleDetermining, roleDetermining));
			}
		}
		return roleDetermining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetRoleDetermining() {
		return roleDetermining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoleDetermining(Parameter newRoleDetermining) {
		Parameter oldRoleDetermining = roleDetermining;
		roleDetermining = newRoleDetermining;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING, oldRoleDetermining,
					roleDetermining));
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
							Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE,
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
					Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE,
					oldOperationprovidedrole, operationprovidedrole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getIdentity() {
		if (identity != null && ((EObject) identity).eIsProxy()) {
			InternalEObject oldIdentity = (InternalEObject) identity;
			identity = (Parameter) eResolveProxy(oldIdentity);
			if (identity != oldIdentity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY, oldIdentity,
							identity));
			}
		}
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetIdentity() {
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentity(Parameter newIdentity) {
		Parameter oldIdentity = identity;
		identity = newIdentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY, oldIdentity, identity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION:
			if (resolve)
				return getOperation();
			return basicGetOperation();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING:
			if (resolve)
				return getRoleDetermining();
			return basicGetRoleDetermining();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE:
			if (resolve)
				return getOperationprovidedrole();
			return basicGetOperationprovidedrole();
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY:
			if (resolve)
				return getIdentity();
			return basicGetIdentity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION:
			setOperation((OperationSignature) newValue);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING:
			setRoleDetermining((Parameter) newValue);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE:
			setOperationprovidedrole((OperationProvidedRole) newValue);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY:
			setIdentity((Parameter) newValue);
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
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION:
			setOperation((OperationSignature) null);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING:
			setRoleDetermining((Parameter) null);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE:
			setOperationprovidedrole((OperationProvidedRole) null);
			return;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY:
			setIdentity((Parameter) null);
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
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATION:
			return operation != null;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__ROLE_DETERMINING:
			return roleDetermining != null;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__OPERATIONPROVIDEDROLE:
			return operationprovidedrole != null;
		case Rbac4smartcontractsPackage.ACCESS_CONTROL_CHECKING_OPERATION__IDENTITY:
			return identity != null;
		}
		return super.eIsSet(featureID);
	}

} //AccessControlCheckingOperationImpl
