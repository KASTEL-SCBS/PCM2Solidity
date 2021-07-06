pragma solidity ^0.5.0;


contract AccessCtrl{
	
	enum Roles {MANAGER, BIDDER, SELLER, ADMIN}
		
	mapping(address => bool) managers;
	mapping(address => bool) bidders;
	mapping(address => bool) sellers;
	mapping(address => bool) admins;
	
	constructor(address admin){
		admins[admin] = true;
	}
	
	public function checkAccess(address entity, Roles role) returns (bool result) {
		if(role == MANAGER){
			return managers[entity];
		}
		if(role == BIDDER){
			return bidders[entity];
		}
		if(role == SELLER){
			return sellers[entity];
		}
		if(role == ADMIN){
			return admins[entity];
		}
	}
	
	public function addToRole(address entity, Roles role) onlyAdmin {
		if(role == MANAGER){
			managers[entity] = true;
		}
		if(role == BIDDER){
			bidders[entity] = true;
		}
		if(role == SELLER){
			sellers[entity] = true;
		}
		if(role == ADMIN){
			admins[entity] = true;
		}
	}
			
	public function addToRole(address entity, Roles role) onlyAdmin {
		if(role == MANAGER){
			managers[entity] = false;
		}
		if(role == BIDDER){
			bidders[entity] = false;
		}
		if(role == SELLER){
			sellers[entity] = false;
		}
		if(role == ADMIN){
			admins[entity] = false;
		}
	}
	
	modifier onlyAdmin {
		require(admins[msg.sender] == true, "Access denied");
		_;
	}
	
}