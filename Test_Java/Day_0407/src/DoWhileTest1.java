
public class DoWhileTest1 {

	public static void main(String[] args) {
		int i = 0;
		
		do {
			System.out.println(i);
		// ++i�� �켱���� 1�� // ���� ������ �켱������ ���ٸ� ���չ��� ������� ����
//		} while (++i<10); // 0 1 2 .. 9
		} while (i++<10); // 0 1 2 .. 10
		// i=9�� ��, 9 < 10 �Ŀ� ++�Ͽ� 10���� ����
	}

}
