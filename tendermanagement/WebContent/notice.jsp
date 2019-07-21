<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.hit.utility.DBUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
          <div class="marquee" style="border:2px #26b0b0 solid;background-color:white">
          <h4 style="background-color:#26b0b0; margin-top:-1.8px; padding: 5px;"><i class="glyphicon glyphicon-volume-up"></i> 
          &nbsp; Latest Updates and Notice</h4>
            <div class="marquee-content" style="padding:10px;font-weight: bold;font-size: 1.1em">
            <marquee onmouseover="stop()" onmouseout="start()" direction="up" scrollamount="5" height="380px">
            <!-- marquee height and stop start characteristics-->
                <!-- Notice Content-->
            <% 
                Connection con = DBUtil.provideConnection();
                try{
                	PreparedStatement ps = con.prepareStatement("select * from notice order by sysdate() asc");
                	ResultSet rs = ps.executeQuery();
                	String noticeTitle = null;
                	String noticeInfo = null;
                	while(rs.next()){
                		noticeTitle = rs.getString("title");
                		noticeInfo = rs.getString("info");
                		//System.out.println(noticeTitle+" "+noticeInfo);
                		%>
                <p style="font-weight: bold;"><span class="glyphicon glyphicon-hand-right" style="color: #3743fa;"> 
	               <strong style="color:red"><%= noticeTitle %></strong><br><br><%= noticeInfo %>
	               </span>
               </p>
              <hr/>		
                		<%
                	}
                }
                catch(SQLException e){
                	e.printStackTrace();
                }
                %>  
             </marquee><!-- End of marquee-->
             
             <!-- End of Notice Section -->
             
            </div>  <!--End of marquee-content-->
          </div> <!-- End of marquee class-->
	
</body>
</html>