// ������ EnumTest �ȿ� ���� ����������, �ٸ� Ŭ���� ���Ϸ� ���� ��
//enum Season {
//	��, ����, ����, �ܿ�;	
//}

//Season�� �ϳ��� ������ Ÿ���� �Ǵ� ��
//class Friend {
//	
//}


public class EnumTest1 {
	// Ư�� Ŭ���� �ȿ� ���� ������ Ÿ�����ε� ��� �����ϸ� �̶� �������� ������ ��
	enum Season {
		��, ����, ����, �ܿ�;	
	}

	public static void main(String[] args) {
		Season s = Season.��; // STATIC FINAL
//		Season s = "��"// �Ұ��� : ���⼭�� ���� String�̴ϱ� Ÿ�� ����ġ
		System.out.println(s);
	}

}
