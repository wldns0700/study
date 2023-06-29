package ex0502test;




import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

	public static void main(String[] args) {
		try {
			System.out.println("서버실행 ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			
			if(client.isConnected()) {
				System.out.println("클라이언트 접속");
				LogWriter log = new LogWriter();
				log.logServer();
			}
			
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			Protocol protocol=new Protocol(Protocol.PT_REQ_LOGIN);
			out.write(protocol.getPacket());
			out.flush();
		
			while(true) {
			protocol=new Protocol();
			in.read(protocol.getPacket());
			
			protocol.setProtocolType(protocol.getPacket()[0]);
			
			switch(protocol.getProtocolType()) {
			case Protocol.PT_RES_LOGIN :
				System.out.println("로그인확인");
				String id=protocol.getId();
				String password=protocol.getPassword();
				System.out.println("id:"+id);
				System.out.println("pass:"+password);
				if(id.equals("admin") && password.equals("1234")) {
					System.out.println("로그인성공보낼예정");
					protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
					//protocol.getPacket()[1]=31;
					out.write(protocol.getPacket());
					out.flush();
					System.out.println("반복문 빠져나와서 ");
					System.out.println("송수신 쓰레스 생성");
					
					
				}else {
					System.out.println("로그인실패보낼예정");
					protocol=new Protocol(Protocol.PT_REQ_LOGIN);
					//protocol.getPacket()[1]=30;
					out.write(protocol.getPacket());
					out.flush();
					
				}
				break;
			case Protocol.PT_LOGIN_RESULT_SUCESS :
				protocol=new Protocol(Protocol.PT_CHAT);
				out.write(protocol.getPacket());
				out.flush();
				break;
				
			
				
			}
			if(protocol.getProtocolType() == Protocol.PT_LOGIN_RESULT_SUCESS ) {
				break;
			}
			Send send = new Send(client);	
			Recv receive = new Recv(client);
			
			send.start();
			receive.start();
			
			
			}
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		System.out.println("이거나오면 안됨");
	}
 
}
