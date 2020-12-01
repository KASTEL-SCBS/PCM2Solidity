package edu.kit.ipd.sdq.mdsd.pcm2solidity.util

import org.palladiosimulator.pcm.repository.RepositoryComponent
import org.palladiosimulator.pcm.repository.OperationSignature
import java.util.Collection
import org.palladiosimulator.pcm.repository.OperationRequiredRole
import org.palladiosimulator.pcm.repository.OperationProvidedRole
import edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure.SystemComponent

class PCMLookupUtil {
	private new(){
		
	}
	
	static def Collection<OperationSignature> getAllRequiredOperationsFromComponent(RepositoryComponent component){
		return component.requiredRoles_InterfaceRequiringEntity.filter(OperationRequiredRole).map[it.requiredInterface__OperationRequiredRole].map[it.signatures__OperationInterface].flatten.toList;
	}
	
	static def Collection<OperationSignature> getAllProvidedOperationsFromComponent(RepositoryComponent component){
		return component.providedRoles_InterfaceProvidingEntity.filter(OperationProvidedRole).map[it.providedInterface__OperationProvidedRole].map[it.signatures__OperationInterface].flatten.toList;
	}
	
	static def SystemComponent findSystemComponentForCurrentTargetComponent(Collection<SystemComponent> systemComponents, RepositoryComponent targetComponent) {
		return systemComponents.findFirst[component|component.componentId.equals(targetComponent.id)];
	}
}