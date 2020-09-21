package com.web.ee.websocket;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.PathParam;

@ServerEndpoint("/websocket/chat/{room-no}")
public class ChatServer {
    private static CopyOnWriteArraySet<Session> sessions;
    @OnOpen
    public void onOpen(Session session, @PathParam("room-no") String roomNo) {
        System.out.println("session id: " + session.getId() + " 進入 roomNo:  " + roomNo);
        if(sessions == null) {
            sessions = new CopyOnWriteArraySet<>();
        }
        sessions.add(session);
        sendAll("歡迎 " + session.getId() + " 進入 roomNo:  " + roomNo);
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
                session.getAsyncRemote().sendText(message + " <font color='#aaaaaa' size='1'>" + new Date() + "</font>");
            }
        }
    }
}
