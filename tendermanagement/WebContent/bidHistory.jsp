<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.sql.*,com.hit.beans.VendorBean,com.hit.beans.BidderBean,java.lang.Integer,java.lang.String, com.hit.beans.TenderBean,com.hit.utility.DBUtil,java.util.List,com.hit.dao.BidderDaoImpl,com.hit.dao.BidderDao, javax.servlet.annotation.WebServlet"
	errorPage="errorpage.jsp"%>
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
<link href="https://fonts.googleapis.com/css?family=Black+Ops+One"
	rel="stylesheet">
<link href="css/bootstrap-dropdownhover.min.css">
<link rel="stylesheet" href="css/style2.css">
<style>
/* th,tr{
    	height:50px;
    	border:2px black solid;
    	
    }
   
    td{
    	min-width:145px;
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
		font-size: 15px;
		padding:20px;
		cellpadding:10;
		cellspacing:10;
		margin-left : 0px;
    }
     */
</style>
</head>
<body>

	<%
	String user = (String) session.getAttribute("user");
	String uname = (String) session.getAttribute("username");
	String pword = (String) session.getAttribute("password");

	if (user == null || !user.equalsIgnoreCase("user") || uname.equals("") || pword.equals("")) {

		response.sendRedirect("loginFailed.jsp");

	}
	%>




	<!-- Including the header of the page  -->

	<jsp:include page="header.jsp"></jsp:include>

	<jsp:include page="vendorMenu.jsp"></jsp:include>

	<div class="clearfix hidden-sm hidden-xs"
		style="color: white; background-color: green; margin-top: -15px; margin-bottom: 12px">
		<marquee>Welcome to Tender Management Site</marquee>
	</div>
	<!--A green color line between header and body part-->

	<div class="container-fluid">

		<div class="notice">
			<div class="col-md-3" style="margin-left: 1%">
				<%
				Connection con = DBUtil.provideConnection();
				%>

				<jsp:include page="notice.jsp"></jsp:include><br>

				<!-- Next marquee starting-->
				<jsp:include page="approved.jsp"></jsp:include><br>

			</div>
			<!-- End of col-md-3-->
		</div>
		<!-- End of notice class-->


		<!-- Next part of same container-fluid in which galary or other information will be shown-->


		<div class="col-md-8">
			<!-- <div class="marquee" style="border:2px black hidden; background-color:white">
        <h4 style="background-color:black; margin-top:-1.8px; margin-bottom:1px;padding: 5px; text-align: center;color:red;font-weight:bold">
        &nbsp; <span id="pagetitle">Admin Account</span></h4>pagetitle id is given here
        <div class="marquee-content" style="align:center; padding-top:200px;min-height:750px;background-color:cyan">
     		 -->
			<table class="table table-hover table-bordered bg-info">
				<tr
					style="color: white; font-size: 16px; font-weight: bold; background-color: green">
					<td>Application Id</td>
					<td>Tender Id</td>
					<td>Bid Amount</td>
					<td>Deadline</td>
					<td>Status</td>
				</tr>
				<%
				BidderDao dao = new BidderDaoImpl();
				VendorBean vendor = (VendorBean) session.getAttribute("vendordata");
				List<BidderBean> bidderList = dao.getAllBidsOfaVendor(vendor.getId());

				for (BidderBean bidder : bidderList) {
				%>


				<tr>
					<td><%=bidder.getBidId()%></td>
					<td><%=bidder.getTenderId()%></td>
					<td>&#8377; <%=bidder.getBidAmount()%></td>
					<td><%=bidder.getBidDeadline()%></td>
					<td style="font-weight:bold;"><%=bidder.getBidStatus()%></td>
				</tr>



				<%
				}
				%>
			</table>
<!-- 			</form>
 -->			<!-- </div>
     </div> -->
		</div>

	</div>
	<!-- End of container-fluid-->


	<!-- <div class="container" style="height:300px">
	ucomment this if you want to add some space in the lower part of page
	</div> -->



	<!-- Now from here the footer section starts-->

	<!-- Including the footer of the page -->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
