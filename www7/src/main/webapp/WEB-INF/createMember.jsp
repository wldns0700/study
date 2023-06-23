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

table{
text-align:center;
margin-left: auto;
margin-right: auto;
}

a{
	text-decoration: none;
	text-decoration-color:white;
	color:white	
}
a:visited {
	color:white;
}

</style>

<script>
function valueCheck(){
	//빈란, 길이, 도메인(범위안의속한 값인지 여부 확인), 유효성검사
//custno,custname,phone,address,joindate,grade,city
if(document.getElementById("custname").value==""){
	alert('회원성명이 입력되지 않았습니다.');
	document.getElementById("custname").focus();
	return;
}
if(document.getElementById("phone").value==""){
	alert('전화번호가 입력되지 않았습니다.');
	document.getElementById("address").focus();
	return;
}
if(document.getElementById("address").value==""){
	alert('주소가 입력되지 않았습니다.');
	document.getElementById("joindate").focus();
	return;
}
if(document.getElementById("joindate").value==""){
	alert('가입일자가 입력되지 않았습니다.');
	document.getElementById("grade").focus();
	return;
}
if(document.getElementById("grade").value==""){
	alert('고객등급이 입력되지 않았습니다.');
	document.getElementById("city").focus();
	return;
}
if(document.getElementById("city").value==""){
	alert('도시코드가 입력되지 않았습니다.');
	document.getElementById("city").focus();
	return;
}

//고객등급의 A,B,C 값의 범위를 확인하는 방법, 도시코드의 길이를 확인하는 방법을 구현해볼 것
//추가사항으로 가입일자의 길이가 문자열이며 숫자임을 확인하는 유효성 검사도 구현해 볼 것
//만약 중간에 유효성검사를 통해 오류사항이 있을 경우 프로그램을 중지해야하는 것도 확인해야함
//고객등급의 A,B,C를 dropdown형태로 구성하세요.
document.forms[0].requestSubmit();
//alert('회원등록이 완료되었습니다.')
}
</script>
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
<h3>홈쇼핑 회원 등록</h3>
<form action="/createMember/proc" method="post">
<table border="1">
	<tr>
		<td>회원번호(자동발생)</td>
		<td><input type="text" id="custno" name="custno" value="${last+1}" readonly></td>
	</tr>
	
	<tr>
		<td>회원성명</td><td>
		<input type="text" id="custname" name="custname"></td>
	</tr>
	
	<tr>
		<td>회원전화</td>
		<td><input type="text" id="phone" name="phone"></td>
	</tr>

	<tr>
		<td>회원주소</td>
		<td><input type="text" id="address" name="address"></td>
	</tr>
	
	<tr>
		<td>가입일자</td>
		<td><input type="text" id="joindate" name="joindate"></td>
	</tr>
	
	<tr>
		<td>고급등급[A:VIP,B:일반,C:직원]</td>
		<td><input type="text" id="grade" name="grade"></td>
	</tr>
	
	<tr>
		<td>도시코드</td>
		<td><input type="text" id="city" name="city"></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="button" onclick="valueCheck()" value="등록">
			<input type="button" onclick="location.href='/memberlist'" value="조회">
		</td>
	</tr>
</table>
</form>
</section>
<footer>HRDKOREA Copyright@2016 All rights reserved. Humun Resources Developer of Service Korea</footer>
</body>
</html>