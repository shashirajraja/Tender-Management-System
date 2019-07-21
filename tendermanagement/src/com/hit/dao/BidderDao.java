package com.hit.dao;

import java.util.List;

import com.hit.beans.BidderBean;

public interface BidderDao {

	
	public String bidForTender(String tenderId,String vendorId, String bidAmount,String bidDeadline);
	
	public List<BidderBean> bidHistory(String vendorId);
	
	public List<BidderBean> viewTenderBid(String tenderId);
	
	public String approveBid(String bidId);
}
