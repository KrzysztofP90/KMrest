package routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.getWriter().write("<html><body><h1>Run start servlet!!!</h1></body></html>");
    }
}
