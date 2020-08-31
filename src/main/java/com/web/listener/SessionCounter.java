package com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class SessionCounter implements HttpSessionListener {
    private static int count;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ++count;
        System.out.println("目前連線數量: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        --count;
        System.out.println("目前連線數量: " + count);
    }
    
}
