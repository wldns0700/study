<%@page import="org.json.simple.JSONObject"%>
<%@page import="board.CurlTest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
//�Ϲ� Ŭ������ �����͸� �����ϱ����ؼ� ����ȭ ������ ���ľ��ϰ�
//����ȭ�� �����͸� �����ϱ����� ������ó�������� ���ľ���
/* CurlTest obj = new CurlTest();
obj.name="hong";
obj.age=30; */

JSONObject obj = new JSONObject();
obj.put("name","hong");
obj.put("age",30);
%>

<%=obj%>
