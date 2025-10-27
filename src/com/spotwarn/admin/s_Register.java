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
 * Servlet implementation class s_Register
 */
public class s_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_Register() {
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
			String s_name=request.getParameter("s_name");
			String s_address=request.getParameter("s_address");
			String s_contact=request.getParameter("s_contact");
			String s_email=request.getParameter("s_email");
			String s_pass=request.getParameter("s_pass");
			
			
			
			Connection con = BankConnection2.dbcon();
		    PreparedStatement ps1 = con.prepareStatement("insert into p_station values (?,?,?,?,?)");
		   
		    ps1.setString(1,s_name);
		    ps1.setString(2,s_address);
		    ps1.setString(3,s_contact);
		    ps1.setString(4,s_email);
		    ps1.setString(5,s_pass);
		    
		    
		    
		  
		    int i=ps1.executeUpdate();
		    if(i>0)
		    {
		    	response.sendRedirect("s_login.html");
		    }
		    else
		    {
		    	response.sendRedirect("s_register.html");
		    }
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
