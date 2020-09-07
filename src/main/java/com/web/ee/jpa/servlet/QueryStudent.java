package com.web.ee.jpa.servlet;

import com.web.ee.jpa.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/student/query")
public class QueryStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 取得 EntityManager
        // myjpa 是 unit name, 請參考 persistence.xml 中的設定
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        //List<Student> list = em.createNamedQuery("Student.findAll").getResultList();
        List<Student> list = em.createNamedQuery("Student.findByAge")
                               .setParameter("age", 25)
                               .getResultList();
        out.println(list);
    }
    
}
