package com.Anjali.SpotWarn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Anjali.Udb.UConnectDb;
/**
 * Servlet implementation class U_Register
 */
public class U_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_Register() {
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
		
		
		String u_name,u_mobile,u_email,u_pass,u_city;
		
		u_name=request.getParameter("u_name");
		u_mobile=request.getParameter("u_mobile");
		u_email=request.getParameter("u_email");
		u_pass=request.getParameter("u_pass");
		u_city=request.getParameter("u_city");
		
		try
		{
		Connection con=UConnectDb.dbcon();
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
		
		
		ps.setString(1,u_name);
		ps.setString(2,u_mobile);
		ps.setString(3,u_email);
		ps.setString(4,u_pass);
		ps.setString(5,u_city);
		
		int i=ps.executeUpdate();
		
		
		if(i>0)
		{
			System.out.println(i+" User's are inserted Successfully !!");

			response.sendRedirect("u_login.html");
			
		}
		else
		{
			System.out.println(" Failed to insert !!");
			response.sendRedirect("Fail.html");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
