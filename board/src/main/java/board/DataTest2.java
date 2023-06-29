package board;

import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataTest2 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//문자열
		//배열
		//객체
		String str="hello";
		int[] arr = {10,20,30};
		class Obj{
		 int su1 = 100; 
		 int su2 = 200;
		 int su3=300;}
		Obj obj = new Obj();
		
		//System.out.println(str);
		//System.out.println(arr[0]);
		//System.out.println(obj.su1);
		
		//1.문자열을 배열로 변환 split
		//String[] imsi=str.split("");
		//(String s: imsi) {
		//	System.out.println(s);
		//}
		//2.배열을 문자열로 변환
		//System.out.println(Arrays.toString(arr));
		//String str1 = Arrays.toString(arr);
		//추가적인 사항으로 분리하는 방법
		//String str2=str1.substring(1,str1.length()-1);
		//for(String s : str2.split(",")) {
		//	System.out.println(s.trim());
		//}
		//3.json형으로 처리
		//json은 문자열이다.
		//{one:0,two:0;three:0;four:0} jsp 오브젝트임
		//String json = "{\"one\":\"0\",\"two':'\\\"0'\",\"three\":0,\"four\":0}";
		//java에서 객체를 이용하여 json을 생성
		JSONObject jobj2=new JSONObject();
		//jobj.put("one", 0);
		//jobj.put("two", 0);
		//jobj.put("three", 0);
		//jobj.put("four", 0);
		//System.out.println(jobj.toJSONString());
		//System.out.println(jobj.toString());
		
		//문자열형태의 json을 객체 형태로 변환
		//String json = "{\"one\": \"0\", \"two\": \"0\", \"three\": \"0\", \"four\": \"0\"}";

		//JSONObject strtoobj=(JSONObject)new JSONParser().parse(json);
		//System.out.println(strtoobj.toJSONString());
		//System.out.println(strtoobj.toString());
		String[] key = {"one","two","three","four"};
		int[] value= {10,20,30,40};
		for(int i=0; i<key.length;i++) {
			jobj2.put(key[i], value[i]);
		}
		System.out.println(jobj2.toString());
		}
	
		
		
	}


