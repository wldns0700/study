<%@page import="jdbc.DBcon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
/* Connection conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
out.println(conn); */

Connection conn = DBcon.getConnetion();

String sql="select * from member_tbl_02 where custno=100003";
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
if(rs.next()){
	out.println(rs.getInt(1));
	out.println(rs.getString(2));
	out.println(rs.getString(3));
	out.println(rs.getString(2));
}
%>