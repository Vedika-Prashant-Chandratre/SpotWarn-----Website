package com.transaction.BankConnectionPolice;

import java.sql.*;

public class BankConnection3 {
	
	static Connection con=null;
	
	
	public static Connection dbcon()
	{
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/police_station","root","");
			
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

