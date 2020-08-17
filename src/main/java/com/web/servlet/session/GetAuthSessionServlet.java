package com.web.servlet.session;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session/getauth")
public class GetAuthSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 建立 Session 物件
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(5);
        resp.getWriter().println(session.getId());
        
        Faker faker = new Faker();
        String username = faker.name().firstName();
        session.setAttribute("username", username);
        
        resp.getWriter().println("Hello " + session.getAttribute("username"));
        
    }
    
}
