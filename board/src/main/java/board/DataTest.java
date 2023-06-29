package board;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataTest {

	public static void main(String[] args) {
		//배열 크리를 늘릴수도 줄일수도 없음
		int[] intarr1= {10,20,30,40,50};
		int intarr2[] = new int[100];
		intarr2[0]=100;
		intarr2[1]=200;
		intarr2[3]=400;
		//문제점은 크기를 관리해야함.
		//이를 해결하기 위해 set,list,map 자료구조가 있음
		Set<String> set =new HashSet<String>(); //인터페이스
		// HashSet<String> set = new HashSet<>(); 객채
		set.add("apple"); 
		set.add("mango"); 
		set.add("tholl"); 
		set.add("banana"); 
		System.out.println(set.toString());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		for(String s: set) {
			System.out.println(s);
		}
		set.remove("mango");
		System.out.println(set.toString());
		
		System.out.println(set.contains("banana"));
	}

}
