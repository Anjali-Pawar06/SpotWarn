package com.Anjali.Udb;
import java.sql.*;

public class UConnectDb {
	static Connection con= null;
public static Connection dbcon()
{
	if(con==null)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
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
