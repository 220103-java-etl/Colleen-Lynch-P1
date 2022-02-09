package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//public class FormServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//
//        resp.getWriter().write("The two numbers you sent in a GET request add up to: " + (num1 + num2));
//
//    }
//}

public class EmpRbFormServlet extends HttpServlet {
    ObjectMapper om = new ObjectMapper();
    ReimbursementService reimbursementService = new ReimbursementService();

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuilder uriString = new StringBuilder(request.getRequestURI());
        System.out.println("Request URI: " + uriString); // at this point the uri is -> /LibraryServlet/books

        uriString.replace(0, request.getContextPath().length() + 1, "");
        System.out.println("Without Context Path: " + uriString); // now we have -> books

        // Check to see if there is any more details after books - if there is we want to save that information. Create a variable to hold it and set it to 0 for later.
        int rbId = 0;

        if (uriString.indexOf("/") != -1) {
            rbId = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "" ).toString()); // if we had a request that was books/1, we want to access that 1. This line of code would save that Integer value into our bookId.
        }

        String path = uriString.toString();
        System.out.println("Path post check for slashes: " + path); // our path is now still 'books'

        if (rbId == 0) {

            switch (request.getMethod()) {

                case "GET": {
                    // we want to get all of the books from the server
                    response.setStatus(200);
                    response.getWriter().write(om.writeValueAsString(reimbursementService.getAllReimbursement()));
                    break;
                }

                case "POST": {
                    // we would want to read the request body and create a new book resource
                    Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
                    // then we would call our services/repos to add this book to the database
                   r= reimbursementService.addReimbursement(r); // taking this opprtunity to set the id (which our DB will automatically create)
                    //response.setStatus(201);
                    response.getWriter().write(om.writeValueAsString(r));
                    break;
                }

            }
        } else {
            Reimbursement r = null;
            switch (request.getMethod()) {
                case "GET": {
                    System.out.println("reimbursementId: " + rbId);
                    r = reimbursementService.getReimbursementById(rbId);
                    if (r != null) {
                        response.getWriter().write(om.writeValueAsString(r));
                    } else {
                        response.sendError(404, "Reimbursement not found.");
                    }
                    break;
                }

                case "PUT": {
                    r = om.readValue(request.getReader(), Reimbursement.class);
                    System.out.println(r);
                    reimbursementService.updateReimbursement(r);
                    break;
                }

                case "DELETE": {
                    r = om.readValue(request.getReader(), Reimbursement.class);
                    reimbursementService.deleteReimbursement(r.getId());
                    break;
                }

                default:
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    break;

            }
        }

    }

    // By putting these methods here, we are allowing only these 4 methods: GET, POST, PUT, DELETE.
    // We will parse what method we have in the process method, after we parse through the uri.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
}










//        ObjectMapper objectMapper = new ObjectMapper();
//        ReimbursementService rs = new ReimbursementService();
//
//        @Override
//        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//                throws ServletException, IOException {
//            HttpSession session = req.getSession(false);
//
//            if (session == null) {
//                resp.sendRedirect("index.html");
//            } else{
//                User user = (User) session.getAttribute("User");
//                List<Reimbursement> reimbursement = rs.getAllByUser(user);
//                System.out.println(reimbursement);
//                resp.getWriter().write(objectMapper.writeValueAsString(reimbursement));
//            }
//
//        }
//
//        @Override
//        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//                throws ServletException, IOException {
//            HttpSession session = req.getSession();
//            User user = (User) session.getAttribute("User");
//            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//
//            Reimbursement reimbursement = objectMapper.readValue(req.getReader(), Reimbursement.class);
//            reimbursement = rs.newReimbursement(reimbursement, user);
//
//            if (reimbursement != null) {
//                resp.getWriter().write(objectMapper.writeValueAsString(rs.getAllReimbursement()));
//            } else {
//                resp.setStatus(401);
//            }
//        }
//    }
