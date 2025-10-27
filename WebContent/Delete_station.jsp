
<%@page import="com.transaction.BankConnectionAdmin.*"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Station</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f8f9fa;
        font-family: 'Roboto', sans-serif;
    }
    .container {
        margin-top: 50px;
    }
    .card {
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
    .card-header {
        background-color: #dc3545;
        color: white;
        font-weight: bold;
    }
    .card-body {
        text-align: center;
    }
    .btn-custom {
        background-color: #dc3545;
        color: white;
    }
</style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header">
            Delete Station
        </div>
        <div class="card-body">
            <%
                String message = "";
                boolean showForm = true;
                if (request.getParameter("delete") != null) {
                	try
                	{
                		String s_name=request.getParameter("s_name");
                		Connection con=BankConnection2.dbcon();
                		PreparedStatement ps1 = con.prepareStatement("delete from p_station where s_name=?");
                			ps1.setString(1,s_name);
                			int i= ps1.executeUpdate();
                			if(i>0)
                			{
                				response.sendRedirect("view_stationAdmin.jsp");
                			}
                			else
                			{
                				response.sendRedirect("failed_station.html");
                			}
                    } catch (Exception e) {
                        message = "An error occurred: " + e.getMessage();
                    }
                    showForm = false;
            %>
            <h5 class="card-title"><%= message %></h5>
            <a href="view_stationAdmin.jsp" class="btn btn-custom">Go Back</a>
            <%
                }
                if (showForm) {
            %>
            <form action="Delete_station.jsp" method="post">
                <div class="form-group">
                    <label for="rid">Enter the Station Name to Delete:</label>
                    <input type="text" class="form-control" id="rid" name="s_name" placeholder="Station Name" required>
                </div>
                <button type="submit" name="delete" class="btn btn-custom">Delete Station</button>
            </form>
            <%
                }
            %>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

</html>
