<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*, java.lang.Integer,com.hit.beans.NoticeBean,com.hit.utility.DBUtil,java.util.List,java.util.ArrayList,com.hit.dao.NoticeDaoImpl,com.hit.dao.NoticeDao, javax.servlet.annotation.WebServlet" errorPage="errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <link rel="shortcut icon" type="image/png" href="images/Banner_Hit.png">
    <!--link rel="shortcut icon" type="image/ico" href="images/hit_fevicon.ico"-->
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tender Management System</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/annimate.css">
    <link href="css/font-awesome.min.css" type="text/css" rel="stylesheet">
    <link href="css/SpryTabbedPanels.css" type="text/css" rel="stylesheet">
    <!--link rel="stylesheet" href="css/styles.css"-->
    <link href="https://fonts.googleapis.com/css?family=Black+Ops+One" rel="stylesheet">
    <link href="css/bootstrap-dropdownhover.min.css">
    <link rel="stylesheet" href="css/style2.css">
    <style>
    th,tr{
    	height:50px;
    	border:2px black solid;
    	
    }
   
    td{
    	min-width:90px;
    	border: 2px dashed black;
    }
 table{
    	text-align:center;
    	border-radius:10px;
		border:1px red solid;
		text-align:center;
		background-color: cyan;
		margin:20px;
		color:blue;
		font-style:normal;
		font-size: 15.5px;
		padding:20px;
		cellpadding:10;
		cellspacing:10;
    }
    tr:hover{
    	background-color: #DEBEE1;
    	color:black;
    } 
    textarea:hover{
    	background-color:#ADBFAF;
    	color:black;
    }
    .button:hover{
    	background-color:green;
    	color:white;
    	font-size:bold;
    }
    #show{
    	
    	text-align:center;
    	border-radius:10px;
		border:1px red solid;
		text-align:center;
		background-color: cyan;
		margin:20px;
		margin-left:40px;
		color:black;
		font-style:normal;
		font-size: 15.5px;
		padding:12px;
		
    
    }
    button:hover{
    
    	background-color:green;
    	color:white;
    }
    </style>
  </head>
<body>


	<%
		String user = (String)session.getAttribute("user");
		String uname = (String)session.getAttribute("username");
		String pword = (String)session.getAttribute("password");
		
		if(!user.equalsIgnoreCase("admin") || uname.equals("") || pword.equals("")){
			
			response.sendRedirect("loginFailed.jsp");
			
		}
	
	%>


	<!-- Including the header of the page  -->
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<jsp:include page="adminMenu.jsp"></jsp:include>
	
	<div class="clearfix hidden-sm hidden-xs" style="color:white;background-color: green; margin-top:-15px; margin-bottom: 12px"><marquee>Welcome to Tender Management Site</marquee>
 </div> <!--A green color line between header and body part-->
 
     <div class="container-fluid">
     
     	<div class="notice">
        <div class="col-md-3"style="margin-left:2%">
     		<% Connection con = DBUtil.provideConnection(); %>
     		
     		<jsp:include page="notice.jsp"></jsp:include><br>
     		
          <!-- Next marquee starting-->
          <jsp:include page="approved.jsp"></jsp:include><br>
          
        </div>  <!-- End of col-md-3-->
      </div> <!-- End of notice class-->
      
      
      <!-- Next part of same container-fluid in which galary or other information will be shown-->
      
          
   <div class="col-md-8">
    <!-- <div class="marquee" style="border:2px black hidden; background-color:white">
        <h4 style="background-color:black; margin-top:-1.8px; margin-bottom:1px;padding: 5px; text-align: center;color:red;font-weight:bold">
        &nbsp; <span id="pagetitle">Admin Account</span></h4>pagetitle id is given here
        <div class="marquee-content" style="align:center; padding-top:200px;min-height:750px;background-color:cyan">
     		 -->
     		 <div id="show">
     		 
     		 	 Edit the Given Notice Title and Description in the given box and click on update
     		 	 
     		 </div>
     		 
     		 
     		 
     		 
     		 
     <table style="background-color:white">		
     		<tr style="color:white; font-size:18px; font-weight:bold;background-color:#660033">
     		 <td>Notice Id</td> <td>Title </td> <td> Description</td> <td>Action </td></tr>
     		<%
     			NoticeDao dao = new NoticeDaoImpl();
     			List<NoticeBean> noticeList = dao.viewAllNotice();
     			
     			for(NoticeBean notice : noticeList){
     				
     				int noticeId = notice.getNoticeId();
     				
     				String noticeTitle = notice.getNoticeTitle();
     				
     				String noticeDesc = notice.getNoticeInfo();
     				
     				%>
     				
     			
     		<tr> <td><%= noticeId %> </td> <td style="width:120%;"><textarea name="title" readonly><%=noticeTitle %></textarea></td> 
     				<td><textarea name="info" cols="60" readonly><%=noticeDesc %></textarea></td>
     							 <td><a href="updateNoticeForm.jsp?nid=<%=noticeId%>"><button class="btn btn-success">Update</button></a></td> </tr>
 
 <% } %>

    </table>	
   
   
   
   
   
   
   
      <!-- </div>
     </div> -->
     </div>
      
    </div> <!-- End of container-fluid-->
	
	
	<!-- <div class="container" style="height:300px">
	ucomment this if you want to add some space in the lower part of page
	</div> -->



<!-- Now from here the footer section starts-->
                      
<!-- Including the footer of the page -->
    
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
