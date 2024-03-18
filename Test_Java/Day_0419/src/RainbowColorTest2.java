
public class RainbowColorTest2 {

	public static void main(String[] args) {
		// values() : �迭�� ��ȯ
		RainbowColor[] color = RainbowColor.values();
		for (RainbowColor c : color) {
			System.out.println(c);
		}
		
		// valueOf(���ڿ�) : ���ڿ��� ��Ī�Ǵ� enum ������ ��ȯ : String���� ��ȯ
		RainbowColor c = RainbowColor.valueOf("��");
		System.out.println(c);
		
		// name() : �ش� enum�� �����͸� ���ڿ��� ��ȯ => toStringIO ����
		String c1 = c.name();
		String c2 = c.toString();
		System.out.println(c1 + ", " + c2 + ", " + c1.equals(c2));
	
		// ordinal() : �ش� enum�� index�� ������ ��ȯ
		RainbowColor y = RainbowColor.��;
		int o = y.ordinal();
		System.out.println(o);
	}

}
