

package servlet;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.Driver.userService;


public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the parameters of username and password from the request.
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("servlet " + username);
        System.out.println("servlet " + password);

        User u = userService.login(username, password);
            if (u != null) {
              resp.getWriter().write("Successfully logged in");
              resp.sendRedirect("/srs/main/webapp/EmpRbForm.html");


                } else {
                    resp.setStatus(401);
                }

            }

        }



