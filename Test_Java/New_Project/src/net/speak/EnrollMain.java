package net.speak;

import java.util.Scanner;

public class EnrollMain {

	public static void main(String[] args) {
		Speakable[] arr = new Speakable[2];  // 최대 2명까지 입력받을 수 있음
		Scanner keyin = new Scanner(System.in);
		String choice, name;

		for (int i =0; i<arr.length; ++i) {
			System.out.println("     1) Reader 등록");
			System.out.println("     2) Worker 등록");

			choice = keyin.next();
			
			System.out.println("이름을 입력하세요");
			name = keyin.next();

			switch(choice) {
			case "1" :
				arr[i] = new Reader(name);
				break;
			case "2" : 
				arr[i] = new Worker(name);
				break;
			}
		}


		System.out.println("두 명 Speaker의 등록이 완료되었습니다.");
		System.out.println("이제 Speaker들의 speak 실행 결과입니다.");

		for (int i =0; i<arr.length; ++i)
			System.out.println(arr[i].speak());
		
		keyin.close();
	}
}
