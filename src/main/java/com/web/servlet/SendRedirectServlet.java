package com.web.servlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/sendredirect")
public class SendRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int n = new Random().nextInt(100);
        if(n % 2 == 0) {
            resp.sendRedirect("https://tw.yahoo.com/");
        } else {
            getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
        }
        
    }
    
}
