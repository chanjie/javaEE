package net.canway.filter;

import javax.servlet.*;
import java.io.IOException;

public class IndexFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("index init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        System.out.println("进入index过虑器");
        System.out.println("username: " + username);
        System.out.println("离开index过虑器");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("index destroy");
    }
}
