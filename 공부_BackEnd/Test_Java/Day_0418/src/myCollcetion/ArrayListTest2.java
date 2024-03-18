/*
 * �����ڷ���
 * Wrapper Ŭ������ list�� �ֱ�
 */

package myCollcetion;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {

	public static void main(String[] args) {
		// Integer :�����ڷ����� ��üȭ ��Ų ��
		// �����ڷ����� int�� �������� Integer�� �� �� �ִ�
		List<Integer> list = new ArrayList<>();
		// �տ� �̸� Ÿ���� �����Ǿ������� �ڿ� ���� �������� �ʾƵ� ��
		// List<Integer> list = new ArrayList<Integer>();
		
		
		// add�� 1(�����ڷ��� int)�� �˾Ƽ� ��ü�� �����
		list.add(new Integer(1));
//		list.add(1); // auto-boxing : �ڵ� ��üȭ
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		

		// get�� (�����ڷ��� Integer)�� �˾Ƽ� int�� ����
		Integer i1 = list.get(2); // auto-unboxing : �ڵ� ��ü Ǯ��
		int i2 = list.get(2);
		int data = list.get(2) + list.get(3);
		System.out.println(data);
	}

}
