package net.canway;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getServletContext().getContextPath());
//        String value1 = req.getServletContext().getInitParameter("key1");
//        System.out.println(value1);
        /*ServletContext servletContext = req.getServletContext();

        String key1 = servletContext.getInitParameter("key1");
        System.out.println(key1);
        servletContext.setAttribute("name", "tonychen");
        System.out.println(servletContext.getAttribute("name"));
        servletContext.removeAttribute("name");
        System.out.println(servletContext.getAttribute("name"));*/
//        resp.getWriter().println(servletContext.getContextPath());
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            System.out.println(key + " : " + req.getParameter(key));
        }

        resp.setContentType("text/html;charset=utf-8");
        //修改response使用的码表
//		response.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("中国");
    }

    @Override
    public void init(ServletConfig servletConfig) {
        String value = servletConfig.getInitParameter("name");
        System.out.println(value);
    }

    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }
}
