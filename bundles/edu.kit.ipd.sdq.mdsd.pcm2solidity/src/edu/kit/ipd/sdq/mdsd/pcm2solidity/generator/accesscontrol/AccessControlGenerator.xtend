package edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol

import edu.kit.kastel.scbs.rbac4smartcontracts.AccessControl4SmartContractsRepository
import org.eclipse.xtend.lib.annotations.Accessors
import edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.templates.SolidityClassGenerationTemplate
import static extension edu.kit.ipd.sdq.mdsd.pcm2solidity.util.PCM2SolidityConstants.getSolidityVersion;
import org.palladiosimulator.pcm.repository.BasicComponent

class AccessControlGenerator extends SolidityClassGenerationTemplate {
	private AccessControl4SmartContractsRepository acRepository;
	private boolean fullAcGeneration;
	
	public static final String accessControlName = '''AccessCtrl''';
	public static final String rolesEnumName = '''Roles''';
	public static final String accessCheckingFunctionName = '''checkAccess'''
	private final String admin = "admin";
	private final String roleMapping = '''mapping(address => bool)'''
	private final String addressName = '''entity'''
	private final String roleName = '''role'''
	private final String standardCheckParameters = '''address «addressName», «rolesEnumName» «roleName»'''
	private final String onlyAdmin = '''onlyAdmin'''

	new(AccessControl4SmartContractsRepository acRepository, boolean fullAcGeneration) {
		this.acRepository = acRepository;
		this.fullAcGeneration = fullAcGeneration;
	}

	override protected generatePackage() {
		return "";
	}
	

	override protected generateImports() {
		return "";
	}

	override protected generateDeclaration() {
		return '''contract AccessCtrl'''
	}

	override protected generateConstructors() {
		return 
		'''constructor(«IF fullAcGeneration»address admin«ENDIF»){
	«IF fullAcGeneration»
	«admin.toLowerCase»s[admin] = true;
«ELSE» //TODO: Implement constructur
«ENDIF»}'''
	}

	override protected generateFields() {
		
		var roleEnum = generateRoleEnum;
		var mappings = generateMappings;
		
		return '''
	«roleEnum»
		
	«mappings»
		'''	
	}
	

	
	
	private def String generateRoleEnum() {
		return '''enum «rolesEnumName» {«generateEnumRoles()»}'''
	}

	private def String generateEnumRoles() {
			
		var standardRoles = '''«FOR role : acRepository.roles SEPARATOR ", "»«role.name.toUpperCase»«ENDFOR»'''
		
		return standardRoles + adminIfFullAccessControlGeneration();
	}
	
	private def String adminIfFullAccessControlGeneration(){
		return  if (fullAcGeneration) ''', «admin.toUpperCase»''' else "";
	}
	
	def protected generateMappings() {
		return '''
		«IF fullAcGeneration»
			«FOR role : acRepository.roles SEPARATOR "\n"»«roleMapping» «role.name.toLowerCase»s;«ENDFOR»
			«roleMapping» «admin.toLowerCase»s;
«ELSE»«""»
«ENDIF»'''
	}

	override protected generateMethods() {
		return '''
		«generateCheckAccess» 
		
«IF fullAcGeneration»
	«generateAddToRole» 
			
	«generateRemoveFromRole» 
«ENDIF»
		'''
	}
	
	
	
	private def String generateCheckAccess() '''
		public function «edu.kit.ipd.sdq.mdsd.pcm2solidity.generator.accesscontrol.AccessControlGenerator.accessCheckingFunctionName»(«standardCheckParameters») returns (bool result) {
			«IF fullAcGeneration»
				«FOR role : acRepository.roles»
				«genericRoleCheckingBuilder(role.name, '''return «role.name.toLowerCase»s[«addressName»];''')»
			«ENDFOR»
				«genericRoleCheckingBuilder(admin, '''return «admin.toLowerCase»s[«addressName»];''')»
«ELSE» //TODO: Implement
«ENDIF»}
		'''
	
	//Not Nice but avoids some copy&pasting
	private def String genericRoleCheckingBuilder(String targetRoleName, String caseBody)'''
	if(«roleName» == «targetRoleName.toUpperCase»){
		«caseBody»
	}
	'''
	
	private def String generateAddToRole()'''
		public function addToRole(«standardCheckParameters») «onlyAdmin» {
			«IF fullAcGeneration»
			«FOR role : acRepository.roles»
				«genericRoleCheckingBuilder(role.name, '''«role.name.toLowerCase»s[«addressName»] = true;''')»
			«ENDFOR»
			«genericRoleCheckingBuilder(admin, '''«admin.toLowerCase»s[«addressName»] = true;''')»
«ELSE» //TODO: Implement
«ENDIF»}
	'''
	
	private def String generateRemoveFromRole()'''
		public function addToRole(«standardCheckParameters») «onlyAdmin» {
			«IF fullAcGeneration»
			«FOR role : acRepository.roles»
				«genericRoleCheckingBuilder(role.name, '''«role.name.toLowerCase»s[«addressName»] = false;''')»
			«ENDFOR»
			«genericRoleCheckingBuilder(admin, '''«admin.toLowerCase»s[«addressName»] = false;''')»
«ELSE» //TODO: Implement
«ENDIF»}
	'''

	override protected generateModifiers() '''
	«IF fullAcGeneration»
	modifier «onlyAdmin» {
		require(«admin»s[msg.sender] == true, "Access denied");
		_;
	}
	«ELSE»«""»
	«ENDIF»
	
	'''
	
	override protected generatePragma() {
		return '''pragma solidity «solidityVersion»;''';
	}
	
	//TODO: Refused Bequest --> Use different design approach. See @ClassGenerationTemplate.xtend 
	override setCurrentTarget(BasicComponent component) {
		return;
	}
	
}
