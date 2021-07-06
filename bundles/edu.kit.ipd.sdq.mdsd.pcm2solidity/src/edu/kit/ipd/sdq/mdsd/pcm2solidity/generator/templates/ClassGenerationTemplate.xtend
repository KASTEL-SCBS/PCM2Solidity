package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates

import org.palladiosimulator.pcm.repository.BasicComponent

abstract class ClassGenerationTemplate implements M2TGenerator, ComponentUsing {
	// Integrated a setter for the used "current target". 
	// However, currently bad idea, because we use the template for statically building the Access Control without basic component --> refused bequest
	// Workaround: Instead of generating the file directly, generate the Access Control Model Elements and integrate them in the assembly.
	
	public override String generate() {
		return '''
		«generatePackage»
		«generateImports»
		«generateDeclaration»{
			«generateFields»
			«generateConstructors»
			«generateMethods»
		}'''
	}

	protected def String generatePackage();

	protected def String generateImports();

	protected def String generateDeclaration();

	protected def String generateConstructors();

	protected def String generateFields();

	protected def String generateMethods();
	
	
}
