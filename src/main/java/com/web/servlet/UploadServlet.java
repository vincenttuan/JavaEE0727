package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/upload"})
@MultipartConfig(
        fileSizeThreshold = 1024*1024*1,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*20,
        location = "C:/upload"
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 分析 part (name=file)
        req.getParts().stream()
                .filter(part -> part.getName().equals("myfile1"))
                .forEach(part -> {
                    try {
                        part.write(part.getSubmittedFileName());
                        out.print(part.getSubmittedFileName() + " Upload OK !");
                    } catch (Exception e) {
                    }
                });
        
    }
    
}
