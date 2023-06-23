package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBcon {
	private static Connection conn;
	
	public static Connection  getConnetion() {
		if(conn!=null) {
			return conn;
		}
		else {
			try {
				  Context initContext=new InitialContext();
			        //서버 환경에 설정된 환경변수 파일을 찾는다.(context.xml Resource);
			        Context envContext = (Context) InitialContext.doLookup("java:/comp/env");
			        DataSource ds = (DataSource) envContext.lookup("jdb/oracle");
			       conn = ds.getConnection();
			}
				catch(Exception e) {
						 e.printStackTrace();
						 }
			return conn;
				
			
			
	}
	

	}
}
