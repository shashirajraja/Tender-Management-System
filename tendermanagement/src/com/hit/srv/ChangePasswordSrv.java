package com.hit.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.beans.VendorBean;
import com.hit.dao.VendorDao;
import com.hit.dao.VendorDaoImpl;

/**
 * Servlet implementation class ChangePasswordSrv
 */
@WebServlet("/ChangePasswordSrv")
public class ChangePasswordSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordSrv() {
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
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String uname = (String)session.getAttribute("username");
		String pword = (String)session.getAttribute("password");
		
		if(user==null || !user.equalsIgnoreCase("user") || uname.equals("") || pword.equals("")){
			
			response.sendRedirect("loginFailed.jsp");
			
		}
		
		
		String fvid = request.getParameter("vid");
		String foldPass = request.getParameter("oldpassword");
		String newPass = request.getParameter("newpassword");
		String verifyPass = request.getParameter("verifynewpassword");
		
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("updatePassword.jsp");
		
		//HttpSession session = request.getSession();
		
		VendorBean vendor = (VendorBean)session.getAttribute("vendordata");
		
		String vpass = vendor.getPassword();
		
		if(!newPass.equals(verifyPass) ){
			
			rd.include(request, response);
			
			pw.print("<script>document.getElementById('show').innerHTML='New Password and verify Password does not match!'</script>");
			
		}
		
		else if(!vpass.equals(foldPass)){
			
			rd.include(request, response);
			
			pw.print("<script>document.getElementById('show').innerHTML='Incorrect Old Password!'</script>");
			
			
		}
		else{
			
			VendorDao dao = new VendorDaoImpl();
			
			String status = dao.changePassword(fvid, foldPass, newPass);
			
			if(status.equalsIgnoreCase("Password Updated Successfully!")){
				vendor.setPassword(newPass);
				session.setAttribute("vendordata", vendor);
				
			}
			
			rd.include(request, response);
			
			pw.print("<script>document.getElementById('show').innerHTML='"+status+"'</script>");
		}
		pw.close();
		
		
	}

}
