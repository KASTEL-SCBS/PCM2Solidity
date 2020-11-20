package edu.kit.ipd.sdq.mdsd.pcm2solidity.handler

import edu.kit.ipd.sdq.mdsd.ecore2txt.handler.AbstractEcoreIFile2TxtHandler
import edu.kit.ipd.sdq.mdsd.ecore2txt.util.Ecore2TxtUtil
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import java.util.List
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.PCM2SolidityGeneratorModule
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.PCM2SolidityGenerator

class PCM2SolidityHandler extends AbstractEcoreIFile2TxtHandler {
	
	override executeEcore2TxtGenerator(List<IFile> filteredSelection, ExecutionEvent event, String plugInID) throws ExecutionException {
		Ecore2TxtUtil.generateFromSelectedFilesInFolder(filteredSelection, new PCM2SolidityGeneratorModule, new PCM2SolidityGenerator, false, false);
	}
	
	override getPlugInID() '''edu.kit.idp.sdq.mdsd.pcm2solidity'''
	
}