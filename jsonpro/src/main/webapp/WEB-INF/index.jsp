<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
/* $.ajax({
    type: 'get', // change 'post' to 'get'
    url: '/test.txt',
    ContentType : 'appliction/json' ,//application/x-www.form-urlencoded, appliction/json
    data :{"id":"admin"},
    dataType: 'text',
    success: function(result) {
        alert(result);
        console.log(result);
    }
}); */
function callapi(method) {
	$.ajax({
	    type: method,
	    url: '/member',
	    contentType : 'appliction/json' ,//application/x-www.form-urlencoded, appliction/json
	    data :{"id":"admin"},
	    dataType: 'text',
	    success: function(result) {
	       document.querySelector('div').innerHTML=result;
	    }
	});
}

function callmembers(method) {
	$.ajax({
	    type: 'get',
	    url: method,
	    contentType : 'appliction/json' ,//application/x-www.form-urlencoded, appliction/json
	    dataType: 'text',
	    success: function(result) {
	       document.querySelector('div').innerHTML=result;
	    }
	});
}
function calladmin3() {
	$.ajax({
	    type: 'get',
	    url: '/getmembers',
	    contentType: 'application/json',
	    dataType: 'json', 
	    success: function(result) {
	    	let admin3info = "";
	       for(let i = 0; i < result.length; i++) {
	           if(result[i].id === "admin3") {  
	               admin3 = result[i].password;
	               break;
	           }
	       }
	       document.querySelector('div').innerHTML = JSON.stringify(admin3);
	    }
	});
}

function sendmember() {
	$.ajax({
		type : 'post',
		url : '/sendmember',
		contentType : 'application/json', // corrected 'contentType'
		data : JSON.stringify({"id":"admin5","password":"5555"}),
		
		dataType : 'json',
		success :function(result){
			document.querySelector('div').innerHTML=result;
		}
	});
}
/*
�������
*{ } : ��ä�� -> {"id":"admin","password":"1234"}
 	console.log(boj1);
 	��ä�� jos�� �ٸ���. json�� ���ڿ���.(Ű:��)
 	json�� object�� ��ȯ�ϱ� ���� �Լ� JSON.parse()
 	object�� json������ ���ڿ��� �ٱ��ִ� �Լ�JSON.stringify();
 */
const obj1= {"id":"admin","password":"1234"}
 console.log(boj1);
 const json= '{"id":"admin","password":"1234"}'
 consol.log(json);
 consol.log(JSON.parse(json));
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
hello?<br>
<input type="button" onclick="callapi('get')" value="get">
<input type="button" onclick="callapi('post')" value="post">
<input type="button" onclick="callapi('put')" value="put">
<input type="button" onclick="callapi('delete')" value="delete">
<input type="button" onclick="callmembers('/getmember')" value="member">
<input type="button" onclick="callmembers('/getmembers')" value="members">
<input type="button" onclick="calladmin3('/getmembers')" value="admin3">
<input type="button" onclick="sendmember()" value="send">
<div></div>
</body>
</html>


<!-- ����)getmember url�� ó���ϼ��� -->
<!-- ����Ʈ���� admin3�� password�� ����ô���� ����Ͻÿ� -->