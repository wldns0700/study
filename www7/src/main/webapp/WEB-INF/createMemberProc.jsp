<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<c:when test="${result>0}">
<script>
alert('회원등록이 완료되었습니다.');
location.href="/index"
</script>
</c:when>
<c:otherwise>
alert('회원등록에 실패했습니다.');
location.href="update.jsp"
</c:otherwise>
</c:choose>





<c:if test = "${result>0}">
<script>
alert('회원등록이 완료되었습니다.');
location.href="index.jsp"
</script>
</c:if>





