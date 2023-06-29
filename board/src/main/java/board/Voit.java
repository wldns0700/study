package board;

import java.util.Arrays;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/voit")
public class Voit {
    int[] arr = {0, 0, 0, 0};
    Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(int message, Session session) {
    	System.out.println(message);
        try {
            switch (message) {
                case 1: {
                    arr[0]++;
                    break;
                }
                case 2: {
                    arr[1]++;
                    break;
                }
                case 3: {
                    arr[2]++;
                    break;
                }
                case 4: {
                    arr[3]++;
                    break;
                }
            }
            //System.out.println(arr[0]+arr[1]+arr[2]+arr[3]);
            session.getBasicRemote().sendText(Arrays.toString(arr));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}