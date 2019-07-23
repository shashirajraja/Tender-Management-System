package com.hit.beans;

import java.io.Serializable;

public class TenderStatusBean implements Serializable{

	public String tendorId;
	public String bidderId;
	public String status;
	public String vendorId;
	
	public TenderStatusBean() {
		super();
	}

	public String getTendorId() {
		return tendorId;
	}

	public void setTendorId(String tendorId) {
		this.tendorId = tendorId;
	}

	public String getBidderId() {
		return bidderId;
	}

	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public TenderStatusBean(String tendorId, String bidderId, String status,
			String vendorId) {
		super();
		this.tendorId = tendorId;
		this.bidderId = bidderId;
		this.status = status;
		this.vendorId = vendorId;
	}
	
	
	
	
}
