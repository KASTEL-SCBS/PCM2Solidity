package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator

import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates.MethodGenerationTemplate
import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.OperationSignature
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.ModifierAndContractGenerator
import org.palladiosimulator.pcm.repository.CollectionDataType
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityNaming.*;
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCMLookupUtil.*;
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.CompositeDataType

class SpecifiedMethodGenerator extends MethodGenerationTemplate {

	private OperationSignature currentSignature;
	private ModifierAndContractGenerator acGenerator;

	new(ModifierAndContractGenerator acGenerator) {
		this.acGenerator = acGenerator;
	}

	override protected generateComments() {
		return acGenerator.generateProofObligationsForOperation(currentSignature);
	}

	override protected generateHeader() {
		val returnType = generateReturn(currentSignature);
		val methodName = currentSignature.getMethodName
		val modifierUsages = acGenerator.generateModifierUsageDefitions(currentSignature)
		val parameterDeclarations = '''«FOR parameter : currentSignature.parameters__OperationSignature SEPARATOR ', '»«parameter.dataType__Parameter.handleDataTypeName» «parameter.getParameterName»«ENDFOR»'''
		val visibility = determineVisibility(currentSignature);
		return '''function «methodName»(«parameterDeclarations») «visibility» «modifierUsages» «returnType»''';
	}
	
	def determineVisibility(OperationSignature signature) {
		return "public"
	}

	override protected generateBody() '''
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
		'''

	private def String generateReturn(OperationSignature opSig) {

		var returnType = opSig.returnType__OperationSignature;

		if (returnType === null) {
			return "";
		}

		var returnedTypes = handleReturnDataType(returnType);

		return '''returns («returnedTypes» output)''';
	}

	private dispatch def String handleDataTypeName(PrimitiveDataType dt) {
		// Not Nice, but for prototyping ok.
		return handleReturnDataType(dt);
	}

	private dispatch def String handleDataTypeName(CompositeDataType dt) {
		if (dt.entityName.toFirstLower.equals("address")) {
			return "address"
		}

		return '''«dt.entityName»'''
	}

	private dispatch def String handleDataTypeName(CollectionDataType dt) {
		// Not Nice, but for prototyping ok.
		return handleReturnDataType(dt);
	}

	private dispatch def String handleReturnDataType(PrimitiveDataType dt) '''«getTargetNameForDataType(dt)»'''

	private dispatch def String handleReturnDataType(CompositeDataType dt) {
		var returnTypes = "";

		if (dt.entityName.toFirstLower.equals("address")) {
			return "address"
		}

		returnTypes = '''«FOR composingType : dt.innerDeclaration_CompositeDataType SEPARATOR ', '»«handleReturnDataType(composingType.datatype_InnerDeclaration)»«ENDFOR»'''
		return returnTypes;
	}

	private dispatch def String handleReturnDataType(CollectionDataType dt) '''«getTargetNameForDataType(dt)»'''
	
	override protected setCurrentTarget(OperationSignature signature) {
		this.currentSignature = signature;
	}
}
