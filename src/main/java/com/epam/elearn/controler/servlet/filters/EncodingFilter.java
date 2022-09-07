package com.epam.elearn.controler.servlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(urlPatterns = "/*",
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")},
        dispatcherTypes = {DispatcherType.REQUEST}
)
public class EncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String characterEncoding = req.getCharacterEncoding();
        if (characterEncoding == null) {
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }
}
