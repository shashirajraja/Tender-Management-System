package com.hit.dao;

import java.util.List;

import com.hit.beans.VendorBean;

public interface VendorDao {
	
	public String registerVendor(VendorBean vendor);
	
	public List<VendorBean> getAllVendors();
	
	public boolean validateVendor(String uid,String password);
	
	public boolean updateAccount(String uid,String password);
	
}
