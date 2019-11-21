package net.canway;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletContext().getContextPath());
        String value1 = req.getServletContext().getInitParameter("key1");
        System.out.println(value1);
        resp.getWriter().println("HelloWorld");
    }

    @Override
    public void init(ServletConfig servletConfig) {
        String value = servletConfig.getInitParameter("name");
        System.out.println(value);
    }
}
