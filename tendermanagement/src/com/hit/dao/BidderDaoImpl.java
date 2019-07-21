package com.hit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hit.beans.BidderBean;
import com.hit.utility.DBUtil;
import com.hit.utility.IDUtil;

public class BidderDaoImpl implements BidderDao {

	@Override
	public String bidForTender(String tenderId, String vendorId,String bidAmount, String bidDeadline) {
		
		String status = "Bidding Failed";
		
		Connection con = DBUtil.provideConnection();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into bidder values(?,?,?,?,?,?)");
			
			String bid = IDUtil.generateBidderId();
			
			ps.setString(1, bid);
			ps.setString(2, vendorId);
			
			ps.setString(3, tenderId);
			
			ps.setInt(4, Integer.parseInt(bidAmount));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date udate=new Date();
			try {
				udate = sdf.parse(bidDeadline);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			java.sql.Date sdate = new java.sql.Date(udate.getTime());
			ps.setDate(5, sdate);
			
			ps.setString(6, "Pending");
			
			int x = ps.executeUpdate();
			
			if(x>0){
				status = "Your Bidding of Amount "+bidAmount+" is successful for TenderId: "+tenderId;
				status= "\nYour Bid Application ID is : "+bid;
			}
			
			
		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}
		
		
		
		return status;
	}

	
	@Override
	public List<BidderBean> bidHistory(String vendorId) {
		List<BidderBean> bidderList = new ArrayList<BidderBean>();
		
		Connection con = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from bidder having vid=? order by sysdate()");
			ps.setString(1, vendorId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				BidderBean bidder = new BidderBean();
				
				bidder.setBidAmount(rs.getInt("bidamount"));
				bidder.setBidDeadline(rs.getDate("deadline"));
				bidder.setBidId(rs.getString("bid"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setTenderId(rs.getString("tid"));
				bidder.setVendorId(rs.getString("vid"));
				
				bidderList.add(bidder);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bidderList;
	}

	@Override
	public List<BidderBean> viewTenderBid(String tenderId) {
		
		List<BidderBean> bidderList = new ArrayList<BidderBean>();
		
		Connection con = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("Select * from bidder having tid=? order by Sysdate()");
			
			ps.setString(1, tenderId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				BidderBean bidder = new BidderBean();
				
				bidder.setBidAmount(rs.getInt("amount"));
				bidder.setBidDeadline(rs.getDate("deadline"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setBidId(rs.getString("bid"));
				bidder.setTenderId(rs.getString("tid"));
				bidder.setVendorId(rs.getString("vid"));
				
				bidderList.add(bidder);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bidderList;
	}

	@Override
	public String approveBid(String bidId) {
		
		String status = "Bid with Application Id: "+bidId+" Not Approved!";
		
		
		Connection con = DBUtil.provideConnection();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("update bidder set status = 'Approved' where bid=?");
			
			ps.setString(1, bidId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
					
				status = "Bid with Application Id: "+bidId+" has been Approved Successfully!";
			}
			
			
		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}
		
		return status;
	}

	
	

}
