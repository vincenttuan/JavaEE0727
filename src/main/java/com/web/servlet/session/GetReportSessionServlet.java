package com.web.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session/getreport")
public class GetReportSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.getWriter().println(session);
        if(session != null) {
            resp.getWriter().println("Hello " + session.getAttribute("username"));
            resp.getWriter().println(session.getId());
            resp.getWriter().println("Report data ...");
        }
    }
    
}
