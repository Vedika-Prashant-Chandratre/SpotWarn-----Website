package com.spotwarn.admin;

import com.spotwarn.datacon.*;
import com.transaction.BankConnectionAdmin.BankConnection2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Servlet implementation class s_Login
 */
public class s_Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_Login() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_email = request.getParameter("s_email");
        String s_pass = request.getParameter("s_pass");

        try {
            Connection con = BankConnection2.dbcon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM p_station WHERE s_email = ? AND s_pass = ?");
            ps.setString(1, s_email);
            ps.setString(2, s_pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ForGetSet.setS_email(rs.getString("s_email"));
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("error");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
