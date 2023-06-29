페이지이동
controller-url처리
참고사항)webapp/index.jsp 파일이 있을 경우 우선 순위가 index.jsp이므로 컨트롤러가 실행 안됨

/pagelist ->controller -> service -> dao 
-> service -> controller -> pageList.jsp

페이지리스트출력(이동할 부분:글쓰기, 상세보기)
/pagelist -> request.setAttribute("pagelist",pagelist) -> pageList.jsp

글쓰기 ->/write -> writeForm.jsp (이동할 부분 : 글쓰기 처리)
상세보기->/findView -> request.setAttribute("board",board) ->findOne.jsp(이동할 부분:수정, 삭제, 댓글쓰기) 

글쓰기처리->/writeProc
수정->updateForm
삭제->deleteProc
댓글쓰기->replyWrite

컨트롤을 만들 때 필요한 기본사항
//한글처리
response.setContentType("text/html;charset=utf-8");
response.setCharacterEncoding("utf-8");
//외부의 접속하는 url중 주소를 제외한 문자열을 받는함수
String uri=request.getRequestURI();
//기본페이지
String page="pageList.jsp";
System.out.println(uri);
				
if(uri.equals("/pageList")) {
				
}
//Dispatcher:보내기,발송
//request:요청한데이터를 저장하는 공간(객체)
//입력값인 page로 보내겠다.
//request객체에 저장된내용과 response객체에 담긴 내용을 같이 보내겠다.
request.getRequestDispatcher("/WEB-INF/"+page)
.forward(request, response);

-------------------------------------
컨터롤러에서 reqeust.setAttribute("pagelist",pagelist)함수를 사용하여 
저장한 값을 jsp사용하기 위해서 ${pagelist.list.title}를 이용한다.
이때 ${}는 별도의 라이브러리 필요없음, 
하지만 반복문, 조건문등을 사용하려면 라이브러리가 필요
<c:forEach var="pb" items="${pagelist.list}">
</c:forEach>
jstl-1.2.jar lib에 복사해야하고 jsp페이지에 아래내용을 추가해야한다.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

-------------작업사항------------------
1)목록리스트를 화면에 출력
<c:forEach var="board" items="${pagelist.list}">
<tr>
<td>${board.idx}</td>
<td>${board.title}</td>
<td>${board.writename}</td>
<td>${board.writeday}</td>
<td>${board.readcount}</td>
</tr>
</c:forEach>
 
2)페이지네비게이트 처리
문제사항.페이지처리 안되는 문제가 발생
href="?currentPage=1" -> 컨트롤러에서 request.getParameter()함수를 이용하여
currentPage를 전달아서 처리

/pageList
전달되는 값이 없을 경우 null이 발생한다.
/pageList?currentPage=
전달되는 값이 null이아닌 ""빈값

전달되는 값은 문자열이므로 숫자로 처리할 경우 Integer.parseInt()숫자변환해야함.
if(request.getParameter("currentPage")!=null) {
	String _currentPage
	=request.getParameter("currentPage");
	if(!_currentPage.equals("")) {
		currentPage=Integer.parseInt(_currentPage);
	}
}

3)이미지처리(필터처리시 리소스파일 처리하는 방법)
이미지파일을 webapp에 위치할 때 필터처리시 통과되도록 처리하는 방법
web.xml
<servlet-mapping>
  <servlet-name>default</servlet-name>
  <url-pattern>*.css</url-pattern>
  <url-pattern>*.js</url-pattern>
  <url-pattern>*.ico</url-pattern>
</servlet-mapping>

ico파일처리
<link rel="icon" href="/resource/favicon.ico">

페이지포함하는 방법
webapp/css, js, favicon 관련 리소스를 위치
<link href="/css/style.css" rel="stylesheet" type="text/css">
<script src="/js/script.js"></script>

참고사항)
<!-- 부스트랩사용 전 jquery 스크립트가 먼저 위치해야 오류발생안함 -->

- 댓글, 파일첨부여부확인(a tag에 download 키워드는 파일을 다운로드 가능하게함)
<!-- 댓글의 깊이 처리 (tab : 반복문)-->
<c:forEach begin="1" end="${board.tab}">
<img src="/img/reply_icon.gif" style="widht:42px;height:15px">
</c:forEach>
${board.title}
<!-- 파일업로드 여부 이미지 처리(filename:조건문) -->
<c:if test="${not empty board.filename}">
<a href="#" download><img src="/img/file.png" style="widht:42px;height:20px"></a>
</c:if>

-검색처리(phonebook pagelist참고 복사)

-삭제글처리(게시글은 10개 불러오지만 삭제된 글이 있을 경우 "삭제되었습니다."라고 표시) 
<c:if>

-페이지 상세보기
기능 : 리스트에 마우스를 올릴 때 행에 대해 스타일을 변경, 클릭했을 때 상세보기 페이지 이동

/* 리스트에 마우스를 올릴 때 노란색을 변경, tr:후 한칸 뛰우면 적요안됨*/
<style>tr:hover{ background-color:yellow; }</style>
<tr onmouseover="style.backgroundColor='yellow'" 
onmouseout="style.backgroundColor='white'"> 

선택된 tr중 아래 태그의 td를 찾고, 0번째인 td안의 값을 찾는다.
var idx=$(this).find("td").eq(0).text();

/* 테이블의 첫번째 열의 background-color설정 */
thead tr:first-child{background-color:lightGray;}

이벤트 실행이 되지 않게 처리하는 방법
<tr onclick="event.cancelBubble=true">

-글쓰기
글쓰기 버튼 눌렀을 때 글쓰기로 페이지 이동하기
글쓰기 ->/write -> writeForm.jsp (이동할 부분 : 글쓰기 처리)
<button onclick="location.href='/write'">글쓰기</button>

-글쓰기 처리(writeProc)
데이터값이 유효한지 유효성검사하는 script작성(제외)
writename(writeid), title, content, file(MultipartReqeust처리)

-파일업로드처리









