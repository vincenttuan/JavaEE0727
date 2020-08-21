package com.bigdata.controller;

import com.bigdata.model.Sales;
import com.bigdata.model.SalesModel;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bigdata")
public class BigDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sales[] saleses = SalesModel.getSaleses();
        // 設定 request attribute
        req.setAttribute("saleses", Arrays.asList(saleses));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/form/bigdataform.jsp");
        rd.forward(req, resp);
    }
    
}
