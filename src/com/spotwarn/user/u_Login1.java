package com.spotwarn.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotwarn.datacon.user;
import com.transaction.BankConnectionUser.BankConnection;

/**
 * Servlet implementation class u_Login1
 */
public class u_Login1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public u_Login1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String u_email = request.getParameter("u_email");
            String u_pass = request.getParameter("u_pass");

            Connection connection = BankConnection.dbcon();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from register where u_email=? and u_pass=?");

            preparedStatement.setString(1, u_email);
            preparedStatement.setString(2, u_pass);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setU_email(u_email);
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Fail.html");
        }
    }
}
