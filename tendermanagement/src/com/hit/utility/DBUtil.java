package com.hit.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static Connection conn = null;
	
	public DBUtil(){
		
	}
	public static Connection provideConnection(){
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		
		String cs = rb.getString("connectionString");
		String username = rb.getString("username");
		String password = rb.getString("password");
		String dbDriver = rb.getString("driverName");
		try {
			if(conn == null || conn.isClosed()){
				
				
				try {
					Class.forName(dbDriver);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				conn = DriverManager.getConnection(cs,username,password);
				
			}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return conn;
	}
	
	public static void closeConnection(PreparedStatement ps){
		
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection(ResultSet rs){
		
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection(Connection con){
		
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
}
