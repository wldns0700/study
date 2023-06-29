package ex0502test;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("127.0.0.1",9999);
			if(socket.isConnected()) {
				System.out.println("클라이언트시작");
				LogWriter log = new LogWriter();
				log.logClient();
			}
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			while(true) {
			Protocol protocol = new Protocol();
			is.read(protocol.getPacket());
			
			protocol.setProtocolType(protocol.getPacket()[0]);
			
			switch(protocol.getProtocolType()) {
			case Protocol.PT_REQ_LOGIN : 
				protocol=new Protocol(Protocol.PT_RES_LOGIN);
				System.out.println("아이디를 입력하세요.");
				String id=new Scanner(System.in).nextLine();
				System.out.println("패스워드를 입력하세요.");
				String password=new Scanner(System.in).nextLine();
				System.arraycopy(id.getBytes(), 0, protocol.getPacket(), 1, id.length());//패킷에 아이디 입력
				System.arraycopy(password.getBytes(), 0, protocol.getPacket(), 10, password.length());//패킷에 비밀번호 입력
				out.write(protocol.getPacket());
				out.flush();
				break;
			case Protocol.PT_LOGIN_RESULT :
					System.out.println("로그인성공/챗팅쓰레드 생성");
					protocol = new Protocol(protocol.PT_LOGIN_RESULT_SUCESS);
					out.write(protocol.getPacket());
					out.flush();
					break;
				
			case Protocol.PT_CHAT:
				protocol=new Protocol(Protocol.PT_CHAT);
				System.out.println("여기됨");
				out.write(protocol.getPacket());
			
				Send send = new Send(socket);	
				Recv receive = new Recv(socket);
				
				send.start();
				receive.start();
				break;
				
			
			}
			if(protocol.getProtocolType() == Protocol.PT_LOGIN_RESULT_SUCESS ) {
				break;
			}	
			}//end while
			Send send = new Send(socket);	
			Recv receive = new Recv(socket);
			
			send.start();
			receive.start();
		 			
		
			
		}catch(Exception e) {}
		

	}

}
