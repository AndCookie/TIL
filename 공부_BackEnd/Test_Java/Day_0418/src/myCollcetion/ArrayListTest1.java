/*
 * 참조자료형
 */

package myCollcetion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
//		ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>(); // 다형성
		// 상위인 List가 ArrayList를 바라보도록 함
		// ArrayList에는 String만 들어갈 수 있다
		// 기초자료형인 int, boolean, char 등은 들어갈 수 없다
		
		// add(객체) : 객체 추가
		list.add("아이스아메리카노"); // 알아서 0번방부터 데이터가 쌓임
		list.add("카페모카"); // 1번방
		list.add("헤이즐넛"); // 2번방
		list.add("카페라떼"); // 3번방
		
		// add(인덱스, 객체) : 객체 삽입
		list.add(2, "녹차라떼");
		
		// 출력 
		System.out.println(list.toString());
		System.out.println(list);
		// toString을 오버라이드 하지 않더라도 주소값이 아닌 실제값이 나온다!!
		
		// indexOf(데이터) : 인덱스 추출
		System.out.println(list.indexOf("아이스아메리카노")); // 0
		
		// get(방 번호) : 객체 추출
		String s = list.get(0); // 아이스아메리카노
		System.out.println(s);
//		String s2 = list.get(4); // IndexOutOfBoundsException
		
		// contains(객체) : 객체 유무 확인
		System.out.println(list.contains("녹차라떼")); // true
		
		// remove(인덱스) : 객체 삭제
		list.remove(1);
		System.out.println(list); // 카페모카 삭제
		
		// remove(객체) : 객체 한 개 삭제
		boolean result = list.remove("녹차라떼");
		System.out.println(result); // true
		System.out.println(list);
		result = list.remove("녹차라떼");
		System.out.println(result); // false
		System.out.println(list);
		
//		// removeAll(리스트) : 전체 삭제
//		list.removeAll(list);
//		System.out.println(list);
		
		// size() : 객체의 개수
		System.out.println(list.size()); // 3	
		
		
		System.out.println("================");
		
		
		// 전체 데이터 순회하기 -1
		for (String temp : list) {
			System.out.println(temp);
		}
		
		// 전체 데이터 순회하기 -2 ======== iterator======
		// 순회 전용 객체인 Iterator<String>으로 반환됨
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		// StringTokenizer와 유사
		
		
		// 빈 리스트인지 확인
		System.out.println(list.isEmpty()); // false
		list.clear(); // 리스트 데이터 삭제
		System.out.println(list.isEmpty()); // true
	}

}
