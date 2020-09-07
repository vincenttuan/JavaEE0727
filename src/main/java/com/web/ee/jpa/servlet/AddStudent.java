package com.web.ee.jpa.servlet;

import com.web.ee.jpa.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/student/add")
public class AddStudent extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 取得 EntityManager
        // myjpa 是 unit name, 請參考 persistence.xml 中的設定
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa");
        EntityManager em = emf.createEntityManager();
        // 建立 Student 物件/Entity
        Student student = new Student();
        student.setName("John");
        student.setAge(18);
        // 將 Student 物件/Entity 映射到資料庫, 也就是新增一筆紀錄
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(student);
        et.commit();
        em.close();
        emf.close();
        out.print("Add OK");
    }
    
}
