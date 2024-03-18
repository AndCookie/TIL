/*
 * �����ڷ���
 */

package myCollcetion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
//		ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>(); // ������
		// ������ List�� ArrayList�� �ٶ󺸵��� ��
		// ArrayList���� String�� �� �� �ִ�
		// �����ڷ����� int, boolean, char ���� �� �� ����
		
		// add(��ü) : ��ü �߰�
		list.add("���̽��Ƹ޸�ī��"); // �˾Ƽ� 0������� �����Ͱ� ����
		list.add("ī���ī"); // 1����
		list.add("�������"); // 2����
		list.add("ī���"); // 3����
		
		// add(�ε���, ��ü) : ��ü ����
		list.add(2, "������");
		
		// ��� 
		System.out.println(list.toString());
		System.out.println(list);
		// toString�� �������̵� ���� �ʴ��� �ּҰ��� �ƴ� �������� ���´�!!
		
		// indexOf(������) : �ε��� ����
		System.out.println(list.indexOf("���̽��Ƹ޸�ī��")); // 0
		
		// get(�� ��ȣ) : ��ü ����
		String s = list.get(0); // ���̽��Ƹ޸�ī��
		System.out.println(s);
//		String s2 = list.get(4); // IndexOutOfBoundsException
		
		// contains(��ü) : ��ü ���� Ȯ��
		System.out.println(list.contains("������")); // true
		
		// remove(�ε���) : ��ü ����
		list.remove(1);
		System.out.println(list); // ī���ī ����
		
		// remove(��ü) : ��ü �� �� ����
		boolean result = list.remove("������");
		System.out.println(result); // true
		System.out.println(list);
		result = list.remove("������");
		System.out.println(result); // false
		System.out.println(list);
		
//		// removeAll(����Ʈ) : ��ü ����
//		list.removeAll(list);
//		System.out.println(list);
		
		// size() : ��ü�� ����
		System.out.println(list.size()); // 3	
		
		
		System.out.println("================");
		
		
		// ��ü ������ ��ȸ�ϱ� -1
		for (String temp : list) {
			System.out.println(temp);
		}
		
		// ��ü ������ ��ȸ�ϱ� -2 ======== iterator======
		// ��ȸ ���� ��ü�� Iterator<String>���� ��ȯ��
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		// StringTokenizer�� ����
		
		
		// �� ����Ʈ���� Ȯ��
		System.out.println(list.isEmpty()); // false
		list.clear(); // ����Ʈ ������ ����
		System.out.println(list.isEmpty()); // true
	}

}
