<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <div class="menubar secondnav " style="background-color:white;">
    <div id="menucontent" class="container secondnav">
      <div id="collapsable-nav" class="collapse navbar-collapse hidden-lg hidden-md">
        <ul id="nav-list" class="nav navbar-nav navbar-left pull-left">
            <li id="navHomeButton">
              <a href="vendorHome.jsp">
                <span class="glyphicon glyphicon-home"></span> Home</a> <!--Home button is here -->
            </li>
            <li ><a href="vendorHome.jsp">About Us</a></li>
            <!-- <li class="dropdown">
                <a class="dropdown-toggle " data-toggle="dropdown" data-animations="fadeIn fadeInLeft fadeInUp fadeInRight" data-hover="dropdown">About Us
                    <span class="caret"></span></a>    Dropdown under about us category
                <ul class="dropdown-menu">
                  <li><a href="#">Our Goal</a></li>
                  <li><a href="#">About Admin</a></li>
                  <li><a href="#">Companies/Vendors</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
              </li> -->
              <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-animations="fadeIn fadeInLeft fadeInUp fadeInRight"> 
                <!--Dropdown under tender category -->
                  Tenders
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="vendorViewTender.jsp">View all Tenders</a></li>
                  <li><a href="bidTender.jsp">Bid for a Tender</a></li>
                  <li><a href="bidHistory.jsp">Bidding History</a></li>
                  <!-- <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-animations="default" href="#">Receipt
                    <span class="caret"></span></a>
                    
                    <ul class="dropdown-menu">
                          <li><a href="index.html">Application Receipt</a></li>
                          <li><a href="#">Approval Receipt</a></li>
                      </ul>
                  </li> -->
                  <li><a href="bidHistory.jsp">Bid Status</a></li>
                </ul>
              </li>
            
              
           <li class="dropdown"> <!--Dropdown under Vendors Category -->
                <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-animations="fadeIn fadeInLeft fadeInUp fadeInRight">Account
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="viewProfile.jsp">View Profile</a></li>
                  <li><a href="updateProfile.jsp">Update Profile</a></li>
                  <li><a href="updatePassword.jsp">Change Password</a></li>
                   <li><a href="LogoutSrv">Logout</a></li>
                </ul>
              </li>
              
          
            <li>
              <!-- Form for searching any tenders or items-->
              <form class="navbar-form hidden-xs" action="vendorSearchTender.jsp"  >
                <div class="form-group" >
                  <input type="text" class="form-control" placeholder="Find Tenders by Name or TenderId" style="margin-left:120px;" required>
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
              </form>
              <!--End of form section-->
            </li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>