/*
 * even �޼���� ¦�� ������ �߻�����
 * Ȧ�� �߻��� exception���� ó���ϱ�
 * (������� : ������ Ȧ�� ������ ������ �ƴ�����, �츮�� ���Ƿ� ������ ó���ϴ� ��)
 * 
 */
public class ExceptionTest4 {

	public static void main(String[] args) {
		int[] myAry = new int[10]; // ¦�� ���� 10���� ������ �迭 
		
		for (int i=0; i<myAry.length; ++i) {
			try {
				int data = even();
				myAry[i] = data;
			} catch(Exception e) {
				--i;
				continue; // ������ ++i���� �̵�
				// ���� ���� �� �� ���� ���ٸ�, �迭 ���� Ȧ�� ���� �ڸ��� 0���� ä���� ��
			}
			System.out.println(myAry[i]);
		} // end for
	}
	
	// even() = even �޼��� = ¦�� ���� �߻� �޼���
	public static int even() throws Exception {
		int value = (int)(Math.random()*100);
		// Math.random() : 0.0 �̻� 1.0�̸��� �Ǽ� ���� �߻�
		
		if (value%2!=0) {
			throw new Exception("Ȧ���� �ȵ�!");
			// new : ��ü ����
			// throw : �޼ҵ带 ȣ���ߴ� ������ exception�� ������ (return�� ����)
		}
		return value;
	}

}
