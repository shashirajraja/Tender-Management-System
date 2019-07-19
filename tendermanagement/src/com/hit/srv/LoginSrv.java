package com.hit.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				Cookie[] ck = new Cookie[2];
				ck[0] = new Cookie("username",uname);
				ck[1] = new Cookie("password",pword);
				response.addCookie(ck[0]);
				response.addCookie(ck[1]);
				RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
			}
		}
		else if(user.toLowerCase().equals("login as vendor")){
			//Vendor Login Check
			System.out.print("Login Failed");
		}
		
	}

}
