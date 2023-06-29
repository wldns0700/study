<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script></head>
<body>    
<main>
<div class="container mt-3">
<h2 id="headertitle">글 상세보기[수정/삭제/댓글달기]-조회수[${board.readcount}]</h2>
<form action="/board/update" method="post" enctype="multipart/form-data">

<lable for="idx">글번호:</lable>
<input type="text" id="idx" name="idx" class="form-control" readonly value="${board.idx}">

<lable for="writeName">작성자</lable>
<input type="text" id="writename" name="writename" class="form-control" readonly value="${board.writename}">

<lable for="title">제목</lable>
<input type="text" id="title" name="title" class="form-control" readonly value="${board.title}">

<lable for="content">내용</lable>
<input type="text" id="content" name="content" class="form-control" readonly value="${board.content}">

<lable for="file">첨부파일</lable>
<input type="file" id="filename" name="filename" class="form-control" readonly value="${board.filename}">

<input type="button" class="btn btn-primary" value="수정">
<input type="button" class="btn btn-primary" value="삭제">
<input type="button" class="btn btn-primary" value="댓글쓰기">
<input type="button" class="btn btn-primary" value="취소">
<!-- 댓글쓰기할때 parentid, tab값을 전달해야하므로 숨겨놓는다. -->
<input type="input" name="parenetid" value="${board.idx}" hidden>
<input type="input" name="tab" value="${board.tab+1}" hidden>
</form>
</div>
</main>
</body>
</html>