package com.hit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.hit.beans.VendorBean;
import com.hit.utility.DBUtil;

public class VendorDaoImpl  implements VendorDao{

	@Override
	public String registerVendor(VendorBean vendor) {
		
		String status = "Registration Failed!!";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement pst = null;
		
		PreparedStatement ps = null;
		
		try {
			
			pst = con.prepareStatement("select * from vendor where vemail=?");
		
			pst.setString(1, vendor.getEmail());
			ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			
			status = "Registration Declined!<br>Email Id already Registered";
		}
		else{
		
			try {
			
				ps = con.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
				
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
			finally{
				
				DBUtil.closeConnection(ps);
				
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
		status = "Error: "+ e.getErrorCode()+" : "+e.getMessage();
	}

	finally{
		
		DBUtil.closeConnection(pst);
		
		DBUtil.closeConnection(con);
	}
	return status;

}

	@Override
	public List<VendorBean> getAllVendors() {

		List<VendorBean> vendorList = new ArrayList<VendorBean>();
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from vendor");
			rs = ps.executeQuery();
			
			while(rs.next()){
				VendorBean vendor = new VendorBean(rs.getString("vid"),rs.getString("vname"), rs.getString("vmob"), rs.getString("vemail"), rs.getString("address"), rs.getString("company"), rs.getString("password"));
				vendorList.add(vendor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(rs);
			
			DBUtil.closeConnection(ps);
		}
		
		return vendorList;
	}

	@Override
	public boolean validatePassword(String vid, String password) {
		boolean flag=false;
		Connection conn = DBUtil.provideConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("select * from vendor where vid=? and password=?");
			
			pst.setString(1, vid);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(rs.next())
				flag = true;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(conn);
			
			DBUtil.closeConnection(pst);
			
			DBUtil.closeConnection(rs);
			
		}
		
		
		return flag;
	}

	@Override
	public String updateProfile(VendorBean vendor) {
		
		String status = "Account Updation Failed";
		
		String vendorId = vendor.getId();
		String password = vendor.getPassword();
		
		VendorDao dao = new VendorDaoImpl();
		
		if(!dao.validatePassword(vendorId, password)){
			
			status = status + "<br>You Have Entered Wrong Password!";
			
			return status;
		}
		
		Connection con  = DBUtil.provideConnection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update vendor set vname=?,vmob=?,vemail=?,company=?,address=? where vid=?");
			
			ps.setString(1,vendor.getName());
			ps.setString(2,vendor.getMobile());
			ps.setString(3, vendor.getEmail());
			ps.setString(4, vendor.getCompany());
			ps.setString(5, vendor.getAddress());
			ps.setString(6, vendor.getId());
			
			int x = ps.executeUpdate();
			
			if(x>0){
				status = "Account Updated Successfully!";
			}

			
		} catch (SQLException e) {
			
			status = "Error: "+e.getMessage();
			
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
		}
		
		return status;
		
	}

	@Override
	public String changePassword(String vendorId, String oldPassword, String newPassword) {
		
		String status = "Password Updation failed!";
		
		
		VendorDao dao = new VendorDaoImpl();
		
		if(!dao.validatePassword(vendorId, oldPassword)){
			
			status = status + "<br>You Have Enetered Wrong Old Password!";
			
			return status;
		}
		
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement("update vendor set password = ? where vid=?");
			
			ps.setString(1, newPassword);
			ps.setString(2, vendorId);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "Password Updated Successfully!";
			
		} 
		catch (SQLException e) {
			
			status = status + "<br>Error: " +e.getMessage();
			
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
		
		}
		return status;
	}

	@Override
	public VendorBean getVendorDataById(String vendorId) {

		VendorBean vendor = null;
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from vendor where vid=?");
			
			ps.setString(1, vendorId);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				vendor = new VendorBean(rs.getString("vid"),rs.getString("vname"), rs.getString("vmob"), rs.getString("vemail"), rs.getString("address"), rs.getString("company"), rs.getString("password"));
			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(rs);
			
			DBUtil.closeConnection(ps);
		}
		
		return vendor;
	}

	

}
