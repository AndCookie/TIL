
public class WhileTest1 {

	public static void main(String[] args) {
		int i = 0;
		
		while (i<10) {
			++i;
//			if (i>10) break; // break��  ������� �� �� ���� ��
			if (i%2==0) continue; // ��������� �ٲ㼭 �ٽ� ���ǽ����� ����
			System.out.println(i);
//			++i;
		}
		
//		System.out.println("��! " + i);
	}

}
