package com.hit.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.hit.beans.VendorBean;
import com.hit.utility.DBUtil;

public class VendorDaoImpl  implements VendorDao{

	@Override
	public String registerVendor(VendorBean vendor) {
		
		String status = "Registration Failed!!";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement pst = null;
		
		try {
			
			pst = con.prepareStatement("select * from vendor where vemail=?");
		
			pst.setString(1, vendor.getEmail());
			ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			
			status = "Registration Declined!<br>Email Id already Registered";
		}
		else{
		
			try {
			
				PreparedStatement ps = con.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
				
				ps.setString(1, vendor.getId());
				ps.setString(2, vendor.getPassword());
				ps.setString(3, vendor.getName());
				ps.setString(4, vendor.getMobile());
				ps.setString(5, vendor.getEmail());
				ps.setString(6, vendor.getCompany());
				ps.setString(7, vendor.getAddress());
				
				int k = ps.executeUpdate();
				
				if(k>0) //update successful
					status = "Registration Successful.<br> Your Vendor id: "+vendor.getId()+"<br>Thanks For Registration";
			}
				
			catch(SQLException e){
				e.printStackTrace();
				status = "Error: "+e.getMessage();
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
		status = "Error: "+ e.getErrorCode()+" : "+e.getMessage();
	}

	return status;

}

	@Override
	public List<VendorBean> getAllVendors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateVendor(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(String uid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
