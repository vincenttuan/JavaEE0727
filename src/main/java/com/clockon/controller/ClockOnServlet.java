package com.clockon.controller;

import com.clockon.model.ClockOnModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/clockon")
public class ClockOnServlet extends HttpServlet {
    private ClockOnModel model = new ClockOnModel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String image = req.getParameter("image");
        String no = req.getParameter("no");
        boolean check = model.clockOn(no, image);
        resp.getWriter().print(check);
    }
    
}
