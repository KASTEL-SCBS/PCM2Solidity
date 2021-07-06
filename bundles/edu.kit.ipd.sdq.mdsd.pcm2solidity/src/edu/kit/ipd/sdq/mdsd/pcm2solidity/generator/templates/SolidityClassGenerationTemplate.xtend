package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates

abstract class SolidityClassGenerationTemplate extends ClassGenerationTemplate {
	
	public override String generate(){
		return 
		'''
		«generatePragma»
		
		«generateImports»
		
		«generateDeclaration»{
			
			«generateFields»
			
			«generateConstructors»
			
			«generateMethods»
			
			«generateModifiers»
		}'''
	}
	
	protected def String generatePragma();
	protected def String generateModifiers();
	
}