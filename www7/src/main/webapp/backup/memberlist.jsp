<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin:0;padding:0}
header{width:100%;height:50px;background-color: blue;color:white;font-size:25px;line-height:50px; }
nav{width:100%;height:40px;background-color: #8b00ff;line-height:40px;color:white;}
section{width:100%;height:400px;background-color: #eeeeee;}
footer{width:100%;height:100px;background-color:#000099;;color:white;line-height:100px;}
ul{list-style-type: none;}
li{ display:inline-block;}

header, h3, footer{text-align: center}

li{margin-left:12px}

a{
	text-decoration: none;	
	color:white;
}
a:visited {
	color:white;
}
table{
text-align:center;
margin-left: auto;
margin-right: auto;
}
</style>
</head>
<body>
<header>쇼핑몰 회원관리 ver1.0</header>
<nav>
<ul>
	<li><a href="createMember.jsp">회원등록</a></li>
	<li><a href="memberlist.jsp">회원목록조회/수정</a></li>
	<li><a href="sales.jsp">회원매출조회</a></li>
	<li><a href="index.jsp">홈으로</a></li>
</ul>
</nav>
<section>
<h3>회원목록조회/수정</h3>

<table border="1">
<tr>
	<th>회원번호</th>
	<th>회원성명</th>
	<th>전화번호</th>
	<th>주소</th>
	<th>가입일자</th>
	<th>고급등급</th>
	<th>거주지역</th>
</tr>
<%
//데이터베이스 접속-sql만들고-실행을 해서 입력처리
Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
//custno,custname,phone,address,joindate,grade,city
String sql="select * from member_tbl_02";
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
while(rs.next()){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = sdf.parse(rs.getString("joindate"));
	System.out.println(sdf.format(date));
%>
<tr>
	<td><a href="update.jsp?custno=<%=rs.getInt("custno")%>"><%=rs.getInt("custno")%></a></td>
	<td><%=rs.getString("custname") %></td>
	<td><%=rs.getString("phone") %></td>
	<td><%=rs.getString("address") %></td>
	<%-- <td><%=rs.getString("joindate") %></td> --%>
	<%-- <td><%=rs.getString("joindate").substring(0,10)%> --%>
	<td><%=sdf.format(date) %></td>
	<%-- <td><%=rs.getString("grade") %></td> --%>
	<td><%=(rs.getString("grade").charAt(0)=='A') ? "VIP" 
			: (rs.getString("grade").charAt(0)=='B') ? "일반" : "직원" %></td>
	<td><%=rs.getString("city") %></td>
</tr>
<%} 
rs.close();
ps.close();
con.close();
%>
</table>
</section>
<footer>HRDKOREA Copyright@2016 All rights reserved. Humun Resources Developer of Service Korea</footer>
</body>
</html>