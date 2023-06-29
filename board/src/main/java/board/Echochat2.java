package board;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ecochat2")
public class Echochat2 {
	static Set<Session> sessions = new HashSet<Session>();
	@OnOpen
	public void open(Session session) {
		System.out.println("open");
		sessions.add(session);
		System.out.println("opne : "+ sessions.size());
	}
	@OnClose
	public void close(Session session) {
		System.out.println("close");
		sessions.remove(session);
		System.out.println("close:"+sessions.size());
		
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
