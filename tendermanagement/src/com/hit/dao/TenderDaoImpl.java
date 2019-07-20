package com.hit.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.hit.beans.TenderBean;
import com.hit.utility.DBUtil;

public class TenderDaoImpl implements TenderDao{

	@Override
	public TenderBean getTenderDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TenderBean> getAllTenders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createTender(TenderBean tender) {
		
		String status = "Tender Addition Failed!";
		
		Connection conn=DBUtil.provideConnection();
		
		try {
			PreparedStatement pst= conn.prepareStatement("insert into tender(?,?,?,?,?,?,?");
			pst.setString(1, tender.getId());
			pst.setString(2, tender.getName());
			pst.setString(3, tender.getType());
			pst.setInt(4, tender.getPrice());
			pst.setString(5, tender.getDesc());
			
			Date deadline = tender.getDeadline();
			java.sql.Date sDeadline = new java.sql.Date(deadline.getTime());
			pst.setDate(6, sDeadline);
			
			pst.setString(7, tender.getLocation());
			
			int x=pst.executeUpdate();
			if(x>0)
				status = "New Tender Inserted with Tender id: "+tender.getId();
		
		} catch (SQLException e) {
			
			status="Error : "+e.getMessage();
			
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean removeTender(String tid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTender(String tid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptBid(String applicationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectBid(String applicationId) {
		// TODO Auto-generated method stub
		return false;
	}

}
