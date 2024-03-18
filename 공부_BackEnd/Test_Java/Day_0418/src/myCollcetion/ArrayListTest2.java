/*
 * 기초자료형
 * Wrapper 클래스를 list에 넣기
 */

package myCollcetion;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {

	public static void main(String[] args) {
		// Integer :기초자료형을 객체화 시킨 것
		// 기초자료형인 int는 못들어가지만 Integer는 들어갈 수 있다
		List<Integer> list = new ArrayList<>();
		// 앞에 미리 타입이 지정되어있으면 뒤에 따로 지정하지 않아도 됨
		// List<Integer> list = new ArrayList<Integer>();
		
		
		// add는 1(기초자료형 int)을 알아서 객체로 만든다
		list.add(new Integer(1));
//		list.add(1); // auto-boxing : 자동 객체화
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		

		// get은 (참조자료형 Integer)을 알아서 int로 만듦
		Integer i1 = list.get(2); // auto-unboxing : 자동 객체 풀림
		int i2 = list.get(2);
		int data = list.get(2) + list.get(3);
		System.out.println(data);
	}

}
