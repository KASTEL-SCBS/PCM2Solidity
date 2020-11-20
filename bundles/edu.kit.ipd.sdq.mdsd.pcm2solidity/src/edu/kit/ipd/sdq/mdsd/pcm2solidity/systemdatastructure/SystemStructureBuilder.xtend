package edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure

import org.palladiosimulator.pcm.system.System
import java.util.ArrayList
import java.util.Collection
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.AssemblyConnector

class SystemStructureBuilder {
	System system;
	
	def Collection<SystemComponent> generateSystemComponents(System system){
		this.system = system;
		var components = new ArrayList<SystemComponent>;
		
		components.generateSingleComponents;
		
		components.connectComponents;
		
		
		return components;
	}

	
	private def generateSingleComponents(Collection<SystemComponent> componentsToFill){
		for(assemblyContext : system.assemblyContexts__ComposedStructure){
			addContextToComponentOrCreate(componentsToFill, assemblyContext);
		}
	}
	
	
	private def addContextToComponentOrCreate(Collection<SystemComponent> components, AssemblyContext assemblycontext){
		
		var foundComponents = getFittingComponent(components, assemblycontext);
		if(foundComponents.empty){
			components.add(new SystemComponent(assemblycontext));
		} else if (foundComponents.size == 1){
			foundComponents.get(0).addAssociatedContext(assemblycontext);
		} 
		
		return;
	}
	
		
	private def connectComponents(ArrayList<SystemComponent> components) {
		for(assemblyContext : system.assemblyContexts__ComposedStructure){
			for(systemComponent : components){
				if(systemComponent.isAssociatedWith(assemblyContext)){
					connectWithOtherComponents(components, assemblyContext, systemComponent);
				}
			}
		}
	}
	
	private def connectWithOtherComponents(ArrayList<SystemComponent> components, AssemblyContext context, SystemComponent targetComponent){
		for( connector : system.connectors__ComposedStructure){
			if(connector instanceof AssemblyConnector && 
				(connector as AssemblyConnector)
				.requiringAssemblyContext_AssemblyConnector
				.encapsulatedComponent__AssemblyContext.id.equals(targetComponent.componentId)){
				
				var providingComponent = findSystemComponentForContext(components, (connector as AssemblyConnector).providingAssemblyContext_AssemblyConnector);
				targetComponent.addCalledComponent(providingComponent);
			}
		}
	}
	
	
	private def Iterable<SystemComponent> getFittingComponent(Collection<SystemComponent> components, AssemblyContext assemblyContext){
		return components.filter[c | c.componentId.equals(assemblyContext.encapsulatedComponent__AssemblyContext.id)]
	}
	
	private def SystemComponent findSystemComponentForContext(Collection<SystemComponent> components, AssemblyContext assemblyContext){
		var found = getFittingComponent(components, assemblyContext);
		return found.get(0);
	}
	
}