pragma solidity ^0.5.0;


import "./AccessCtrl.sol"
import "./SingleAuction.sol";

contract AuctionManager{
	
	SingleAuction singleAuction; //TODO: Auto-generated Field
	AccessCtrl accessCtrl
	
	
	function createNewAuction(Item item, int expiration) public onlyBidderSeller {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}
	
	modifier onlyBidderSeller {
		
		require(accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.BIDDER) || 
		accessCtrl.checkAccess(msg.sender, accessCtrl.Roles.SELLER),
					"Access denied");
		_;
	}
				
}