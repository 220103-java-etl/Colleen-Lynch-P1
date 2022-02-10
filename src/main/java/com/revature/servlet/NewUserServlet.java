package com.revature.servlet;

import com.revature.models.User;
import com.revature.models.UserBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Role;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class NewUserServlet extends HttpServlet {

    UserService userService = new UserService();
    AuthService authService = new AuthService();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("NewUser.html");
    }


    @Override
    protected
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside of doPost method");
        try {
            HttpSession session = request.getSession();
            Integer id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            Integer phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Role role = Role.valueOf(request.getParameter("role"));
//            response.sendRedirect("Employee.html");
            User u = new User(id, firstName, lastName, email, phoneNumber, address, username, password, role);
            authService.register(u);
            response.sendRedirect("Employee.html");

//            if (role == (Role.EMPLOYEE)) {
//                User u = new UserBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).setPhoneNumber(phoneNumber).setAddress(address).setUsername(username).setPassword(password).setRole(role).createUser();
//                session.setAttribute("user", u);
//            } else {
//                User u = userService.Register(id, firstName, lastName, email, phoneNumber, address, username, password, role);
//                authService.register(u);
//                session.setAttribute("user", u);
//                response.sendRedirect("Employee.html");
//            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
        }
    }
}



//    @Override
//    protected void doGet (HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
//        User u = objectMapper.readValue(request.getReader(), User.class);
//        u = userService.addUser(u);
//
//        StringBuilder uriString = new StringBuilder(request.getRequestURI());
//        System.out.println("URI: " + uriString);
//
//        uriString.replace(0, request.getContextPath().length() + 1, "");
//        System.out.println(uriString);
//
//        int id = 0;
//        if (uriString.indexOf("/") != -1) {
//            id = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "").toString());
//        }
//        System.out.println("Path now is: " + uriString);
//
//        if (id == 0) {
//            List<User> users = userService.getAll();
//            String responseBody = objectMapper.writeValueAsString(users);
//            response.getWriter().write(objectMapper.writeValueAsString(u));
//        }
//    }


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Get the parameters of username and password from the request.
//        User u = objectMapper.readValue(request.getReader(), User.class);
//
//        u = userService.addUser(u);
//
//        response.getWriter().write(objectMapper.writeValueAsString(u));
//





//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("servlet " + username);
//        System.out.println("servlet " + password);
//
//        User u = userService.login(username, password);
//            if (u != null) {
//              response.getWriter().write("Successfully logged in");
//              response.sendRedirect("/srs/main/webapp/EmpRbForm.html");
//
//
//                } else {
//                    response.setStatus(401);
//                }





