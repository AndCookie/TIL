package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendTest {
	Map<String, Friend> map = new HashMap<>();
	// static�� non-static�� �������� ���ϹǷ� main���� ���� �Ұ���!!
	Scanner keyin = new Scanner(System.in);
	
	// ������ ����� -> static�� �ƴϹǷ� keyin�� ���� ����
	FriendTest() {
		String choice;
		while (true) {
			System.out.println("�޴��� ���ÿ�.");
			System.out.println("1. �Է�     2. ��ȸ     0. ����");
			choice = keyin.next();
			
			switch(choice) {
			case "1" : {
				System.out.println("�̸� �Է� : ");
				String name = keyin.next();
				System.out.println("��ȣ �Է� : ");
				String phone = keyin.next();
				
				map.put(name, new Friend(name, phone));
				break;
			}
			case "2" :{
				System.out.println("�̸� �Է� : ");
				String name = keyin.next();
				if (map.get(name)!=null) {
					System.out.println(map.get(name));
				} else {
					System.out.println("��ġ�ϴ� ģ���� �����ϴ�.");
				}
				break; // switch-case���� ����� ���� ��
				// break�� �ڽ��� ���Ե� �ݺ��� �� �ϳ����� ��� �� �ִ�
			}
			case "0" : 
				System.out.println("** ����");
				return;
				// �ڽ��� ȣ���ߴ� ������ ��
				// ������ �޼ҵ� FriendTest()�� ���, �װ��� ȣ���� main ������ ��
				// main�� ������ �߰�ȣ�� ������ ���������Ƿ� ���α׷� ����!
			}
		}
	}

	public static void main(String[] args) {
		new FriendTest();

	}
// �⺻���� ��üȭ ��Ų���� Wrapper class
// ��� String�̴ϱ� Wrapper�� �ƴϹǷ�, toString�� �������̵� �Ͽ� �ּҰ��� �ƴ϶� �������� ���ü� �ֵ��� �ؾ���
// map.get�� ��ȯ�ϴ� ���� Friend Ÿ���̹Ƿ�, Friend���� to String�� override�ؾ� ������ ����
}
