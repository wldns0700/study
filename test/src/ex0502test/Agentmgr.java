package ex0502test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Agentmgr {

	public void serverlog() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery("select *from logtable where kind='server'");
		while(rs.next()) {
			System.out.println(rs.getString("contime"));
	}
		rs.close();
		stat.close();
		conn.close();
	}
	
	public void servercou() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select count(*) as count from logtable where kind='server'");
			if(rs.next()) {
				System.out.println(rs.getInt("count"));
				
			}
			rs.close();
			stat.close();
			conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
	}
	public void clientlog() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from logtable where kind='client'");
	while(rs.next()) {
		System.out.println(rs.getString("contime"));
		
	}
	rs.close();
	stat.close();
	conn.close();
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
	public void clientcou() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select count(*) as count from logtable where kind='client'");
			if(rs.next()) {
				System.out.println(rs.getInt("count"));
				
			}
			rs.close();
			stat.close();
			conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
	}
}
