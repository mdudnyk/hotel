package com.epam.elearn.controler.servlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LocaleFilter", urlPatterns = { "/*" })
public class LocaleFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

//        HttpServletRequest req = (HttpServletRequest) request;
//
//        if (req.getParameter("lang") != null) {
//            req.getSession().setAttribute("locale", req.getParameter("lang"));
//        } else {
//
//            req.getSession().setAttribute("locale", "en");
//        }
//        System.out.println("request = " + ((HttpServletRequest) request).getRequestURL().toString());
//        System.out.println("req param = " + req.getParameter("lang"));
//        System.out.println("ses param = " + req.getSession().getAttribute("locale"));
        chain.doFilter(request, response);
    }

    public void destroy() {}

    public void init(FilterConfig arg0) {}

}
