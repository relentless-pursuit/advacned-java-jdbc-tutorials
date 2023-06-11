package myproject.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LifecycleServlet extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Servlet is being initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>This is the Lifecycle Servlet</h1>");
        out.close();
        System.out.println("Handling HTTP GET request");
    }

    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}
