<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 데이터베이스 회원입력구문 -->
<%
//form(post)에서 전송되는 값 깨지므로 한글로 변환하여 변수에 저장하는 방법
request.setCharacterEncoding("utf-8"); 
//form에서 전달되는 값을 받고
//custno,custname,phone,address,joindate,grade,city
int custno=Integer.parseInt(request.getParameter("custno"));
String custname=request.getParameter("custname");
String phone=request.getParameter("phone");
String address=request.getParameter("address");
String joindate=request.getParameter("joindate");
String grade=request.getParameter("grade");
String city=request.getParameter("city");
//전달된 데이가 잘 전달되었는지 확인
StringBuffer buf=new StringBuffer();
buf.append(custno);buf.append(custname);buf.append(phone);buf.append(address);
buf.append(joindate);buf.append(grade);buf.append(city);
System.out.println(buf);
//데이터베이스 접속-sql만들고-실행을 해서 입력처리
Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection
 ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");

String sql="insert into member_tbl_02 values(?,?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(sql);
ps.setInt(1,custno);
ps.setString(2, custname);
ps.setString(3, phone);
ps.setString(4, address);
ps.setString(5, joindate);
ps.setString(6, grade);
ps.setString(7, city);

int result=ps.executeUpdate();
ps.close();
con.close();
if(result>0){
%>
<script>
alert('회원등록이 완료되었습니다.');
location.href="index.jsp"
</script>
<%}else{%>
<script>
alert('회원등록에 실패했습니다.');
location.href="createMember.jsp"
</script>
<%}%>