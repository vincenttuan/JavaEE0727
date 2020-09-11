package com.web.ee.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async/longjob", asyncSupported = true)
public class LongJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("進入 Servlet 時間: " + new Date() + "<p />");
        out.flush();
        // 商業邏輯
        AsyncContext ctx = req.getAsyncContext();
        LongJob job = new LongJob(ctx); // 建立 LongJob
        new Thread(job).start(); // 使用一條執行緒去執行 LongJob
        
        out.print("離開 Servlet 時間: " + new Date() + "<p />");
        
    }
    
}
