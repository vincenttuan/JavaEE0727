package com.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
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
        if(remember != null) {
            Cookie cookie = new Cookie("email", email); // 建立 Cookie 物件
            cookie.setMaxAge(30); // 存續時間
            res.addCookie(cookie); // 加入到 response 物件
        }
        if(email.contains("admin")) {
            chain.doFilter(req, res);
        } else {
            // 重導致 loginform.jsp
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/JavaWeb0727/form/loginform.jsp");
            rd.forward(req, res);
        }
    }
    
}
