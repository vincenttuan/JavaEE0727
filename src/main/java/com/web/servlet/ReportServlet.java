package com.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/report")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;chartset=UTF-8");
        
        String headPath = "/result/report/head.jsp";
        String part1Path = "/result/report/part1.jsp";
        String part2Path = "/result/report/part2.jsp";
        String part3Path = "/result/report/part3.jsp";
        String footPath = "/result/report/foot.jsp";
        
        RequestDispatcher rd = null;
        
        rd = getServletContext().getRequestDispatcher(headPath);
        rd.include(req, resp);
        
        rd = getServletContext().getRequestDispatcher(part1Path);
        rd.include(req, resp);
        
        rd = getServletContext().getRequestDispatcher(footPath);
        rd.include(req, resp);
        
        
    }
    
}
