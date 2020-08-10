package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/includeAndForward")
public class IncludeForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int x = 10;
        int y = 20;
        String path = "/result/add.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
        req.setAttribute("x", x);
        req.setAttribute("y", y);
        //rd.forward(req, resp);
        rd.include(req, resp);
        
        PrintWriter out = resp.getWriter();
        out.print("Finish");
    }
    
}
