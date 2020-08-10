package com.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/secure/mycar/*")
public class MyCarFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //int age = Integer.parseInt(req.getParameter("age"));
        String age = req.getParameter("age");
        try {
            if(age == null || Integer.parseInt(age) < 18) {
                res.sendRedirect("/form/mycarform.jsp");
            } else {
                chain.doFilter(req, res);
            }
        } catch (Exception e) {
            res.sendRedirect("/form/mycarform.jsp");
        }
        
    }
    
}
