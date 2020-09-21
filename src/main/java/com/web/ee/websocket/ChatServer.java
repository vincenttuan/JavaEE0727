package com.web.ee.websocket;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/chat")
public class ChatServer {
    private CopyOnWriteArraySet<Session> sessions;
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("session id: " + session.getId() + " 連入");
        if(sessions == null) {
            sessions = new CopyOnWriteArraySet<>();
        }
        sessions.add(session);
        sendAll("歡迎 " + session.getId() + "加入");
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("session id: " + session.getId() + " 說: " + message);
        sendAll(session.getId() + " 說: " + message);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("session id: " + session.getId() + " 離開");
        if(sessions != null) {
            sessions.remove(session);
            sendAll("哇哩勒~ " + session.getId() + " 離開了");
        }
    }
    
    // 廣播給所有人
    private void sendAll(String message) {
        if(sessions != null) {
            for(Session session : sessions) {
                session.getAsyncRemote().sendText(message);
            }
        }
    }
}
