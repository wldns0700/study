package ex0502test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgentMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		while(true) {
		
		
			
		switch(menu()) {
		
		
		// 1.서버의 로그기록 확인
	
		
			case 1 :
				new Agentmgr().serverlog();
		break;
		// 2.클라이언트의 로그기록 확인
			case 2 :
				new Agentmgr().clientlog();
		break;
		//3.서버의 접속횟수 확인
			case 3:
				new Agentmgr().servercou();
		break;
		//4.클라이언트의 접속횟수 확인
			case 4:
				new Agentmgr().clientcou();
		break;
			case 5:
				System.exit(0);
		default : 
			System.out.println("잘못된 입력입니다.");
			
		}
		System.in.read();
		System.in.read();
		}//end while
	}

	static int menu() throws IOException {
		
		System.out.println("-------------------");
		System.out.println("1.서버의 로그기록 확인"); 
		System.out.println("2.클라이언트의 로그기록 확인"); 
		System.out.println("3.서버의 접속횟수 확인");
		System.out.println("4.클라이언트의 접속횟수 확인"); 
		System.out.println("5.시스템 종료");
		System.out.println("-------------------");
		int sel=System.in.read()-48;
		while(System.in.available()>0) {
			System.in.read();
		}
		return sel;

	}
}
