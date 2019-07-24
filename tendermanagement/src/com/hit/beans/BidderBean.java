package com.hit.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BidderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bidId;
	private String vendorId;
	private String tenderId;
	private int bidAmount;
	private Date bidDeadline;
	private String bidStatus ;
	public String getBidId() {
		return bidId;
	}
	
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getTenderId() {
		return tenderId;
	}
	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Date getBidDeadline() {
		return bidDeadline;
	}
	public void setBidDeadline(java.sql.Date bidDeadline){
		
		this.bidDeadline = new java.util.Date(bidDeadline.getTime());
	}
	/*public void setBidDeadline(Date bidDeadline) {
		this.bidDeadline = bidDeadline;
	}*/
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	public BidderBean(String bidId, String vendorId, String tenderId,
			String bidAmount, String bidDeadline, String bidStatus) {
		//TODO
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = Integer.parseInt(bidAmount);
		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                Locale.ENGLISH);
		java.util.Date udate = new java.util.Date();
		
		try {
			
			udate = sdf.parse(bidDeadline);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.bidDeadline = udate;
		this.bidStatus = bidStatus;
	}
	
	public BidderBean(String bidId, String vendorId, String tenderId,
			int bidAmount, Date bidDeadline, String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = bidAmount;
		this.bidDeadline = bidDeadline;
		this.bidStatus = bidStatus;
	}
	public BidderBean() {
		super();
	}
	
	

}
