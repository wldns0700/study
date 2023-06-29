<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- pagelist라는 객체의 데이터만 표현(VIEW) -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 
    <script>
	function selectkind(kind) {
		//alert(kind);
		document.querySelector("#kind").innerHTML = kind;
	}

	function search() {
		kind = document.querySelector("#kind").innerHTML;
		//alert(kind);
		svalue = document.querySelector("#search").value;
		//alert(svalue);
		location.href = "/serlist?kind=" + kind + "&search="
				+ svalue
	}
</script>
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
  	
    <a class="dropdown-item" onclick="selectkind('제목')">제목</a>
    <a class="dropdown-item" onclick="selectkind('글쓴이')">글쓴이</a>
    <a class="dropdown-item" onclick="selectkind('날짜')">날짜</a>
  
  </div>
<input type="text" class="form-control" id="search" name="search">
<input onclick = "search()" id="searchbtn" type="button" class="btn btn-info" value="검색">
</div>

<table class="table">
<thead><tr>

<th>글번호</th>
<th>제목</th>
<th>글쓴이</th>
<th>날짜</th>
<th>조회수</th>
</tr></thead>
<c:forEach var="pb" items="${pagelist.list}">
<tbody>
<c:choose> 
<c:when test="${pb.isdel==0}">
<td>삭제되었습니다.</td>
</c:when>
<c:otherwise>
<tr onclick="location.href='findOne?idx=${pb.idx}'" onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='while';">
<td>${pb.idx}</td>
<!-- 댓글의 깊이 처리 -->
<td>
<c:forEach begin="1" end="${pb.tab}">
<img src="/img/reply_icon.gif" style="width:42px;heighy:15px">
</c:forEach>
${pb.title}
<!-- 파일 업로드 여부 이미지 처리 -->

<a href = "#" download></a><img src="/img/file.png" style="width:12px;heighy:15px">
</td>
<td>${pb.writename}</td>
<td>${pb.writedat}</td>
<td>${pb.readcount}</td>
</tr>
</c:otherwise>
</c:choose>
</tbody>

</c:forEach>
</table>

<ul class="pagination">
				<c:if test="${pagelist.startPage>5}">
				<li class="page-item"><a class="page-link"
					href="?currentPage=${pagelist.startPage-5}">Previous</a></li>
				</c:if>

			<!-- 페이지 번호를 생성하는 반복문
				시작 페이지부터 끝 페이지까지의 범위에서 각 페이지 번호를 생성  -->
				<c:forEach var="i" begin="${pagelist.startPage}" 
				end="${pagelist.endPage}" step="1">
				<c:choose>
				<c:when test="${pagelist.currentPage==i}">
				<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?currentPage=${i}">${i}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>

			<!-- 다음 페이지로 이동하는 링크를 생성 -->
				
				<c:if test="${pagelist.totalCount>0 && pagelist.endPage<pagelist.totalPage}">
    				<li class="page-item"><a class="page-link" href="?currentPage=${pagelist.endPage+1}">Next</a></li>
    			</c:if>
				


			</ul>


<button type="button" class="btn btn-success" onclick="location.href='writeForm'">글쓰기</button>
</div>
</main>
</body>
</html>