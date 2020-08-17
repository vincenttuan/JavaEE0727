package com.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/result")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        res.getWriter().println(email);
        res.getWriter().println(password);
        res.getWriter().println(remember);
        //chain.doFilter(req, res);
    }
    
}
