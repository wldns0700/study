<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
function send(){
	
	var title=document.getElementById('title');
	var content=document.getElementById('content');
	var price=document.getElementById('price');
	
	const data={title:title.value,content:content.value,price:price.value}
	
}
	/* $.ajax({
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
} */

</script>
<body>
<form action="/member" method="post">
<!-- <input type="text" id="idx" name="idx" placeholder="å��ȣ"> -->
<input type="text" id="title" name="title" placeholder="å����"><br>
<input type="text" id="content" name="content" placeholder="����"><br>
<input type="text" id="price" name="price" placeholder="����"><br>
<input type="button" value="�Է�" onclick="send()">
</form>
</body>
</html>