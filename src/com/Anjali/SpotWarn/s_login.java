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

public class s_login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public s_login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String s_email = request.getParameter("s_email");
            String s_pass = request.getParameter("s_pass");
            Connection con = ConnectDb.dbcon();
            PreparedStatement ps = con.prepareStatement("select * from p_station where s_email=? and s_pass=?");
            ps.setString(1, s_email);
            ps.setString(2, s_pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Fail.html");
        }
    }
}

