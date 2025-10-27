package com.spotwarn.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transaction.BankConnectionAdmin.BankConnection2;

/**
 * Servlet implementation class a_Register
 */
public class a_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public a_Register() {
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
		try
		{
			String a_name=request.getParameter("a_name");
			String a_email=request.getParameter("a_email");
			String a_pass=request.getParameter("a_pass");
			
			System.out.println("_______");
			
			Connection con = BankConnection2.dbcon();
		    PreparedStatement ps1 = con.prepareStatement("insert into login values(?,?,?)");
		   
		    ps1.setString(1,a_name);
		    ps1.setString(2,a_email);
		    ps1.setString(3,a_pass);
		  
		    int i=ps1.executeUpdate();
		    if(i>0)
		    {
		    	response.sendRedirect("a_login.html");
		    	System.out.println("if part");
		    }
		    else
		    {
		    	response.sendRedirect("a_register.html");
		    	System.out.println("else part");
		    }
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}
