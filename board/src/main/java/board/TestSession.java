package board;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class TestSession {
	static Session[] sessions=new Session[100];
	static int cnt=0;
	@OnOpen
	public void open(Session session) {
		sessions[cnt++]=session;
		System.out.println("cnt:"+cnt);
	}
	@OnClose
	public void close(Session session) {
		System.out.println("close");
		System.out.println(session.getId());
		//배열에 있는 sessions에 있는 아이디와 현재 접속된 아이디가 일치할 때 해제처리
	}
	@OnError
	public void error(Throwable error) {
		System.out.println("error");
	}
	@OnMessage
	public void message(String message,Session session) {
		System.out.println(message);
		for(int i=0;i<cnt;i++) {
			try {
				sessions[i].getBasicRemote().sendText(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
