package com.web.servlet;

import javax.servlet.http.HttpServlet;

public class AreaServlet extends HttpServlet {
    /* 
        /servlet/area?type=c&r=10 (圓形面積 : 314.00)
        /servlet/area?type=r&w=10&h=5 (矩形面積 : 50.00)
        /servlet/area?type=a&b=10&h=5 (三角形面積 : 25.00)
        預設顯示小數點 2 位 <-- 可透過 WebInitParam 設定
    */
}
