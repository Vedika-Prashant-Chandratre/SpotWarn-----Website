package com.spotwarn.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.spotwarn.datacon.ForGetSet;
import com.transaction.BankConnectionAdmin.BankConnection2;

/**
 * Servlet implementation class a_Login
 */
public class a_Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String a_email = request.getParameter("a_email");
        String a_pass = request.getParameter("a_pass");

        try {
            // Establish database connection
            Connection con = BankConnection2.dbcon();
            
            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement("SELECT * FROM login WHERE a_email = ? AND a_pass = ?");
            ps.setString(1, a_email);
            ps.setString(2, a_pass);
            
            // Execute query
            ResultSet rs = ps.executeQuery();
            
            // Check if login is successful
            if (rs.next()) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Fail.html"); // Handle error redirect if needed
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request if necessary, otherwise redirect to an error page or login page
        response.sendRedirect("a_login.html");
    }
}
