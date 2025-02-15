/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;


import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

import models.Role;
import models.User;

/**
 *
 * @author ThinkPro
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        UserDAO ud = new UserDAO();
        User user = ud.login(email, password);

        if (user == null) {
            session.setAttribute("notification", "Invalid Email or Password. Try again!");
            session.setAttribute("typeNoti", "alert-danger");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/index.jsp"); 
        }
    }
    
}