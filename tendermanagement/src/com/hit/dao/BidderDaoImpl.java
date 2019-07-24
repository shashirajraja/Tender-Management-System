package com.hit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hit.beans.BidderBean;
import com.hit.utility.DBUtil;
import com.hit.utility.IDUtil;

public class BidderDaoImpl implements BidderDao{
	
	
	@Override
	public String acceptBid(String applicationId,String tenderId,String vendorId) {
		String status = "Bid Acceptance Failed";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from tenderstatus where tid=?");
			ps.setString(1, tenderId);
			rs = ps.executeQuery();
			if(rs.next()){
				
				status = "Project Already Assigned";
			}
			else{
			
				pst = con.prepareStatement("update bidder set status = ? where bid=? and status=?");
				
				pst.setString(1, "Accepted");
				pst.setString(2, applicationId);
				pst.setString(3, "Pending");
				
				int x = pst.executeUpdate();
				if(x>0){
					status = "Bid Has Been Accepted Successfully!";
					TenderDao dao = new TenderDaoImpl();
					status = status + "<br>"+dao.assignTender(tenderId, vendorId,applicationId);
				}
			}
		} catch (SQLException e) {

			status = status + "Error: "+e.getMessage();
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
		}
		return status;
	}
	
	
	@Override
	public String rejectBid(String applicationId) {
		String status = "Bid Rejection Failed";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update bidder set status = ? where bid=? and status = ?");
			
			ps.setString(1, "Rejected");
			ps.setString(2, applicationId);
			ps.setString(3, "Pending");
			
			int x = ps.executeUpdate();
			if(x>0)
				status = "Bid Has Been Rejected Successfully!";
			
		} catch (SQLException e) {

			status = status + "Error: "+e.getMessage();
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
		}
		return status;
			
	}

	@Override
	public String bidTender(String tenderId, String vendorId, String bidAmount,
			String bidDeadline) {
		String status = "Tender Bidding Failed!";
		
		String bidId = IDUtil.generateBidderId();
		
		String bidStatus = "Pending";
		
		BidderBean bidder = new BidderBean(bidId, vendorId, tenderId, bidAmount, bidDeadline, bidStatus);
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("insert into bidder values(?,?,?,?,?,?)");
			
			ps.setString(1, bidId);
			
			ps.setString(2, vendorId);
			
			ps.setString(3,tenderId);
			
			ps.setInt(4, bidder.getBidAmount());
			
			java.sql.Date bidDate = new java.sql.Date(bidder.getBidDeadline().getTime());
			
			ps.setDate(5, bidDate);
			
			ps.setString(6, bidStatus);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "You have successfully Bid for the tender";
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
		}
		
		
		return status;
	}


	@Override
	public List<BidderBean> getAllBidsOfaTender(String tenderId) {
		
		List<BidderBean> bidderList = new ArrayList<BidderBean>();
		
		
		Connection con = DBUtil.provideConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from bidder where tid=?");
			
			ps.setString(1, tenderId);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				BidderBean bidder = new BidderBean();
				
				bidder.setBidAmount(rs.getInt("bidamount"));
				bidder.setBidDeadline(new java.sql.Date(rs.getDate("deadline").getTime()));
				bidder.setBidId(rs.getString("bid"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setTenderId(rs.getString("tid"));
				bidder.setVendorId(rs.getString("vid"));
				
				bidderList.add(bidder);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
			
			DBUtil.closeConnection(rs);
		}
		
		
		
		return bidderList;
	}


	@Override
	public List<BidderBean> getAllBidsOfaVendor(String vendorId) {
List<BidderBean> bidderList = new ArrayList<BidderBean>();
		
		
		Connection con = DBUtil.provideConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from bidder where vid=?");
			
			ps.setString(1, vendorId);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				BidderBean bidder = new BidderBean();
				
				bidder.setBidAmount(rs.getInt("bidamount"));
				bidder.setBidDeadline(new java.sql.Date(rs.getDate("deadline").getTime()));
				bidder.setBidId(rs.getString("bid"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setTenderId(rs.getString("tid"));
				bidder.setVendorId(rs.getString("vid"));
				
				bidderList.add(bidder);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			
			DBUtil.closeConnection(con);
			
			DBUtil.closeConnection(ps);
			
			DBUtil.closeConnection(rs);
		}
		
		
		
		return bidderList;
	}

	
}
