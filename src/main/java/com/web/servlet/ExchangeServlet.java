package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@WebServlet("/servlet/exchange")
public class ExchangeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得前端參數
        int money = Integer.parseInt(req.getParameter("money"));
        String[] currs = req.getParameterValues("currency");
        List<Map<String, Double>> list = new ArrayList<>();
        for(String currency : currs) {
            // 換匯程序
            String symbol = currency + "TWD=x";
            Stock stock = YahooFinance.get(symbol);
            double exResult = money / stock.getQuote().getPrice().doubleValue();
            // 將換匯結果放置於 map
            Map<String, Double> map = new LinkedHashMap<>();
            map.put(currency, exResult);
            // 加入到 list
            list.add(map);
        }
        System.out.println(list);
        // 將 Servlet 的計算結果分派/重導
        RequestDispatcher rd = req.getRequestDispatcher("/result/exchangeresult.jsp");
        rd.forward(req, resp);

    }

}
