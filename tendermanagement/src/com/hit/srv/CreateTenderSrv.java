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

import com.hit.beans.TenderBean;
import com.hit.dao.TenderDao;
import com.hit.dao.TenderDaoImpl;
import com.hit.utility.IDUtil;

/**
 * Servlet implementation class CreateTenderSrv
 */
@WebServlet("/CreateTenderSrv")
public class CreateTenderSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTenderSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String uname = (String)session.getAttribute("username");
		String pword = (String)session.getAttribute("password");
		
		if(!user.equalsIgnoreCase("admin") || uname.equals("") || pword.equals("")){
			
			response.sendRedirect("loginFailed.jsp");
			
		}
		
		
		String tid= IDUtil.generateTenderId();
		String tname= request.getParameter("tname").trim();
		String ttype= request.getParameter("ttype").trim();
		String stprice= request.getParameter("tprice").trim();
		String tdesc= request.getParameter("tdesc").trim();
		String stdeadline= request.getParameter("tdeadline").trim();
		String tloc= request.getParameter("tloc").trim();
		int tprice=Integer.parseInt(stprice);
		System.out.print(tid+" "+tname+" "+ttype+" "+tprice+" "+tdesc+" "+stdeadline+" "+tloc+" "+"completed ");
		
		TenderBean tender = new //TenderBean(id, name, type, price, desc, stdeadline, location)
				
				 TenderBean(tid,tname,ttype,tprice,tdesc,stdeadline,tloc);
		
		TenderDao dao = new TenderDaoImpl();
		
		String status = dao.createTender(tender);
		
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("createTender.jsp");
		
		rd.include(request, response);
		
		pw.print("<script>document.getElementById('show').innerHTML = '"+status+"'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
