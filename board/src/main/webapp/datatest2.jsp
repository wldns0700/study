<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
//문자열
//배열
//객체
var str="hello"
var arr=[10,20,30]
var obj={su1:100, su2:200, su3:300}

//접근방법

document.write(str+"<br>");
document.write(arr[0]+"<br>");
document.write(obj.su1+"<br>");
document.write(obj["su1"]+"<br>");

//네트워크상에서는 문자열(byte코드)데이터 전송이 됨

//문자열 -> 문자열로 전송이 되므로 상관없음
//배열 -> 배열을 문자열로 변환
//객체 -> 객체를 문자열로 변환

//데이터를 수신하는 쪽
//문자열 -> 배열
//문자열 -> 객체

//1.문자열을 배열로 변환
Str="hello";
//split
var imsi=str.split("");
document.write("기본적인 for문을 활용<br>");
for(i=0;i<imsi.length;i++){
	document.write(imsi[i]);
}
document.write("배열에 인덱스를 반환<br>");
for(i in imsi){
	document.write(i);
}

document.write("배열에 값을 반환 of <br>");
for(i of imsi){
	document.write(i);
}

document.write("각각의 배열을 함수로 처리 <br>");
imsi.forEach(function(item) {
	document.write(item);
	
})
document.write("forEach의 다른 형태 람다식 <br>");
imsi.forEach(item => document.write(item));

document.write("index와 value를 같이 반환 <br>");
imsi.forEach(function(i,item) {
	document.write(i+":"+item+",")});

//Array.from
document.write("Array객체를 활용 <br>");
str="java"
arr=Array.from(str);
document.write(arr.toString());
document.write("<br>");

//2.배열을 문자열로 변환(join,Json.stringify(), toString)

arr=["hong","killdong","30"]
document.write(arr);
document.write("<br>");
str = arr.join(":");
//개별값에 : 가 붙은 문자열이 생성
document.write(str);
document.write("<br>");
document.write(JSON.stringify(arr));
document.write("<br>");
//배열의 생김새 그대로 문자열을 만들어줌
document.write(arr.toString());
document.write("<br>");
//배열의 값에 ,를 추가한 문자열


//3.json 형으로 처리
//선수사항 : 객체와 json은 홍동하지 말 것
obj ={name:"hongkilldong",age:30}//object는 앞뒤에 문자열을 뜻하는 '' , "" ,이 없다
//json은 문자열 형태로 나타낸 객체
json='{"name":"hongkilldong","age":"30"}'	 //문자열
document.write(obj.name+","+obj['age']); 주의사항 ""  -> ''
document.write("<br>");

//문자열인 jsond을 obj로 변환해야 접근가능
jsontoobj=JSON.parse(json);
document.write(jsontoobj.name+","+jsontoobj['age']);
document.write("<br>");

//객체를 소켓상으로 바로 전송 못하므로 json 문자열로 변환해야함(JSON.stringify())
//객체를 json으로 변환(문자열로 변환)
obj={name:"honkilldong",age:30}
objtojson=JSON.stringify(obj);
document.write(objtojson);
document.write("<br>");
</script>

