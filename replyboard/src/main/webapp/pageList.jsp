<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- pagelist라는 객체의 데이터만 표현(VIEW) -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    
</head>
<body>
<main>
<div class="container mt-3">
<h2>일반게시판</h2>
 <div class="input-group mt-3 mb-3"> 
  <button name="kind" id="kind" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    검색선택
  </button>
  <div class="dropdown-menu">
  	
    <a class="dropdown-item" href="#">제목</a>
    <a class="dropdown-item" href="#">글쓴이</a>
    <a class="dropdown-item" href="#">날짜</a>
  
  </div>
<input type="text" class="form-control" id="search" name="search">
<input id="searchbtn" type="button" class="btn btn-info" value="검색">
</div>

<table class="table">
<thead><tr>
<th>글번호</th>
<th>제목</th>
<th>글쓴이</th>
<th>날짜</th>
<th>조회수</th>
</tr></thead>
<tbody>
<tr>
<td>1</td>
<td>댓글게시판 만들기 시작</td>
<td>김자바</td>
<td>2023-06-05</td>
<td>1</td>
</tr>

</tbody>
</table>

<ul class="pagination">
  <li class="page-item"><a class="page-link" href="#">이전</a></li>
  <li class="page-item"><a class="page-link" href="#">1</a></li>
  <li class="page-item"><a class="page-link" href="#">다음</a></li>
  </ul>


<button type="button" class="btn btn-success" onclick="#">글쓰기</button>
</div>
</main>
</body>
</html>