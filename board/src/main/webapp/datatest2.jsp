<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
//���ڿ�
//�迭
//��ü
var str="hello"
var arr=[10,20,30]
var obj={su1:100, su2:200, su3:300}

//���ٹ��

document.write(str+"<br>");
document.write(arr[0]+"<br>");
document.write(obj.su1+"<br>");
document.write(obj["su1"]+"<br>");

//��Ʈ��ũ�󿡼��� ���ڿ�(byte�ڵ�)������ ������ ��

//���ڿ� -> ���ڿ��� ������ �ǹǷ� �������
//�迭 -> �迭�� ���ڿ��� ��ȯ
//��ü -> ��ü�� ���ڿ��� ��ȯ

//�����͸� �����ϴ� ��
//���ڿ� -> �迭
//���ڿ� -> ��ü

//1.���ڿ��� �迭�� ��ȯ
Str="hello";
//split
var imsi=str.split("");
document.write("�⺻���� for���� Ȱ��<br>");
for(i=0;i<imsi.length;i++){
	document.write(imsi[i]);
}
document.write("�迭�� �ε����� ��ȯ<br>");
for(i in imsi){
	document.write(i);
}

document.write("�迭�� ���� ��ȯ of <br>");
for(i of imsi){
	document.write(i);
}

document.write("������ �迭�� �Լ��� ó�� <br>");
imsi.forEach(function(item) {
	document.write(item);
	
})
document.write("forEach�� �ٸ� ���� ���ٽ� <br>");
imsi.forEach(item => document.write(item));

document.write("index�� value�� ���� ��ȯ <br>");
imsi.forEach(function(i,item) {
	document.write(i+":"+item+",")});

//Array.from
document.write("Array��ü�� Ȱ�� <br>");
str="java"
arr=Array.from(str);
document.write(arr.toString());
document.write("<br>");

//2.�迭�� ���ڿ��� ��ȯ(join,Json.stringify(), toString)

arr=["hong","killdong","30"]
document.write(arr);
document.write("<br>");
str = arr.join(":");
//�������� : �� ���� ���ڿ��� ����
document.write(str);
document.write("<br>");
document.write(JSON.stringify(arr));
document.write("<br>");
//�迭�� ����� �״�� ���ڿ��� �������
document.write(arr.toString());
document.write("<br>");
//�迭�� ���� ,�� �߰��� ���ڿ�


//3.json ������ ó��
//�������� : ��ü�� json�� ȫ������ �� ��
obj ={name:"hongkilldong",age:30}//object�� �յڿ� ���ڿ��� ���ϴ� '' , "" ,�� ����
//json�� ���ڿ� ���·� ��Ÿ�� ��ü
json='{"name":"hongkilldong","age":"30"}'	 //���ڿ�
document.write(obj.name+","+obj['age']); ���ǻ��� ""  -> ''
document.write("<br>");

//���ڿ��� jsond�� obj�� ��ȯ�ؾ� ���ٰ���
jsontoobj=JSON.parse(json);
document.write(jsontoobj.name+","+jsontoobj['age']);
document.write("<br>");

//��ü�� ���ϻ����� �ٷ� ���� ���ϹǷ� json ���ڿ��� ��ȯ�ؾ���(JSON.stringify())
//��ü�� json���� ��ȯ(���ڿ��� ��ȯ)
obj={name:"honkilldong",age:30}
objtojson=JSON.stringify(obj);
document.write(objtojson);
document.write("<br>");
</script>

