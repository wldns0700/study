<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--  <form action ="loginProc method="post">  ������-->
 <form th:action ="@{/Login}" method="post"> <!--  �Ź���(�ڱ��ڽ�) --> 
<input type="email" name = email id = email placeholder="���̵�"><p>
<input type="password" name = "password" id = "password" placeholder="���">
<input type="submit" value="�α���">
<p>
</form>

</body>
</html>