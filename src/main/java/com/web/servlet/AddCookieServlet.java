package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/addcookie")
public class AddCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;encoding=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        
        Cookie[] cookies = req.getCookies();
        if (cookies == null) { // cookie 不存在
            out.print("Cookie 沒資料");
        } else {
            // 分析每一筆 cookie
            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        
        int num = new Random().nextInt(100);
        // 將 數字 存入字串
        Cookie c1 = new Cookie("num", num + "");
        c1.setMaxAge(60 * 60);
        resp.addCookie(c1);

        out.print(num);
    }

}

