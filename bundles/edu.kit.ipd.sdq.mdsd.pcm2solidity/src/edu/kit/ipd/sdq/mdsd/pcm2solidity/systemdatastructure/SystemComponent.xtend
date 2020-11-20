package edu.kit.ipd.sdq.mdsd.pcm2solidity.systemdatastructure

import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import java.util.Collection
import java.util.ArrayList
import org.palladiosimulator.pcm.repository.RepositoryComponent
import java.util.Set
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors

class SystemComponent {
	@Accessors(PUBLIC_GETTER) RepositoryComponent repositoryComponent;
	private Set<AssemblyContext> associatedContexts;
	@Accessors(PUBLIC_GETTER) Set<SystemComponent> componentsRequiredForCalls;
	
	public new (RepositoryComponent repositoryComponent, Set<AssemblyContext> associatedContexts, Set<SystemComponent> componentsRequiredForCalls){
		this.repositoryComponent = repositoryComponent;
		this.associatedContexts = associatedContexts;
		this.componentsRequiredForCalls = componentsRequiredForCalls;
	}
	
	public new (AssemblyContext context){
		this.repositoryComponent = context.encapsulatedComponent__AssemblyContext;
		this.associatedContexts = new HashSet<AssemblyContext>;
		associatedContexts.add(context);
		this.componentsRequiredForCalls = new HashSet<SystemComponent>;
	}
	
	
	public new (RepositoryComponent repositoryComponent){
		this.repositoryComponent = repositoryComponent;
		this.associatedContexts = new HashSet<AssemblyContext>;
		this.componentsRequiredForCalls = new HashSet<SystemComponent>;
	}
	
	public def String getComponentId(){
		return repositoryComponent.id
	}
	
	public def addAssociatedContext(AssemblyContext assemblyContext){
		associatedContexts.add(assemblyContext);
	}
	
	public def boolean isAssociatedWith(AssemblyContext assemblyContext){
		return associatedContexts.contains(assemblyContext);
	}
	
	public def addCalledComponent(SystemComponent component){
		componentsRequiredForCalls.add(component);
	}
	
	public def getTargetComponentName(){
		return repositoryComponent.entityName;
	}
	
}