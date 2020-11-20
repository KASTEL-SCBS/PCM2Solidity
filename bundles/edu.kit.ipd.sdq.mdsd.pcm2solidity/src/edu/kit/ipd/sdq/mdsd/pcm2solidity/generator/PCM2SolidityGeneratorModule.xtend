package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGeneratorModule

class PCM2SolidityGeneratorModule extends AbstractEcore2TxtGeneratorModule{
	override protected String getLanguageName() {
		return ""
	}

	override protected String getFileExtensions() {
		return "repository"
	}
}