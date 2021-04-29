package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates

import org.palladiosimulator.pcm.repository.BasicComponent

interface ComponentUsing {
	def void setCurrentTarget(BasicComponent component);
}