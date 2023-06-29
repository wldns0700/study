<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
/* ������ �����ϴ� ��� - �ʿ���� : �ּ� */
 var websocket = new WebSocket("ws://127.0.0.1:8080/wsocket");
 /*���� �� ó���ϴ� ����� �̺�Ʈ�� ���� ������ �ۼ��� ó�� */
 websocket.onopen = function(){console.log('open');}
 websocket.onclose = function(){console.log('close');}
 websocket.onerror = function(error){console.log('error');}
 websocket.onmessage = function(message){ 
	 var jsontoobj=JSON.parse(message.data).id;
	 var jsontoobj2=JSON.parse(message.data).message;
	 var html = document.getElementById("test").innerHTML;
	 console.log(message); //json ��ü ����
	 document.getElementById("test").innerHTML += 
		 "<br>"+jsontoobj+':'+jsontoobj2; //json ��ü�� data���� ���
		
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
	 
	

	 //�������� �������� �޽��� ������
	
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

	

	 //�������� �������� �޽��� ������
	

 /*���� �޼��� ������ �ϱ� ���ؼ��� input������ text�� �ʿ��� */
</script>
</head>
<body>
<input type="text" id="id" onkeypress = "keylogin(event)">
<button onclick = "login()">�α���</button>
<button onclick = "logout()">�α׾ƿ�</button><br>
<input type="text" disabled="disabled" id ="msg" onkeypress = "sendmessage3(event)">
<button onclick = "sendmessage2()">�����޼��� ����</button><br>
<input type="text" disabled="disabled" id ="whisper">
<button onclick = "whisper()">�ӼӸ� ����</button><br>
<div id = "test">123</div>

</body>
</html>