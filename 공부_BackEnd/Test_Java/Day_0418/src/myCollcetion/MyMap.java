package myCollcetion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		
		// 데이터 추가 put
		map.put("1", "홍길동");
		map.put("2", "임꺽정");
		
		String temp = map.put("3", "전우치");
		System.out.println(temp);
		
		temp = map.put("3", "손오공"); // 대체
		System.out.println(temp);
		// 동일한 key면 원래 있던 애가 튕겨나옴
		// 굴러들어온 돌이 박힌 돌 빼내는 느낌
		// 즉, 잘 들어갔으면 null인 것
		
		System.out.println(map); // toString()
		System.out.println("데이터의 개수: " + map.size()); // 3
		
		
	
		// 데이터의 유무 containsKey
		System.out.println(map.containsKey("4")); // false
		
		// 데이터의 유무 containsValue
		System.out.println(map.containsValue("홍길동")); // true
		
		// 데이터 추출 get
		String value = map.get("3");
		System.out.println(value); // 손오공
		System.out.println(map); // get은 참조할 뿐 값을 빼내어 없앤 것이 아님
		
		// 데이터 삭제 remove
		String removedValue = map.remove("1");
		System.out.println(removedValue); // 홍길동
		// 삭제된 데이터가 반환됨
		System.out.println(map);
		
		String removedValue2 = map.remove("1");
		System.out.println(removedValue2); // null
		
		
		// -----------------------
		map.put("1", "저팔계");
		map.put("4", "사오정");
		map.put("5", "삼장법사");
		
		// key 묶음 반환 keySets ====> Set 객체로 반환됨
//		Set<String> set = map.keySet();
//		Iterator<String> iter = set.iterator();
		Iterator<String> iter = map.keySet().iterator();
		
		// iterator 생성하여 순회할 때마다 get으로 추출
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ", " +map.get(key));
		}
		
	}

}
