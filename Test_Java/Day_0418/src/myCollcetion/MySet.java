package myCollcetion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {

	public static void main(String[] args) {
		// �������̽��̹Ƿ� ��ü ���� �Ұ�
		Set<String> set = new HashSet<>();
		
		// ������ �ֱ�
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		boolean result1 = set.add("five");
		System.out.println(result1); // true

		// �ߺ� ������ ���x
		boolean result2 = set.add("five");
		System.out.println(result2); // false
		// false�� ��ȯ�Ǹ� �ߺ��̶� �����Ͱ� ���� ���ߴٴ� �ǹ�
		
		// �ϳ��� �����͸� �����ϴ� get�� ����!! ===================
		System.out.println();
		
		// ��ü ��ȸ
		Iterator<String> iter = set.iterator();
		
		// iterator �����Ͽ� ��ȸ�� ������ get���� ����
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}			
		
		System.out.println(set);
		// ���� ���� �������� ����
	}

}
