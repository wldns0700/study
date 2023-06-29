<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var websocket=new WebSocket("ws://192.168.0.10:8080/test");
/* 연결 후 처리하는 방법은 이벤트를 통해 데이터 송수신처리 */
websocket.onopen=function(message){ console.log('open');}
websocket.onclose=function(message){console.log('close');}
websocket.onerror=function(message){console.log('error');}
websocket.onmessage=function(message){
	//수신받는 내용을 div에 출력
	document.querySelector("div").innerHTML+=message.data+"<br>"
}

//sendmsg()데이터를 보내는 역할
function sendmsg(){
	websocket.send(document.getElementById("msg").value);
}
</script>
</head>
<body>
<input type="text" id="msg"><button onclick="sendmsg()">전송</button>
<div></div>
</body>
</html>