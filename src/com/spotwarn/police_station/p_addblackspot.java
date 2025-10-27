package com.spotwarn.police_station;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.transaction.BankConnectionPolice.BankConnection3;
import com.spotwarn.datacon.blackspot;

/**
 * Servlet implementation class p_addblackspot
 */
public class p_addblackspot extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_addblackspot() {
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

        try {
            String p_locationname = request.getParameter("p_locationname");
            String p_address = request.getParameter("p_address");
            String p_reason = request.getParameter("p_reason");
            String p_latitude = request.getParameter("p_latitude");
            String p_longitude = request.getParameter("p_longitude");
            String p_level = request.getParameter("p_level");
            String p_city = request.getParameter("p_city");

            Connection con = BankConnection3.dbcon();
            PreparedStatement ps1 = con.prepareStatement("insert into add_black_spot values(?,?,?,?,?,?,?)");

            ps1.setString(1, p_locationname);
            ps1.setString(2, p_address);
            ps1.setString(3, p_reason);
            ps1.setString(4, p_latitude);
            ps1.setString(5, p_longitude);
            ps1.setString(6, p_level);
            ps1.setString(7, p_city);

            int i = ps1.executeUpdate();
            if (i > 0) {
                response.sendRedirect("police_dashboard.html");

                blackspot.setP_reason(p_reason);
                blackspot.setP_level(p_level);
                blackspot.setP_city(p_city);

                PreparedStatement ps2;
                if (p_level.equals("1")) {
                    ps2 = con.prepareStatement("insert into zone_report (z_level, z_yellow) values (?,?)");
                    ps2.setString(1, "1");
                    ps2.setString(2, p_locationname);
                    ps2.executeUpdate();
                } else if (p_level.equals("2")) {
                    ps2 = con.prepareStatement("insert into zone_report (z_level, z_orange) values (?,?)");
                    ps2.setString(1, "2");
                    ps2.setString(2, p_locationname);
                    ps2.executeUpdate();
                } else if (p_level.equals("3")) {
                    ps2 = con.prepareStatement("insert into zone_report (z_level, z_red) values (?,?)");
                    ps2.setString(1, "3");
                    ps2.setString(2, p_locationname);
                    ps2.executeUpdate();
                }

                if (p_reason.equals("Pickpocketing")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Pickpocketing) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Burglary")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Burglary) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Robbery")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Robbery) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Mugging")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Mugging) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Vandalism")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Vandalism) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Extortion")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Extortion) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Smuggling")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Smuggling) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Fraud")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Fraud) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Carjacking")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Carjacking) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_reason.equals("Hooliganism")) {
                    ps2 = con.prepareStatement("insert into reason_report (r_Hooliganism) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                }

                if (p_city.equals("Mumbai")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Mumbai) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Pune")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Pune) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Nagpur")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Nagpur) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Nashik")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Nashik) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Sambhaji Nagar")) {
                    ps2 = con.prepareStatement("insert into city_report (c_SambhajiNagar) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Solapur")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Solapur) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Amravati")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Amravati) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Kolhapur")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Kolhapur) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Thane")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Thane) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                } else if (p_city.equals("Jalgaon")) {
                    ps2 = con.prepareStatement("insert into city_report (c_Jalgaon) values(?)");
                    ps2.setString(1, p_locationname);
                    ps2.executeUpdate();
                }
            } else {
                response.sendRedirect("failed_spot.html");
            }

            // Close the PreparedStatement and Connection objects to avoid memory leaks
            ps1.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
