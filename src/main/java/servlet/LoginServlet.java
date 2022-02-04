
package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
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

//    public LoginServlet(){
//        super();
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        RequestDispatcher dispatcher //
//                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        User user = UserDAO.findUser(userName, password);
//
//        if (user == null) {
//            String errorMessage = "Invalid userName or Password";
//
//            request.setAttribute("errorMessage", errorMessage);
//
//            RequestDispatcher dispatcher //
//                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//
//            dispatcher.forward(request, response);
//            return;
//        }
//
//        AppUtils.storeLoginedUser(request.getSession(), userAccount);
//
//        //
//        int redirectId = -1;
//        try {
//            redirectId = Integer.parseInt(request.getParameter("redirectId"));
//        } catch (Exception e) {
//        }
//        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
//        if (requestUri != null) {
//            response.sendRedirect(requestUri);
//        } else {
//            // Default after successful login
//            // redirect to /userInfo page
//            response.sendRedirect(request.getContextPath() + "/userInfo");
//        }
//
//    }
//
//}


    UserService userService = new UserService();
    ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("index.html");
        } else{
            User user = (User) session.getAttribute("User");
            resp.getWriter().write(om.writeValueAsString(user));
        }
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User u = userService.login(username, password);

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("User", u);
            response.sendRedirect("/srs/main/webapp/EmpRbForm.html");

        } else {
            response.setStatus(401);
        }

    }
}

