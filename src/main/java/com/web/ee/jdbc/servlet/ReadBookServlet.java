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

@WebServlet("/servlet/jdbc/read/book")
public class ReadBookServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Connection conn = (Connection)getServletContext().getAttribute("conn");
        String sql = "SELECT id, title, price, amount, ts FROM Book";
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            List<Book> books = new ArrayList<>();
            while (rs.next()) {                
                Book book = (Book)ResultSetToBean.copy(rs, Book.class);
                books.add(book);
            }
            resp.getWriter().print(books);
            
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
    
}
