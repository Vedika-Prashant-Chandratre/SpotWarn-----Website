
<%@page import="java.sql.*" %>
<%@page import="com.transaction.BankConnectionPolice.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> View Black Spot </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
    Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Baloo+Bhaijaan|Noto+Sans' rel='stylesheet' type='text/css'>
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
            $(document).ready(function() {
                // Initialize BasicTable plugin
                $('#table').basictable();

                // Other scripts for your application
                $('#toggle').click(function () {
                    screenfull.toggle($('#container')[0]);
                });
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
            background-image: url("images/back1.avif");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .comments-icon i {
            font-size: 80px;
        }

        /* Additional styles for table */
        table {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse;
            border-spacing: 0;
            background-color: #fff;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        table th {
            background-color:#4CAF50;
            color:#FFFFFF;
            font-weight: bold;
        }

        table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Align main text to the left */
        .main-content {
            text-align: left;
            padding-left: 20px;
             padding-right: 20px;
        }

        /* Format the "View details" button */
        input[type="submit"] {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
    </style>
    <!-- //tables -->
</head>
<body class="dashboard-page">
    <nav class="main-menu">
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
                <h1><a href="index.html"><img src="assets/img/Saf1.png" alt="" height="33%" width="33%"/></a></h1>
                <div style="
        position: absolute; 
        top: 30px; 
        width: 100%; 
        text-align: center; 
        font-family: 'Great Vibes', cursive; 
        font-size: 70px; 
        color: #007bff;">
        <h1 style="margin: 0;">Spot Warn</h1>
    </div> 
            </div>  
            <div class="header-right">
                <div class="profile_details_left">
                    <div class="header-right-left">
                        <!--notifications of menu start -->
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
                                    <li><a href="Welcome.html"><i class="fa fa-sign-out"></i> Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </section>
        <br><br><br>
  <div class="main-content">
        <h1 align="center">View All Black Spots</h1>
        <br>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Name Of Location</th>
                    <th>Address</th>
                    <th>Reason</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                    <th>Level</th>
                    <th>City</th>
                    
                </tr>
            </thead>
            <tbody>
                <% 
                try {
                    Connection con = BankConnection3.dbcon();
                    PreparedStatement ps1 = con.prepareStatement("select * from add_black_spot");
                    ResultSet rs = ps1.executeQuery();
                    while(rs.next()) {
                %>
                    <tr>
                        <td><%=rs.getString(1) %></td>
                        <td><%=rs.getString(2) %></td>
                        <td><%=rs.getString(3) %></td>
                        <td><%=rs.getString(4) %></td>
                        <td><%=rs.getString(5) %></td>
                        <td><%=rs.getString(6) %></td>
                        <td><%=rs.getString(7) %></td>
                        
                    </tr>
                <% 
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
                %>
            </tbody>
        </table>
         <h3 style="fon">Meaning </h3>
         <br>
    <ul>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Pickpocketing-पाकिटमारी</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Burglary-घरफोडी</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Robbery-दरोडा</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Mugging-जबरी चोरी</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Vandalism-तोडफोड</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Extortion-खंडणी</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Smuggling-तस्करी</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Fraud-फसवणूक</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Carjacking-गाडी लुटणे</li>
    <li style="font-size: 15px; color: black; margin-left: 20px;">Hooliganism-दंगेखोरी</li>
</ul>
<br>

        <h4><a href="Welcome.html" >Go Back To Home Page</a></h4>
      </div>
        <br>
        <!-- footer -->
        <div class="footer">
            <p>© 2024 Spot Warn. All Rights Reserved. Design by Vedika Chandratre & Anjali Pawar</p>
        </div>
        <!-- //footer -->
    </section>
    <!-- JavaScript files -->
    <script src="js/bootstrap.js"></script>
    <script src="js/proton.js"></script>
</body>
</html>