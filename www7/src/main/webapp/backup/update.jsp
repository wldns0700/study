<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//고객번호를 조회하기 전 고객번호를 알아야함. 이값은 url을 통해 전달됨
int custno=Integer.parseInt(request.getParameter("custno"));

//고객번호에 대한 데이터를 찾기
Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection
 ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
System.out.println(con);
String sql="select * from member_tbl_02 where custno=?";
PreparedStatement ps=con.prepareStatement(sql);
ps.setInt(1, custno); //전달받은 값은 입력값으로 사용
ResultSet rs=ps.executeQuery();

//int custno=0;
String custname=null;
String phone=null;
String address=null;
String joindate=null;
String grade=null;
String city=null;

if(rs.next()){
	custname=rs.getString("custname");
	phone=rs.getString("phone");
	address=rs.getString("address");
	joindate=rs.getString("joindate");
	grade=rs.getString("grade");
	city=rs.getString("city");
}
System.out.println(custname);
rs.close();
ps.close();
con.close();
%>
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
	<li><a href="createMember.jsp">회원등록</a></li>
	<li><a href="memberlist.jsp">회원목록조회/수정</a></li>
	<li><a href="sales.jsp">회원매출조회</a></li>
	<li><a href="index.jsp">홈으로</a></li>
</ul>
</nav>
<section>
<h3>홈쇼핑 회원 정보 수정</h3>
<form action="updateProc.jsp" method="post">
<table border="1">
	<tr>
		<td>회원번호(자동발생)</td>
		<td><input type="text" id="custno" name="custno" value="<%=custno%>" readonly></td>
	</tr>
	
	<tr>
		<td>회원성명</td><td>
		<input type="text" id="custname" name="custname" value="<%=custname%>"></td>
	</tr>
	
	<tr>
		<td>회원전화</td>
		<td><input type="text" id="phone" name="phone" value="<%=phone%>"></td>
	</tr>

	<tr>
		<td>회원주소</td>
		<td><input type="text" id="address" name="address"  value="<%=address%>"></td>
	</tr>
	
	<tr>
		<td>가입일자</td>
		<td><input type="text" id="joindate" name="joindate" value="<%=joindate%>"></td>
	</tr>
	
	<tr>
		<td>고급등급[A:VIP,B:일반,C:직원]</td>
		<td><input type="text" id="grade" name="grade" value="<%=grade%>"></td>
	</tr>
	
	<tr>
		<td>도시코드</td>
		<td><input type="text" id="city" name="city" value="<%=city%>"></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="button" onclick="valueCheck()" value="수정">
			<input type="button" onclick="location.href='memberlist.jsp'" value="조회">
		</td>
	</tr>
</table>
</form>
</section>
<footer>HRDKOREA Copyright@2016 All rights reserved. Humun Resources Developer of Service Korea</footer>
</body>
</html>