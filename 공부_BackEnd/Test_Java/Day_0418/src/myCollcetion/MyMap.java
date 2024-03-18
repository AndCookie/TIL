package myCollcetion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		
		// ������ �߰� put
		map.put("1", "ȫ�浿");
		map.put("2", "�Ӳ���");
		
		String temp = map.put("3", "����ġ");
		System.out.println(temp);
		
		temp = map.put("3", "�տ���"); // ��ü
		System.out.println(temp);
		// ������ key�� ���� �ִ� �ְ� ƨ�ܳ���
		// �������� ���� ���� �� ������ ����
		// ��, �� ������ null�� ��
		
		System.out.println(map); // toString()
		System.out.println("�������� ����: " + map.size()); // 3
		
		
	
		// �������� ���� containsKey
		System.out.println(map.containsKey("4")); // false
		
		// �������� ���� containsValue
		System.out.println(map.containsValue("ȫ�浿")); // true
		
		// ������ ���� get
		String value = map.get("3");
		System.out.println(value); // �տ���
		System.out.println(map); // get�� ������ �� ���� ������ ���� ���� �ƴ�
		
		// ������ ���� remove
		String removedValue = map.remove("1");
		System.out.println(removedValue); // ȫ�浿
		// ������ �����Ͱ� ��ȯ��
		System.out.println(map);
		
		String removedValue2 = map.remove("1");
		System.out.println(removedValue2); // null
		
		
		// -----------------------
		map.put("1", "���Ȱ�");
		map.put("4", "�����");
		map.put("5", "�������");
		
		// key ���� ��ȯ keySets ====> Set ��ü�� ��ȯ��
//		Set<String> set = map.keySet();
//		Iterator<String> iter = set.iterator();
		Iterator<String> iter = map.keySet().iterator();
		
		// iterator �����Ͽ� ��ȸ�� ������ get���� ����
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ", " +map.get(key));
		}
		
	}

}
