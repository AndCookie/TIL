/*
 * ����� ���� Ŭ����
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
	
	// �ּҰ��� �νĽ�Ŵ
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
		
		// ����� ���Ǵ� ������ new�� ��ü ������ ����� �Ѵ�!!!
		list.add(new Friend("�տ���", "010-111-1111"));
		list.add(new Friend("���Ȱ�", "010-222-1111"));
		list.add(new Friend("�����", "010-333-1111"));
		list.add(new Friend("�Ӳ���", "010-444-1111"));
		list.add(new Friend("����ġ", "010-555-1111"));
		
		System.out.println("�������� ���� : " + list.size()); // 5
		
		// contain
		boolean bool = list.contains(new Friend("�Ӳ���", "010-444-1111"));
		System.out.println(bool); // false // true
		// ���ο� ��ü�� �����߱� ������ false -> Friend class�� �����ϱ�
		// hashcode�� equals �������̵� �ϸ� true ��!
		
		// indexOf
		int i = list.indexOf(new Friend("�Ӳ���", "010-444-1111"));
		System.out.println(i); // -1 : ��ã�Ҵٴ� �ǹ�
		
		// ======================
		// ��, new�� ���ο� ��ü�� ������ٸ�
		// hashcode�� equals�� �������̵� �ؾ߸� �ν� ������ ��!!
		
		
		// �Ӳ����� ã��ʹٸ� iterator�� ��ȸ���Ƽ� ����
	}
}
