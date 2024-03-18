import java.util.StringTokenizer;

public class StringTokenizerTest2 {

	public static void main(String[] args) {
		String party = "ǳ��/25000, �ɟ�/37000, ����/10000"
				+ ", ������/50000, �ɴٹ�/75000";
		
		// ��������
		StringBuffer buf = new StringBuffer();
		int total = 0;
		
		// ���� (StringTokenizer)
		StringTokenizer stk = new StringTokenizer(party, "/, "); // ctrl+shift+o�� import
//		System.out.println(stk.countTokens()); // ��ū�� ���� = 10
		
		while (stk.hasMoreTokens()) {
			String item = stk.nextToken();
			buf.append(item).append(", ");
			int price = Integer.parseInt(stk.nextToken());
			total += price;
			System.out.println(item + "\t" + price);
		}
		
		System.out.println("======================");
		System.out.println("��Ƽ ������ : " + buf.toString());
		System.out.println("�� ����ݾ� : " + String.format("%,d", total) + "��");
		// %,d : �� �ڸ����� �޸� ���� �� ����!!
		
	}

}
