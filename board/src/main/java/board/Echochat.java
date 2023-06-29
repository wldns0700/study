package board;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ecochat")
public class Echochat {
	Session session;
	@OnOpen
	public void open(Session session) {
		System.out.println("open");
	}
	@OnClose
	public void close(Session session) {
		System.out.println("close");
		
	}
	@OnError
	public void error(Throwable error) {
		System.out.println("error");
	}
	@OnMessage
	public void message(String message,Session session) {
		for(Session s:session.getOpenSessions()) {
			if(s.isOpen()) {
		s.getAsyncRemote().sendText(message);
			}
		}
		
}
}
