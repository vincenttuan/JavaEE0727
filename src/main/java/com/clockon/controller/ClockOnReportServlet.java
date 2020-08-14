package com.clockon.controller;

import com.clockon.model.ClockOnModel;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/clockonreport")
public class ClockOnReportServlet extends HttpServlet{
    private ClockOnModel model = new ClockOnModel();
    protected void doHandler(String no, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, String>> logs = model.queryClockOn(no);
        req.setAttribute("logs", logs);
        // 重導到 clock_on.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/clockon/view/clock_on.jsp");
        rd.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getAttribute("no") + "";
        doHandler(no, req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");
        doHandler(no, req, resp);
    }
    
}
