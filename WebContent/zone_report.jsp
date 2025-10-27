<%@page import="java.sql.*"%>
<%@page import="com.transaction.BankConnectionPolice.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Zonal Report</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
    Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> 
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
        function hideURLbar(){ window.scrollTo(0,1); } 
    </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="css/font.css" type="text/css"/>
    <link href="css/font-awesome.css" rel="stylesheet"> 
    <!-- //font-awesome icons -->
    <script src="js/jquery2.0.3.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/screenfull.js"></script>
    <script>
        $(function () {
            $('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

            if (!screenfull.enabled) {
                return false;
            }

            $('#toggle').click(function () {
                screenfull.toggle($('#container')[0]);
            });	
        });
    </script>
    <!-- tables -->
    <link rel="stylesheet" type="text/css" href="css/table-style.css" />
    <link rel="stylesheet" type="text/css" href="css/basictable.css" />
    <script type="text/javascript" src="js/jquery.basictable.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#table').basictable();

            $('#table-breakpoint').basictable({
                breakpoint: 768
            });

            $('#table-swap-axis').basictable({
                swapAxis: true
            });

            $('#table-force-off').basictable({
                forceResponsive: false
            });

            $('#table-no-resize').basictable({
                noResize: true
            });

            $('#table-two-axis').basictable();

            $('#table-max-height').basictable({
                tableWrapper: true
            });
        });
    </script>
    <style>
        body {
            background-image: url("images/report.jpg!bw700");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .comments-icon i {
            font-size: 80px;
        }
    </style>
</head>
<body class="dashboard-page">

<nav class="main-menu">
         <ul>
            <li>
                <a href="report.html">
                    <i class="fa fa-home nav_icon"></i>
                    <span class="nav-text">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="view_station.jsp"><i class="fa fa-file-text-o nav_icon" aria-hidden="true"></i>
                    <span class="nav-text">View All Police Stations</span>
                </a>
            </li>
           
            <li>
                <a href="view_blackspot.jsp"><i class="fa fa-cogs" aria-hidden="true"></i>
                    <span class="nav-text">View All Black Spots</span>
                </a>
            </li>
            <li class="has-subnav">
                <a href="report.html">
                    <i class="fa fa-file-text-o nav_icon"></i>
                    <span class="nav-text">Report of Black Spots</span>
                    <i class="icon-angle-right"></i><i class="icon-angle-down"></i>
                </a>
                <ul>
                    <li><a class="subnav-text" href="zone_report.jsp">Zone Wise</a></li>
                    <li><a class="subnav-text" href="reason_report.jsp">Reason Wise</a></li>
                    <li><a class="subnav-text" href="city_report.jsp">City Wise</a></li>
                </ul>
            </li>
        </ul>
    <ul class="logout">
        <li>
            <a href="Welcome.html">
                <i class="icon-off nav-icon"></i>
                <span class="nav-text">Logout</span>
            </a>
        </li>
    </ul>
</nav>

<section class="wrapper scrollable">
    <nav class="user-menu">
        <a href="javascript:;" class="main-menu-access">
            <i class="icon-proton-logo"></i>
            <i class="icon-reorder"></i>
        </a>
    </nav>
    <section class="title-bar">
        <div class="logo">
            <h1><a href="Welcome.html"><img src="assets/img/Saf1.png" alt="" width="33%" height="33%"/></a></h1>
        </div>
        <div style="position: absolute; top: 30px; width: 100%; text-align: center; font-family: 'Great Vibes', cursive; font-size: 70px; color: #007bff;">
            <h1 style="margin: 0;">Spot Warn</h1>
        </div>
        <div class="profile_details">		
            <ul>
                <li class="dropdown profile_details_drop">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <div class="profile_img">	
                            <span class="prfil-img"><i class="fa fa-user" aria-hidden="true"></i></span> 
                            <div class="clearfix"></div>	
                        </div>	
                    </a>
                    <ul class="dropdown-menu drp-mnu">
                        <li> <a href="Welcome.html"><i class="fa fa-sign-out"></i> Logout</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </section>
    <div class="main-grid">
        <div class="agile-grids">	
            <!-- tables -->
            <div class="table-heading">
                <h2 style="color: #00008B;">Zonal Report</h2>
            </div>
            <div class="agile-tables">
                <div class="w3l-table-info">
                    <h3>Zone Wise Report</h3>
                    <table id="table" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Level</th>
                                <th>Yellow</th>
                                <th>Orange</th>
                                <th>Red</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            try {
                                Connection connection = BankConnection3.dbcon();
                                PreparedStatement preparedStatement = connection.prepareStatement("select * from zone_report");
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                            %>
                            <tr>
                                <td><%= resultSet.getString(1) %></td>
                                <td><%= resultSet.getString(2) %></td>
                                <td><%= resultSet.getString(3) %></td>
                                <td><%= resultSet.getString(4) %></td>
                                  </tr>
                            <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- //tables -->
        </div>
    </div>
    <!-- footer -->
    <div class="footer">
        <p>© 2024 Spot Warn. All Rights Reserved. Design by Vedika Chandratre & Anjali Pawar</p>
    </div>
    <!-- //footer -->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/proton.js"></script>
</body>
</html>
