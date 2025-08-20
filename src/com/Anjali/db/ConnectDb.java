package com.Anjali.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
	static Connection con= null;
	public static Connection dbcon()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
				System.out.println("Connection established!!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			return con;
		}
	}
	


