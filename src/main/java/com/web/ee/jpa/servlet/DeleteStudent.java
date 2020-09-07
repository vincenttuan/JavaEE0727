package com.web.ee.jpa.servlet;

import com.web.ee.jpa.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/student/delete")
public class DeleteStudent extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        // 取得要刪除的Entity(紀錄)
        Student student = em.find(Student.class, 2L);
        // 進行刪除
        if(student == null) {
            out.print("Delete error");
        } else {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(student);
            et.commit();
            em.close();
            out.print("Delete OK");
        }
    }
    
}
