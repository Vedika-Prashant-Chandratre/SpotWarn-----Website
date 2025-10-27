package com.spotwarn.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transaction.BankConnectionUser.BankConnection;

/**
 * Servlet implementation class u_Register1
 */
public class u_Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public u_Register1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int uid=0;
		String u_name,u_mobile,u_email,u_pass,u_city;
		
		u_name=request.getParameter("u_name");
		u_mobile=request.getParameter("u_mobile");
		u_email=request.getParameter("u_email");
		u_pass=request.getParameter("u_pass");
		u_city=request.getParameter("u_city");
		
		try
		{
		Connection connection=BankConnection.dbcon();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into register values(?,?,?,?,?)");
		
		
		preparedStatement.setString(1,u_name);
		preparedStatement.setString(2,u_mobile);
		preparedStatement.setString(3,u_email);
		preparedStatement.setString(4,u_pass);
		preparedStatement.setString(5,u_city);
		
		int i=preparedStatement.executeUpdate();
		
		
		if(i>0)
		{
			System.out.println(i+" User's are inserted Successfully !!");

			response.sendRedirect("u_login.html");
			
		}
		else
		{
			System.out.println(" Failed to insert !!");
			response.sendRedirect("u_register.html");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}


