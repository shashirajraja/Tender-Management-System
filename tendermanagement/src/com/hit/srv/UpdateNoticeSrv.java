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

import com.hit.beans.NoticeBean;
import com.hit.dao.NoticeDao;
import com.hit.dao.NoticeDaoImpl;

/**
 * Servlet implementation class UpdateNoticeSrv
 */
@WebServlet("/UpdateNoticeSrv")
public class UpdateNoticeSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeSrv() {
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
		
		if(user==null || !user.equalsIgnoreCase("admin") || uname.equals("") || pword.equals("")){
			
			response.sendRedirect("loginFailed.jsp");
			
		}
		
		
		
		int noticeId = Integer.parseInt(request.getParameter("nid"));
		
		String noticeTitle = request.getParameter("title");
		
		String noticeDesc = request.getParameter("info");
		
		NoticeBean notice = new NoticeBean(noticeId, noticeTitle, noticeDesc);
		
		NoticeDao dao = new NoticeDaoImpl();
		
		String status = dao.updateNotice(notice);
		
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("updateNotice.jsp");
		
		rd.include(request, response);		
		
		pw.print("<script>document.getElementById('show').innerHTML = '"+status+"'</script>");
		
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
