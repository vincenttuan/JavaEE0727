package com.web.ee.jdbc.servlet;

import com.web.ee.jdbc.bean.Book;
import com.web.ee.jdbc.bean.ResultSetToBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 路徑 ex: http://localhost:8080/JavaEE0727/servlet/jdbc/get/book?id=1
@WebServlet("/servlet/jdbc/get/book")
public class GetBookServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Connection conn = (Connection)getServletContext().getAttribute("conn");
        String sql = "SELECT id, title, price, amount, ts FROM Book WHERE id=" + id;
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            if(rs.next()) {
                Book book = (Book)ResultSetToBean.copy(rs, Book.class);
                resp.getWriter().print(book);
            } else {
                resp.getWriter().print("No data, Get error !");
                return;
            }
            
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
    
}
