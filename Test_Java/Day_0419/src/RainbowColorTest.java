
public class RainbowColorTest {

	public static void main(String[] args) {
		RainbowColor rainbow = RainbowColor.��;
		System.out.println(rainbow);
		System.out.println(rainbow.getClass());
		
		String o = RainbowColor.��.getData();
		System.out.println(o);
		System.out.println(o.getClass());
		
		
		RainbowColor rainbow2 = RainbowColor.��;
		System.out.println(rainbow2);
		System.out.println(rainbow2.getClass());
		
		String r1 = RainbowColor.��.getString();
		String r2 = RainbowColor.��.getString2();
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r1.getClass());
		System.out.println(r2.getClass());
		
		
		switch(rainbow2) {
		case �� : System.out.println("��Ȳ���� ����"); break;
		case �� : System.out.println("������� ����"); break;
		default:
			break;
		}
		
		
		////////////////////////////////// �迭
		// values() : enum�� ��� item�� �迭�� ��ȯ�ϴ� �޼ҵ�
		RainbowColor [] color = RainbowColor.values();
		// enum �ȿ� values��� �޼ҵ尡 ����
		// ���� �����͸� �迭�� ��ȯ
		System.out.println("Item�� ����: " + color.length);
		for (RainbowColor c : color) {
			// �ݷ� ������ : �÷��� // �ݷ� ���� : �÷��� �� �� �������� Ÿ��
			System.out.println(c);
		}
		
		for (int i=0; i<color.length; ++i)
			System.out.println(color[i]);
	}

}
