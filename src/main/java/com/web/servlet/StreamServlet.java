package com.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/stream"})
public class StreamServlet extends HttpServlet {
    
    protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = resp.getWriter();
        // 檢視 HTTP part 2
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = req.getHeader(name);
            out.println(name + ":" + value);
        }
        out.println("<hr>");
        // 檢視 HTTP part 4
        InputStream is = req.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        char[] buffer = new char[1];
        while (isr.read(buffer) != -1) {
            String s = new String(buffer);
            out.print(s);
            //out.flush();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }
    
}
