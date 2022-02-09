
package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();
    AuthService authService = new AuthService();
    ReimbursementService reimbursementService = new ReimbursementService();
      ObjectMapper om = new ObjectMapper();


    @Override
    protected
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
//        reimbursementService.updateReimbursement(r);
        resp.sendRedirect("index.html");

//            if (session == null) {
//                resp.sendRedirect("index.html");
//            } else {
//                User user = (User) session.getAttribute("User");
//                resp.getWriter().write(om.writeValueAsString(user));
//            }
    }

    @Override
    protected
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            User u = userService.login(username, password);
            session.setAttribute("user", u);
//            String role = String.valueOf(user.getRole());
            if (u.getRole().equals(Role.EMPLOYEE)) {
                User user = UserDAO.getByUsername(username);
                session.setAttribute("user", user);
                response.sendRedirect("Employee.html");

//                String role = String.valueOf(user.getRole());
//
            } else {
                response.sendRedirect("FinanceManager.html");
            }
        } catch (Exception e) {
            String exception = e.getMessage();
            response.setContentType("text/html");

        }
        // (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
//                session.setAttribute("User", u);
//                response.sendRedirect("EmpRbForm.html");

//            } else {
//                response.sendRedirect("NewUser.html");
//            }

    }
}

