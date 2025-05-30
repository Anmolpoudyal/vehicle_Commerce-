package com.autorent.controllers;

import com.autorent.model.User;
import com.autorent.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String email = request.getParameter("email");
       String password = request.getParameter("password");

       System.out.println("LoginServlet: Attempting login for email: " + email);
       
       User user = AuthService.login(email, password);
       if (user == null) {
           System.out.println("LoginServlet: Login failed - invalid credentials");
           request.setAttribute("errorMessage", "Invalid email or password.");
           request.getRequestDispatcher("login.jsp").forward(request, response);
           return;
       }

       System.out.println("LoginServlet: Login successful for " + user.getFirstName() + " " + user.getLastName());
       System.out.println("LoginServlet: User role is " + user.getRole());
       
       HttpSession session = request.getSession();
       session.setAttribute("user", user);
       session.setAttribute("role", user.getRole());
       session.setMaxInactiveInterval(30 * 60); // 30 minutes

       // Set success message before redirect
       session.setAttribute("successMessage", "Welcome back, " + user.getFirstName() + "!");

       // Redirect to index page for all users except admin
       if (user.getRole() == User.Role.admin) {
           System.out.println("LoginServlet: User is admin, redirecting to admin dashboard");
           response.sendRedirect(request.getContextPath() + "/admin/dashboard");
       } else {
           System.out.println("LoginServlet: User is not admin, redirecting to home page");
           response.sendRedirect(request.getContextPath() + "/index.jsp");
       }
    }
}