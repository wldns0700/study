<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");

//select empno, ename from emp where empno>=7500 and empno<7600;
//select empno, ename from emp where empno between 7521 and 7566;

//String sql="select empno, ename from emp where empno>=? and empno<?";
//String sql="select empno, ename from emp where empno between ? and ?";

//String sql="select empno, ename from emp where empno like '?%'";
//String sql="select empno, ename from emp where empno like '?'";
//String sql="select empno, ename from emp where empno like ?";
int su=75;
String sql="select empno, ename from emp where empno like '"+su+"%'";
PreparedStatement ps=con.prepareStatement(sql);
//ps.setInt(1, 7521);
//ps.setInt(2, 7566);

//ps.setString(1,"'75%'");
ResultSet rs=ps.executeQuery();
while(rs.next()){
	out.println(rs.getString("empno"));
	out.println(rs.getString("ename"));
}	
 %>