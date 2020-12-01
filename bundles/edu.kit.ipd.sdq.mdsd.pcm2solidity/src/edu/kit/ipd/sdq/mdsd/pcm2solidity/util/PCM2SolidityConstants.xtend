package edu.kit.ipd.sdq.mdsd.pcm2solidity.util

import java.io.File

class PCM2SolidityConstants {
	
	private new() {}
	
	static def String getTargetFileExt() '''.sol'''
	
	static def getComponentsTargetName() '''components'''
	
	static def String getTargetFolderPrefix() '''src-gen«getSeparator(false)»'''
	
	static def String getSeparatorAtEnd(boolean pkg) {
		return if (pkg) "" else getSeparator(pkg)
	}
	
	static def String getSolidityVersion() '''^0.5.0'''
	
	static def String getNewLine() '''«System.lineSeparator»'''
	
	static def String roleModifierPrefix() '''only'''
	
	static def String getSeparator(boolean pkg) {
		return if (pkg) "." else File.separator
	}
}