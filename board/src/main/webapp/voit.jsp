<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
ul{
	list-style: none;
}
li{
	display: inline-block;
	width: 100px;
	font-size:30px;
	
}
</style>

<script>

var websocket = new WebSocket("ws://127.0.0.1:8080/voit");
websocket.onopen = function(){console.log('open');}
websocket.onclose = function(){console.log('close');}
websocket.onerror = function(error){console.log('error');}
websocket.onmessage = function(message) {
    var arr = JSON.parse(message.data);
    document.getElementById("1").innerHTML = arr[0];
    document.getElementById("2").innerHTML = arr[1];
    document.getElementById("3").innerHTML = arr[2];
    document.getElementById("4").innerHTML = arr[3];
};

function voit(num) {
	            websocket.send(num);
	          
	}
</script>
</head>
<body>
	<div>
	<ul>
	<li id = "1">0</li>
	<li id = "2">0</li>
	<li id = "3">0</li>
	<li id = "4">0</li>
	</ul>
	</div>
	
	<div>
	<ul>
	<li><button onclick = "voit(1)">1</button></li>
	<li><button onclick = "voit(2)">2</button></li>
	<li><button onclick = "voit(3)">3</button></li>
	<li><button onclick = "voit(4)">4</button></li>
	</ul>
	</div>
		
</body>
</html>