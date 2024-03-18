package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendTest {
	Map<String, Friend> map = new HashMap<>();
	// static은 non-static에 접근하지 못하므로 main에서 접근 불가능!!
	Scanner keyin = new Scanner(System.in);
	
	// 생성자 만들기 -> static이 아니므로 keyin에 접근 가능
	FriendTest() {
		String choice;
		while (true) {
			System.out.println("메뉴를 고르시오.");
			System.out.println("1. 입력     2. 조회     0. 종료");
			choice = keyin.next();
			
			switch(choice) {
			case "1" : {
				System.out.println("이름 입력 : ");
				String name = keyin.next();
				System.out.println("번호 입력 : ");
				String phone = keyin.next();
				
				map.put(name, new Friend(name, phone));
				break;
			}
			case "2" :{
				System.out.println("이름 입력 : ");
				String name = keyin.next();
				if (map.get(name)!=null) {
					System.out.println(map.get(name));
				} else {
					System.out.println("일치하는 친구가 없습니다.");
				}
				break; // switch-case문을 벗어나기 위한 것
				// break는 자신이 포함된 반복문 단 하나만을 벗어날 수 있다
			}
			case "0" : 
				System.out.println("** 종료");
				return;
				// 자신을 호출했던 쪽으로 감
				// 생성자 메소드 FriendTest()를 벗어나, 그것을 호출한 main 쪽으로 감
				// main에 갔더니 중괄호를 만나서 닫혀버리므로 프로그램 종료!
			}
		}
	}

	public static void main(String[] args) {
		new FriendTest();

	}
// 기본형을 객체화 시킨것이 Wrapper class
// 얘는 String이니까 Wrapper가 아니므로, toString을 오버라이드 하여 주소값이 아니라 실제값이 나올수 있도록 해야함
// map.get이 반환하는 것은 Friend 타입이므로, Friend에서 to String을 override해야 실제값 나옴
}
