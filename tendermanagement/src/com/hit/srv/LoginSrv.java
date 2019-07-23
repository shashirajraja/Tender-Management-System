package com.hit.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.beans.VendorBean;
import com.hit.utility.DBUtil;

/**
 * Servlet implementation class LoginSrv
 */
@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username").trim();
		String pword = request.getParameter("password").trim();
		String user = request.getParameter("user").trim();
		
		if(user.toLowerCase().equals("login as admin")){
			//Admin login check
			if(uname.equals("Admin") && pword.equals("Admin")){
				//login successful
				HttpSession session = request.getSession();
				session.setAttribute("user","admin");
				session.setAttribute("username", uname);
				session.setAttribute("password", pword);
				RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
			}
			else{
				PrintWriter pw = response.getWriter();
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
				pw.print("<script>document.getElementById('show').innerHTML = 'Invalid Username or Password!!'</script>");
			}
			
				
		}
		else if(user.toLowerCase().equals("login as vendor")){
			//Vendor Login Check
			Connection conn =DBUtil.provideConnection();
			PreparedStatement ps = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			
			try {
				pst = conn.prepareStatement("select * from vendor where vid=? and password=?");
				pst.setString(1, uname);
				pst.setString(2, pword);
				rs=pst.executeQuery();
				if(rs.next()){ //Vendor Login Successful
					
					HttpSession session = request.getSession();
					session.setAttribute("user","user");
					session.setAttribute("username", uname);
					session.setAttribute("password", pword);
					
					
					
					
					String vid = uname;
					String pass = pword;
					
					String vname = rs.getString("vname");
					String vemail= rs.getString("vemail");
					String vaddr = rs.getString("address");
					String cname = rs.getString("company");
					String mob = rs.getString("vmob");
					VendorBean vendor = new VendorBean(vid,vname,mob,vemail,vaddr,cname,pass);
					
					session.setAttribute("vendordata", vendor);
					
					RequestDispatcher rd = request.getRequestDispatcher("vendorHome.jsp");
					
					
					rd.forward(request, response);
					
				}
				else{
					
					ps = conn.prepareStatement("select * from vendor where vemail=? and password=?");
					ps.setString(1, uname);
					ps.setString(2, pword);
					
					rs1=ps.executeQuery();
					if(rs1.next()){
						
						HttpSession session = request.getSession();
						session.setAttribute("user","user");
						session.setAttribute("username", uname);
						session.setAttribute("password", pword);
						
						
						
						String vid = rs1.getString("vid");
						String pass = pword;
						String vname = rs1.getString("vname");
						String vemail= rs1.getString("vemail");
						String vaddr = rs1.getString("address");
						String cname = rs1.getString("company");
						String mob = rs1.getString("vmob");
						VendorBean vendor = new VendorBean(vid,vname,mob,vemail,vaddr,cname,pass);
						
						session.setAttribute("vendordata", vendor);  //We need the user data whole the session
						
						
						RequestDispatcher rd = request.getRequestDispatcher("vendorHome.jsp");
						rd.forward(request, response);
					}
					else{
					
					
					
					PrintWriter pw = response.getWriter();
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
					pw.print("<script>document.getElementById('show').innerHTML = 'Invalid Username or Password<br>Please Try Again!'</script>");
					}
					
			} 
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				DBUtil.closeConnection(ps);
				
				DBUtil.closeConnection(pst);
				
				DBUtil.closeConnection(rs);
			
				DBUtil.closeConnection(rs1);
			}
			
		}
		
	}

}
