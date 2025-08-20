package com.Anjali.SpotWarn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Anjali.db.ConnectDb;

public class a_login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String a_email = request.getParameter("a_email");
        String a_pass = request.getParameter("a_pass");

        try {
            Connection con = ConnectDb.dbcon();
            PreparedStatement ps = con.prepareStatement("select * from login where a_email=? and a_pass=?");
            ps.setString(1, a_email);
            ps.setString(2, a_pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Login successful
                response.getWriter().write("success");
            } else {
                // Login failed
                response.getWriter().write("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Fail.html"); // Handle error redirect if needed
        }
    }
}
