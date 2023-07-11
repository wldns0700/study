<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#insert{
width:100%; height:200px; border:5px solid black;
}
#list{
width:30%; height:500px; border:5px solid red; display:inline-block; float:left;
overflow:scroll;
}
#findone{
width:67%; height:500px; border:5px solid green; display:inline-block;
}
</style>
</head>
<body>
<div id="insert">
<h1>책입력</h1>
	<form action="/insert" method="post">
	<input type="text" name="title" id="title" placeholder="책제목입력"><br>
	<input type="text" name="content" id="content"  placeholder="책내용입력"><br>
	<input type="text" name="price" id="price"  placeholder="책가격입력"><br>
	<input type="submit" value="책정보입력">
	</form>
</div>
<div id="main">
<div id="list">
<h1>책정보리스트</h1>
<c:forEach var="book" items="${list}">
${book.idx}&nbsp;&nbsp;${book.title}&nbsp;&nbsp;${book.content}&nbsp;&nbsp;${book.price}<br>
<hr>
</c:forEach>
</div>
<div id="findone"></div>
</div>
</body>
</html>