package com.Anjali.SpotWarn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Anjali.Udb.*;
import java.sql.*;

/**
 * Servlet implementation class U_Loginn
 */
public class U_Loginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_Loginn() {
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
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String u_email = request.getParameter("u_email");
	        String u_pass = request.getParameter("u_pass");

	        try {
	            Connection connection = UConnectDb.dbcon(); // Implement UConnectDb to get DB connection
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from register where u_email=? and u_pass=?");
	            preparedStatement.setString(1, u_email);
	            preparedStatement.setString(2, u_pass);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                // Login successful
	                response.getWriter().write("success");
	            } else {
	                // Login failed
	                response.getWriter().write("failure");
	            }

	            // Close resources
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().write("failure"); // Handle failure in case of SQL exception
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().write("failure"); // Handle other exceptions
	        }
	    }
	}