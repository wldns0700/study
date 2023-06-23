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
	text-decoration-color:white;	
}
a:visited {
	color:white;
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
<h3>쇼핑몰회원관리프로그램</h3>
<p>
<pre>
쇼핑몰 회원정보 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.
프로그램 작성 순서
1.회원정보 테이블을 생성한다.
2.매출정보 테이블을 생성한다.
3.회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.
4.회원정보 입력 화면프로그램을 작성한다.
5.회원정보 조회 프로그램을 작성한다.
6.회원매출정보 조회 프록그램을 작성한다.
</pre>
</p>
</section>
<footer>HRDKOREA Copyright@2016 All rights reserved. Humun Resources Developer of Service Korea</footer>
</body>
</html>