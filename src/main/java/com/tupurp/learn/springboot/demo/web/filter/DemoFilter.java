package com.tupurp.learn.springboot.demo.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
* web过滤器demo
* */
public class DemoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("This is demoFilter ,request url is " + request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
