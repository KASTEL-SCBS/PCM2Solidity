/**
 */
package edu.kit.kastel.scbs.rbac4smartcontracts.impl;

import edu.kit.ipd.sdq.composition.securityanalyses.basic.impl.EntityImpl;

import edu.kit.kastel.scbs.rbac4smartcontracts.AlternativeEncoding;
import edu.kit.kastel.scbs.rbac4smartcontracts.Rbac4smartcontractsPackage;
import edu.kit.kastel.scbs.rbac4smartcontracts.Role;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.scbs.rbac4smartcontracts.impl.RoleImpl#getAlternativeEncoding <em>Alternative Encoding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleImpl extends EntityImpl implements Role {
	/**
	 * The cached value of the '{@link #getAlternativeEncoding() <em>Alternative Encoding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativeEncoding()
	 * @generated
	 * @ordered
	 */
	protected AlternativeEncoding alternativeEncoding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Rbac4smartcontractsPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlternativeEncoding getAlternativeEncoding() {
		return alternativeEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlternativeEncoding(AlternativeEncoding newAlternativeEncoding,
			NotificationChain msgs) {
		AlternativeEncoding oldAlternativeEncoding = alternativeEncoding;
		alternativeEncoding = newAlternativeEncoding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING, oldAlternativeEncoding,
					newAlternativeEncoding);
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
	public void setAlternativeEncoding(AlternativeEncoding newAlternativeEncoding) {
		if (newAlternativeEncoding != alternativeEncoding) {
			NotificationChain msgs = null;
			if (alternativeEncoding != null)
				msgs = ((InternalEObject) alternativeEncoding).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING, null, msgs);
			if (newAlternativeEncoding != null)
				msgs = ((InternalEObject) newAlternativeEncoding).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING, null, msgs);
			msgs = basicSetAlternativeEncoding(newAlternativeEncoding, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING,
					newAlternativeEncoding, newAlternativeEncoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING:
			return basicSetAlternativeEncoding(null, msgs);
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
		case Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING:
			return getAlternativeEncoding();
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
		case Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING:
			setAlternativeEncoding((AlternativeEncoding) newValue);
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
		case Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING:
			setAlternativeEncoding((AlternativeEncoding) null);
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
		case Rbac4smartcontractsPackage.ROLE__ALTERNATIVE_ENCODING:
			return alternativeEncoding != null;
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl
