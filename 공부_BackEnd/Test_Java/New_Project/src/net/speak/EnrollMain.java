package net.speak;

import java.util.Scanner;

public class EnrollMain {

	public static void main(String[] args) {
		Speakable[] arr = new Speakable[2];  // �ִ� 2����� �Է¹��� �� ����
		Scanner keyin = new Scanner(System.in);
		String choice, name;

		for (int i =0; i<arr.length; ++i) {
			System.out.println("     1) Reader ���");
			System.out.println("     2) Worker ���");

			choice = keyin.next();
			
			System.out.println("�̸��� �Է��ϼ���");
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


		System.out.println("�� �� Speaker�� ����� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���� Speaker���� speak ���� ����Դϴ�.");

		for (int i =0; i<arr.length; ++i)
			System.out.println(arr[i].speak());
		
		keyin.close();
	}
}
