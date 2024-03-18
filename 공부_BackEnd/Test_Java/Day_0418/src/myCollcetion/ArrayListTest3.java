/*
 * 사용자 정의 클래스
 */
package myCollcetion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Friend {
	String name;
	String phone;
	public Friend(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	// 주소값을 인식시킴
	@Override
	public int hashCode() {
		return Objects.hash(name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		return Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
}


public class ArrayListTest3 {

	public static void main(String[] args) {
		List<Friend> list = new ArrayList<>();
		
		// 사용자 정의는 무조건 new로 객체 생성을 해줘야 한다!!!
		list.add(new Friend("손오공", "010-111-1111"));
		list.add(new Friend("저팔계", "010-222-1111"));
		list.add(new Friend("사오정", "010-333-1111"));
		list.add(new Friend("임꺽정", "010-444-1111"));
		list.add(new Friend("전우치", "010-555-1111"));
		
		System.out.println("데이터의 개수 : " + list.size()); // 5
		
		// contain
		boolean bool = list.contains(new Friend("임꺽정", "010-444-1111"));
		System.out.println(bool); // false // true
		// 새로운 객체를 생성했기 때문에 false -> Friend class를 수정하기
		// hashcode와 equals 오버라이딩 하면 true 뜸!
		
		// indexOf
		int i = list.indexOf(new Friend("임꺽정", "010-444-1111"));
		System.out.println(i); // -1 : 못찾았다는 의미
		
		// ======================
		// 즉, new로 새로운 객체를 만들었다면
		// hashcode와 equals를 오버라이드 해야만 인식 가능한 것!!
		
		
		// 임꺽정만 찾고싶다면 iterator로 순회돌아서 ㄱㄱ
	}
}
