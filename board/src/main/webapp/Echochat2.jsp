<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
var websocket=new WebSocket("ws://127.0.0.1:8080/ecochat2");
websocket.onopen=function(message){ console.log('open');}
websocket.onclose=function(message){console.log('close');}
websocket.onerror=function(message){console.log('error');}
websocket.onmessage=function(message){
document.querySelector("div").innerHTML+=message.data+"<br>"
}
</script>
</head>
<body>
<div>
</div>
<input type="text" id="msg"><button onclick="websocket.send(document.getElementById('msg').value)">전송</button>
</body>
</html>