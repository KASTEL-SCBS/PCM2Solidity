pragma solidity ^0.5.0;


import "./AccessCtrl.sol"

contract SingleAuction{
	
	AccessCtrl accessCtrl
	//Modifiable by: Bidder, Seller
	bool auctionClosed; //TODO: Auto-generated Field
	//Modifiable by: Nothing
	address manager_address; //TODO: Auto-generated Field
	//Modifiable by: Nothing
	address seller_address; //TODO: Auto-generated Field
	//Modifiable by: Manager
	address[] bidders; //TODO: Auto-generated Field
	
	
	
	/// @notice postcondition auctionClosed == __verifier_old_bool(auctionClosed)
	/// @notice postcondition manager_address == __verifier_old_address(manager_address)
	/// @notice postcondition seller_address == __verifier_old_address(seller_address)
	function emergencyShutdown() public onlyManager {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	
	/// @notice postcondition manager_address == __verifier_old_address(manager_address)
	/// @notice postcondition seller_address == __verifier_old_address(seller_address)
	/// @notice postcondition forall (uint i) (!( 0 <= i && i < bidders.length) || bidders[i] == __verifier_old_address(bidders[i]))
	function bid(int value) public onlyBidder {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	
	/// @notice postcondition manager_address == __verifier_old_address(manager_address)
	/// @notice postcondition seller_address == __verifier_old_address(seller_address)
	/// @notice postcondition forall (uint i) (!( 0 <= i && i < bidders.length) || bidders[i] == __verifier_old_address(bidders[i]))
	function withdraw() public onlyBidder {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	
	/// @notice postcondition auctionClosed == __verifier_old_bool(auctionClosed)
	/// @notice postcondition manager_address == __verifier_old_address(manager_address)
	/// @notice postcondition seller_address == __verifier_old_address(seller_address)
	/// @notice postcondition forall (uint i) (!( 0 <= i && i < bidders.length) || bidders[i] == __verifier_old_address(bidders[i]))
	function sellerWithdraw() public  {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	
	/// @notice postcondition manager_address == __verifier_old_address(manager_address)
	/// @notice postcondition seller_address == __verifier_old_address(seller_address)
	/// @notice postcondition forall (uint i) (!( 0 <= i && i < bidders.length) || bidders[i] == __verifier_old_address(bidders[i]))
	function close() public onlyBidderSeller returns (bool output){
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	modifier onlyBidder {
		require(accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.BIDDER),
					"Access denied");
		_;
	}
	modifier onlyBidderSeller {
		
		require(accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.SELLER) || 
		accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.BIDDER),
					"Access denied");
		_;
	}
	modifier onlyManager {
		require(accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.MANAGER),
					"Access denied");
		_;
	}
				
}