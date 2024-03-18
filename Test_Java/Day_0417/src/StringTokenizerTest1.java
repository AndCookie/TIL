import java.util.StringTokenizer;

public class StringTokenizerTest1 {

	public static void main(String[] args) {
		String str = "�ɟ�, �ɴٹ�, ���";
		// split �Ұ� : �ϳ��� ������ character�� ���ڷ� �־���ϹǷ�
		// StringTokenizer ����
		
		
		// �⺻ ������ : ����
		StringTokenizer st1 = new StringTokenizer(str); // ctrl+shift+o�� import
		System.out.println(st1.countTokens()); // ��ū�� ���� = 3
		
		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		
		// ������ ����
		StringTokenizer st2 = new StringTokenizer(str, ", "); // ctrl+shift+o�� import
		System.out.println(st2.countTokens()); // ��ū�� ���� = 3
		
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

		
	}

}
