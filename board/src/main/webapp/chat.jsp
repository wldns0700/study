<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
/* 웹소켓 생성하는 방법 - 필요사항 : 주소 */
 var websocket = new WebSocket("ws://127.0.0.1:8080/wsocket");
 /*연결 후 처리하는 방법은 이벤트를 통해 데이터 송수신 처리 */
 websocket.onopen = function(){console.log('open');}
 websocket.onclose = function(){console.log('close');}
 websocket.onerror = function(error){console.log('error');}
 websocket.onmessage = function(message){ 
	 var jsontoobj=JSON.parse(message.data).id;
	 var jsontoobj2=JSON.parse(message.data).message;
	 var html = document.getElementById("test").innerHTML;
	 console.log(message); //json 객체 전송
	 document.getElementById("test").innerHTML += 
		 "<br>"+jsontoobj+':'+jsontoobj2; //json 객체중 data값을 출력
		
	 if(jsontoobj2=="cls"){
		 document.getElementById("test").innerHTML = "";
	 }
	 
  }
	 

 
 function sendmessage() {
	 websocket.send('hello');
	 
}
 
 function sendmessage2() {
	 
	 var id = document.getElementById("id").value;
	 var message = document.getElementById("msg").value;
	 var data = {
			   "id": id,
			   "message": message
			 };
	   var jsonData = JSON.stringify(data);
		websocket.send(jsonData);
	 
	 
	// websocket.send(document.getElementById("id").value+" "
			 //+document.getElementById("msg").value);
	 document.getElementById("msg").value="";
	 document.getElementById("msg").focus();
	 
	

	 //서버에서 가변으로 메시지 보내기
	
}
 function sendmessage3(e) {
	   var id = document.getElementById("id").value;
	   var message = document.getElementById("msg").value;
	   var data = {
			   "id": id,
			   "message": message
			 };
	   var jsonData = JSON.stringify(data);
	 if(e.keyCode == 13){
		 websocket.send(jsonData);
		 //(document.getElementById("id").value+" "
				 //+document.getElementById("msg").value);
		 document.getElementById("msg").value="";
		 document.getElementById("msg").focus();
		 
     }
  }
 function login() {
	if(document.getElementById("id").value=="troll"){
		document.getElementById("msg").disabled=false;
	}
 }
 function keylogin(e){
	 if(e.keyCode == 13){
		if(document.getElementById("id").value=="troll"){
			document.getElementById("msg").disabled=false;
		}
	}
	
	
}
 function logout(){
	 document.getElementById("id").value=" ";
	 document.getElementById("msg").disabled=true;
}
 
 function whisper() {
	 var id = document.getElementById("id").value;
	   var message = document.getElementById("msg").value;
	   var whisper =  document.getElementById("whisper").value;
	   var data = {
			   "id": id,
			   "message": message,
			   "whisper" : whisper
			 };
	   var jsonData = JSON.stringify(data);
		 websocket.send(jsonData);
		 //(document.getElementById("id").value+" "
				 //+document.getElementById("msg").value);
		 document.getElementById("msg").value="";
		 document.getElementById("msg").focus();
		 
   }

	

	 //서버에서 가변으로 메시지 보내기
	

 /*가변 메세지 전송을 하기 위해서는 input상자의 text가 필요함 */
</script>
</head>
<body>
<input type="text" id="id" onkeypress = "keylogin(event)">
<button onclick = "login()">로그인</button>
<button onclick = "logout()">로그아웃</button><br>
<input type="text" disabled="disabled" id ="msg" onkeypress = "sendmessage3(event)">
<button onclick = "sendmessage2()">가변메세지 전송</button><br>
<input type="text" disabled="disabled" id ="whisper">
<button onclick = "whisper()">귓속말 전송</button><br>
<div id = "test">123</div>

</body>
</html>