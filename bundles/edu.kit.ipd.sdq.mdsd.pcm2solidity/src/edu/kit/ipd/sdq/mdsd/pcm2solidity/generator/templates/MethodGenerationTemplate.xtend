package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates

import org.palladiosimulator.pcm.repository.OperationSignature

abstract class MethodGenerationTemplate implements M2TGenerator {
	
	override generate() '''
	«generateComments()»
	«generateHeader()»{
		«generateBody()»
	}
	'''
	
	protected def String generateComments();
	protected def String generateHeader();
	protected def String generateBody();
	protected def void setCurrentTarget(OperationSignature signature);
	
}
