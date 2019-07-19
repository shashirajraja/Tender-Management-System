package com.hit.utility;

import java.sql.Connection;
import java.sql.DriverManager;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
