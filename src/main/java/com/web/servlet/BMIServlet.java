package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet {
    
    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String h = req.getParameter("h");
        String w = req.getParameter("w");
        PrintWriter out = resp.getWriter();
        if(h == null || w == null) {
            out.print("Please input h, w !");
            return;
        }
        double height = Double.parseDouble(h);
        double weight = Double.parseDouble(w);
        double bmiValue = weight / Math.pow(height/100, 2);
        out.print(String.format("%.2f", bmiValue));
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("doGet not working... ");
        out.print("<a href='/JavaWeb0727/form/bmiform.jsp'>Click me</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    
}
