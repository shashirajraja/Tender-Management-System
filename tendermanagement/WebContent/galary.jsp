<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*,com.hit.utility.DBUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <head>
    <link rel="shortcut icon" type="image/png" href="images/Banner_Hit.png">
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
    <link rel="stylesheet" href="css/style2.css"><!-- Stylesheet connected -->
  </head>
</head>
<body>
  <div class="col-md-8">
    <div class="marquee" style="border:2px black hidden; background-color:white">
        <h4 style="background-color:black; margin-top:-1.8px; margin-bottom:1px;padding: 5px; text-align: center;color:white;font-weight:bold">
        &nbsp; <span id="pagetitle">Galary</span></h4><!-- pagetitle id is given here -->
      <div class="marquee-content" style="padding:1px;padding-top:0px; font-weight: bold; font-size: 1.1em">
      <!-- height="900" -->   
      <marquee scrollamount=0 style="min-height:750px">
            <!--Attatching the photo to be slided in the home page-->
            <div class="slider">
              <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Wrapper for slides -->
               
                <div class="carousel-inner" style="width:100%; height: 500px !important;">
                    <div class="item active"> <img src="images/home1.jpg" style="width:100%; height: 500px"> </div>
                    <div class="item active"> <img src="images/library1.png" style="width:100%; height: 500px"> </div>
                    <div class="item"> <img src="images/cap.jpg" style="width:100%; height: 500px"> </div>
                    <div class="item"> <img src="images/onwork.jpg" style="width:100%; height: 500px"> </div>
                    <div class="item"> <img src="images/building.jpg" style="width:100%; height: 500px"> </div>
                    <div class="item"> <img src="images/building2.jpg" style="width:100%; height: 500px"> </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
              </div> <!-- End of mycarousel -->
            </div> <!-- End of Slider -->
        </marquee> <!-- End of marquee-->
        
        
      </div> <!-- End of marquee-content-->
    </div> <!-- End of marquee class--><br>        
  </div><!--End of col-md-8 part of container in which data is shown-->
<script src="js/jquery-2.1.4.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/ajax-utils.js"></script>
  <script src="js/script.js"></script>
  <script src="js/bootstrap-dropdownhover.min.js"></script>
  
</body>
</html>


  