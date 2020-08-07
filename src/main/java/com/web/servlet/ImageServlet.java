package com.web.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        File file = new File("c:/upload/" + fname);
        System.out.println(file.length());
        
        resp.setContentType("image/*");
        resp.setContentLength((int)file.length());
        
        ServletOutputStream out = resp.getOutputStream();
        Files.copy(file.toPath(), out);
        out.close();
    }
    
}
