package com.hit.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.beans.TenderBean;
import com.hit.dao.TenderDao;
import com.hit.dao.TenderDaoImpl;
import com.hit.utility.DBUtil;
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
		
		String tid= IDUtil.generateTenderId();
		String tname= request.getParameter("tname").trim();
		String ttype= request.getParameter("ttype").trim();
		String stprice= request.getParameter("tprice").trim();
		String tdesc= request.getParameter("tdesc").trim();
		String stdeadline= request.getParameter("tdeadline").trim();
		String tloc= request.getParameter("tloc").trim();
		int tprice=Integer.parseInt(stprice);
		
		
		TenderBean tender = new TenderBean(tid,tname,ttype,tprice,tdesc,stdeadline,tloc);
		
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
