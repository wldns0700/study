<%@page import="org.json.simple.JSONObject"%>
<%@page import="board.CurlTest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
//일반 클래스는 데이터를 전송하기위해서 직렬화 과정을 거쳐야하고
//직렬화된 데이터를 전송하기위한 데이터처리과정을 거쳐야함
/* CurlTest obj = new CurlTest();
obj.name="hong";
obj.age=30; */

JSONObject obj = new JSONObject();
obj.put("name","hong");
obj.put("age",30);
%>

<%=obj%>
