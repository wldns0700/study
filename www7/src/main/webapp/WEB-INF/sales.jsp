<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<li><a href="/createMember">회원등록</a></li>
	<li><a href="/memberlist">회원목록조회/수정</a></li>
	<li><a href="/sales">회원매출조회</a></li>
	<li><a href="/index">홈으로</a></li>
</ul>
</nav>
<section>
<h3>회원매출조회</h3>

<table border="1">
<tr>
	<th>회원번호</th>
	<th>회원성명</th>
	<th>고객등급</th>
	<th>매출</th>
</tr>
<c:forEach var="list" items="${sales}">
<tr>
	
	<td>${list.custno}</td>
	<td>${list.custname}</td>
	<td>${list.grade}</td>
	<td>${list.total}</td>
</tr>
</c:forEach>

</table>
</section>
<footer>HRDKOREA Copyright@2016 All rights reserved. Humun Resources Developer of Service Korea</footer>
</body>
</html>