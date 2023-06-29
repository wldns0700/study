<%@page import="javax.xml.stream.Location"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int coustno = Integer.parseInt(request.getParameter("coustno"));
String name = request.getParameter("name");
String join = request.getParameter("join");
String vip = request.getParameter("vip");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String code = request.getParameter("code");
 Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection 
("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
 System.out.println(con);
 String sql="UPDATE member_tbl_02 SET custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
 PreparedStatement ps = con.prepareStatement(sql);
 ps.setString(1,name);
 ps.setString(2,phone);
 ps.setString(3,address);
 ps.setString(4,join);
 ps.setString(5,vip);
 ps.setString(6,code);
 ps.setInt(7,coustno);

 int rs = ps.executeUpdate(); 
 response.sendRedirect("index.jsp");
 
%>