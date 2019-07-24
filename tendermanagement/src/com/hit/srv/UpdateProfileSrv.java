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
 * Servlet implementation class UpdateProfileSrv
 */
@WebServlet("/UpdateProfileSrv")
public class UpdateProfileSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileSrv() {
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
		
		String vid = request.getParameter("vid");
		String vname = request.getParameter("vname");
		String vmob = request.getParameter("vmob");
		String vemail = request.getParameter("vemail");
		String vaddr = request.getParameter("vaddr");
		String vcompany = request.getParameter("vcompany");
		String vpass = request.getParameter("vpass");
		
		VendorBean vendor = new VendorBean(vid, vname, vmob, vemail, vaddr, vcompany, vpass);
		VendorDao dao = new VendorDaoImpl();
		
		String status = dao.updateProfile(vendor);
		
	//	HttpSession session = request.getSession();
		
		if(status.equalsIgnoreCase("Account Updated Successfully!") && (VendorBean)session.getAttribute("vendordata")!=null){
			session.setAttribute("vendordata", vendor);
		}
		
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("updateProfile.jsp");
		
		rd.include(request, response);
		
		pw.print("<script>document.getElementById('show').innerHTML='"+status+"'</script>");
		
		pw.close();
	}

}
