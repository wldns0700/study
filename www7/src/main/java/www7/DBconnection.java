package www7;
//싱글톤 프로그래밍

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static Connection conn;
	
	public static Connection getconnection() {
		if(conn!= null) {return conn;}
		else {
				
			try { if(conn==null) { Class.forName("oracle.jdbc.OracleDriver"); conn =
				  DriverManager.getConnection
				  ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
				 System.out.println("conn객체가 생성되었습니다."); } 
			
			}catch(Exception e) {
					 e.printStackTrace(); }
			
			
		}
		return null;
	}
	
	
	public DBconnection() {
		/*
		 * try { if(conn==null) { Class.forName("oracle.jdbc.OracleDriver"); conn =
		 * DriverManager.getConnection
		 * ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		 * System.out.println("conn객체가 생성되었습니다."); } }catch(Exception e) {
		 * e.printStackTrace(); }
		 */
		
	}

	}

