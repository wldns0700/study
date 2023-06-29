package board;

import java.util.StringTokenizer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@ServerEndpoint("/wsocket")
public class MywebSocket {
	static Session[] sessions=new Session[100];
	static int cnt=0;
	@OnOpen
	public void open(Session session) {
		System.out.println("open");
		sessions[cnt++]=session;
	}
	@OnClose
	public void close() {
		System.out.println("close");
	}
	@OnError
	public void error(Throwable error) {
		System.out.println("error");
	}
	@OnMessage
	public void message(String message,Session session) {
		try {
			JSONParser parser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) parser.parse(message);
			System.out.println(message.toString());
			String id = (String) jsonObject.get("id");
	        String messageContent = (String) jsonObject.get("message");
	        int whisper=0;
	        if(jsonObject.get("whisper")!=null) {
	        	whisper = Integer.parseInt((String) jsonObject.get("whisper"));
	        }
	        JSONObject responseObj = new JSONObject();
	        responseObj.put("id",id);
	        responseObj.put("message", messageContent);
	        
	        System.out.println(responseObj.toJSONString());
			//System.out.println(jobj2.toJSONString());
	    if(whisper==0) {
	    	for(int i=0;i<cnt;i++) {
	    	sessions[i].getBasicRemote().sendText(responseObj.toJSONString());
	    	}
	    }
	    else {
	    	sessions[whisper-1].getBasicRemote().sendText(responseObj.toJSONString());
	    }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
