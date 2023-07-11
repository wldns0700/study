<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>

function update() {
    // Get the form
    var title = document.getElementById('titlehidden');
    var content = document.getElementById('contenthidden');
    var price = document.getElementById('pricehidden');
    var ok = document.getElementById('ok');
	alert(title.type);
    title.type = "text"
    content.type = "text"
    price.type = "text"
    ok.type = "submit"
    
}
</script>





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
<form action="/findOne">
<input type="hidden" name="idx" value="${book.idx}" />
<input type = "submit" value = "책 정보 보기">
</form>
<hr>
</c:forEach>

</div>

<div id="findone">
<h1>책상세보기</h1>
<%-- <c:if test="${not empty find}"> --%>

책 번호<label>${find.idx}</label><br>
책 제목<label>${find.title}</label><br>
책 내용<label>${find.content}</label><br>
책 가격<label>${find.price}</label><br>
<input type = "button" value = "책 정보 수정" onclick="update()">
<form action="del">
<input type ="hidden" value= "${find.idx}" id = "name" name = "idx" readonly="readonly">
<input type = "submit" value = "책 정보 삭제">
</form>
<form action="/update">
<input type ="hidden" value= "${find.idx}" id = "name" name = "idx" readonly="readonly">
<input type ="hidden" value="책 제목" id="titlehidden" name="title"><br>
<input type ="hidden" value="책 내용" id="contenthidden" name="content"><br>
<input type ="hidden" value="책 가격" id="pricehidden" name="price"><br>
<input type ="hidden" value="확인" id="ok">
</form>
<hr>
<%-- </c:if> --%>
</div>
</div>
</body>
</html>