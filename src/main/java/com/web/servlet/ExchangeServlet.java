package com.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/exchange")
public class ExchangeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 將 Servlet 的計算結果分派/重導
        RequestDispatcher rd = req.getRequestDispatcher("/result/exchangeresult.jsp");
        rd.forward(req, resp);
        
    }
    
}
