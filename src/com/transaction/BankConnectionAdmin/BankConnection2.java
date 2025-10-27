package com.transaction.BankConnectionAdmin;

import java.sql.*;

public class BankConnection2 {
	
	static Connection con=null;
	
	
	public static Connection dbcon()
	{
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
	
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		
		
		return con;
	}

}

