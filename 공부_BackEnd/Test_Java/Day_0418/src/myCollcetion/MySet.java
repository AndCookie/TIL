package myCollcetion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {

	public static void main(String[] args) {
		// 인터페이스이므로 객체 생성 불가
		Set<String> set = new HashSet<>();
		
		// 데이터 넣기
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		boolean result1 = set.add("five");
		System.out.println(result1); // true

		// 중복 데이터 허용x
		boolean result2 = set.add("five");
		System.out.println(result2); // false
		// false가 반환되면 중복이라 데이터가 들어가지 못했다는 의미
		
		// 하나의 데이터를 추출하는 get이 없음!! ===================
		System.out.println();
		
		// 전체 순회
		Iterator<String> iter = set.iterator();
		
		// iterator 생성하여 순회할 때마다 get으로 추출
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}			
		
		System.out.println(set);
		// 순서 없이 무작위로 나옴
	}

}
