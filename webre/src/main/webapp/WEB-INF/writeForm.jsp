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
<h2>글쓰기</h2>
<form action="write" method="post">

<lable for="idx" hidden>글번호:</lable>
<input type="text" id="idx" name="idx" class="form-control" hidden>

<lable for="writeName">작성자</lable>
<input type="text" id="writeName" name="writeName" class="form-control" readonly value="${id}">

<lable for="title">제목</lable>
<input type="text" id="title" name="title" class="form-control">

<lable for="content">내용</lable>
<input type="text" id="content" name="content" class="form-control">

<lable for="file">첨부파일</lable>
<input type="file" id="file" name="file" class="form-control">

<button type="submit" class="btn btn-primary">글쓰기</button>
<button type="button" class="btn btn-primary">취소</button>
</form>
</div>
</main>
</body>
</html>