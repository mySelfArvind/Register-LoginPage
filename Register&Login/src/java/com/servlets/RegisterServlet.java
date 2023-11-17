package com.servlets;

import com.db.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name, email, password, gender, cond;
            name = request.getParameter("name");
            email = request.getParameter("email");
            password = request.getParameter("password");
            gender = request.getParameter("gender");
            cond = request.getParameter("cond");
            if ("check".equals(cond)) {
                Connection conn = DatabaseConnection.getConnection();
                String query = "insert into register(name,email,password,gender) values(?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, gender);
                boolean b = ps.execute();

                if (b == false) {
                    request.setAttribute("msg", "Registration Completed, Now you Login!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Something went Wrong");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }

                System.out.println(b);
            } else {
                RequestDispatcher rd2 = request.getRequestDispatcher("register.jsp");
                String msg = "You have not selected terms & conditions";
                request.setAttribute("msg", msg);
                rd2.include(request, response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
