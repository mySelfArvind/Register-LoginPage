package com.servlets;

import com.db.DatabaseConnection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email, password;
        email = request.getParameter("email");
        password = request.getParameter("password");
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "select * from register where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            boolean result = rs.next();

            if (result == true) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Email or Password didn't match, Try Again");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException | ServletException | IOException e) {

        }
    }

}
