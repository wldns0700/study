�������̵�
controller-urló��
�������)webapp/index.jsp ������ ���� ��� �켱 ������ index.jsp�̹Ƿ� ��Ʈ�ѷ��� ���� �ȵ�

/pagelist ->controller -> service -> dao 
-> service -> controller -> pageList.jsp

����������Ʈ���(�̵��� �κ�:�۾���, �󼼺���)
/pagelist -> request.setAttribute("pagelist",pagelist) -> pageList.jsp

�۾��� ->/write -> writeForm.jsp (�̵��� �κ� : �۾��� ó��)
�󼼺���->/findView -> request.setAttribute("board",board) ->findOne.jsp(�̵��� �κ�:����, ����, ��۾���) 

�۾���ó��->/writeProc
����->updateForm
����->deleteProc
��۾���->replyWrite

��Ʈ���� ���� �� �ʿ��� �⺻����
//�ѱ�ó��
response.setContentType("text/html;charset=utf-8");
response.setCharacterEncoding("utf-8");
//�ܺ��� �����ϴ� url�� �ּҸ� ������ ���ڿ��� �޴��Լ�
String uri=request.getRequestURI();
//�⺻������
String page="pageList.jsp";
System.out.println(uri);
				
if(uri.equals("/pageList")) {
				
}
//Dispatcher:������,�߼�
//request:��û�ѵ����͸� �����ϴ� ����(��ü)
//�Է°��� page�� �����ڴ�.
//request��ü�� ����ȳ���� response��ü�� ��� ������ ���� �����ڴ�.
request.getRequestDispatcher("/WEB-INF/"+page)
.forward(request, response);

-------------------------------------
���ͷѷ����� reqeust.setAttribute("pagelist",pagelist)�Լ��� ����Ͽ� 
������ ���� jsp����ϱ� ���ؼ� ${pagelist.list.title}�� �̿��Ѵ�.
�̶� ${}�� ������ ���̺귯�� �ʿ����, 
������ �ݺ���, ���ǹ����� ����Ϸ��� ���̺귯���� �ʿ�
<c:forEach var="pb" items="${pagelist.list}">
</c:forEach>
jstl-1.2.jar lib�� �����ؾ��ϰ� jsp�������� �Ʒ������� �߰��ؾ��Ѵ�.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

-------------�۾�����------------------
1)��ϸ���Ʈ�� ȭ�鿡 ���
<c:forEach var="board" items="${pagelist.list}">
<tr>
<td>${board.idx}</td>
<td>${board.title}</td>
<td>${board.writename}</td>
<td>${board.writeday}</td>
<td>${board.readcount}</td>
</tr>
</c:forEach>
 
2)�������׺����Ʈ ó��
��������.������ó�� �ȵǴ� ������ �߻�
href="?currentPage=1" -> ��Ʈ�ѷ����� request.getParameter()�Լ��� �̿��Ͽ�
currentPage�� ���޾Ƽ� ó��

/pageList
���޵Ǵ� ���� ���� ��� null�� �߻��Ѵ�.
/pageList?currentPage=
���޵Ǵ� ���� null�̾ƴ� ""��

���޵Ǵ� ���� ���ڿ��̹Ƿ� ���ڷ� ó���� ��� Integer.parseInt()���ں�ȯ�ؾ���.
if(request.getParameter("currentPage")!=null) {
	String _currentPage
	=request.getParameter("currentPage");
	if(!_currentPage.equals("")) {
		currentPage=Integer.parseInt(_currentPage);
	}
}

3)�̹���ó��(����ó���� ���ҽ����� ó���ϴ� ���)
�̹��������� webapp�� ��ġ�� �� ����ó���� ����ǵ��� ó���ϴ� ���
web.xml
<servlet-mapping>
  <servlet-name>default</servlet-name>
  <url-pattern>*.css</url-pattern>
  <url-pattern>*.js</url-pattern>
  <url-pattern>*.ico</url-pattern>
</servlet-mapping>

ico����ó��
<link rel="icon" href="/resource/favicon.ico">

�����������ϴ� ���
webapp/css, js, favicon ���� ���ҽ��� ��ġ
<link href="/css/style.css" rel="stylesheet" type="text/css">
<script src="/js/script.js"></script>

�������)
<!-- �ν�Ʈ����� �� jquery ��ũ��Ʈ�� ���� ��ġ�ؾ� �����߻����� -->

- ���, ����÷�ο���Ȯ��(a tag�� download Ű����� ������ �ٿ�ε� �����ϰ���)
<!-- ����� ���� ó�� (tab : �ݺ���)-->
<c:forEach begin="1" end="${board.tab}">
<img src="/img/reply_icon.gif" style="widht:42px;height:15px">
</c:forEach>
${board.title}
<!-- ���Ͼ��ε� ���� �̹��� ó��(filename:���ǹ�) -->
<c:if test="${not empty board.filename}">
<a href="#" download><img src="/img/file.png" style="widht:42px;height:20px"></a>
</c:if>

-�˻�ó��(phonebook pagelist���� ����)

-������ó��(�Խñ��� 10�� �ҷ������� ������ ���� ���� ��� "�����Ǿ����ϴ�."��� ǥ��) 
<c:if>

-������ �󼼺���
��� : ����Ʈ�� ���콺�� �ø� �� �࿡ ���� ��Ÿ���� ����, Ŭ������ �� �󼼺��� ������ �̵�

/* ����Ʈ�� ���콺�� �ø� �� ������� ����, tr:�� ��ĭ �ٿ�� ����ȵ�*/
<style>tr:hover{ background-color:yellow; }</style>
<tr onmouseover="style.backgroundColor='yellow'" 
onmouseout="style.backgroundColor='white'"> 

���õ� tr�� �Ʒ� �±��� td�� ã��, 0��°�� td���� ���� ã�´�.
var idx=$(this).find("td").eq(0).text();

/* ���̺��� ù��° ���� background-color���� */
thead tr:first-child{background-color:lightGray;}

�̺�Ʈ ������ ���� �ʰ� ó���ϴ� ���
<tr onclick="event.cancelBubble=true">

-�۾���
�۾��� ��ư ������ �� �۾���� ������ �̵��ϱ�
�۾��� ->/write -> writeForm.jsp (�̵��� �κ� : �۾��� ó��)
<button onclick="location.href='/write'">�۾���</button>

-�۾��� ó��(writeProc)
�����Ͱ��� ��ȿ���� ��ȿ���˻��ϴ� script�ۼ�(����)
writename(writeid), title, content, file(MultipartReqeustó��)

-���Ͼ��ε�ó��









