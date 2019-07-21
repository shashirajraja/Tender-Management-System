package com.hit.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.beans.NoticeBean;
import com.hit.dao.NoticeDao;
import com.hit.dao.NoticeDaoImpl;

/**
 * Servlet implementation class UpdateNotice
 */
@WebServlet("/UpdateNotice")
public class UpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeId = Integer.parseInt(request.getParameter("id"));
		String noticeTitle = request.getParameter("title");
		String noticeDesc = request.getParameter("info");
		
		NoticeBean notice = new NoticeBean(noticeId, noticeTitle, noticeDesc);
		
		NoticeDao dao = new NoticeDaoImpl();
		
		String status = dao.updateNotice(notice);
		
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("updateNotice.jsp");
		
		rd.include(request, response);
		
		System.out.println("id: "+noticeId+" title= "+noticeTitle+" desc: "+noticeDesc);
		
		
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
