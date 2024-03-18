/*
 * 0~100������ ������ �߻���Ų��.
 * => ���� �迭 10��¥�� �غ�!
 * �߻��� ������ 3�� ����̰ų� 8�� ����� ��쿡 �迭�� �����ϰ�
 * �׷��� ���� ��� �ͼ��� ó���Ͽ� ��� �迭�� �����͸� �����ÿ�.
 * ���� ���ڰ� �ԷµǾ ���� �߻����� ���� ���α׷� ���ᰡ ���� �ʾƾ� ��.
 */

public class ExceptionTest5 {

	public static void main(String[] args) {
		int[] ary = new int[10]; // 3 �Ǵ� 8�� ����� ���� 10���� ������ �迭 
		
		for (int i=0; i<ary.length; ++i) {
			try {
				ary[i] = temp();
			} catch(Exception e) {
				--i;
				continue; // ������ ++i���� �̵�
				// ���� ���� �� �� ���� ���ٸ�, �迭 ������ 3 �Ǵ� 8�� ����� �ƴ� ������ �ڸ��� 0���� ä���� ��
			}
			System.out.println(ary[i]);
		} // end for
	}
	
	public static int temp() throws Exception {
		int a = (int)(Math.random()*100);
		// Math.random() : 0.0 �̻� 1.0�̸��� �Ǽ� ���� �߻�
		
		if ((a%3!=0)&&(a%8!=0)) { // if(!(a%3==0 || a%8==0))
			throw new Exception("3�� ��� �Ǵ� 8�� ������� �մϴ�!");
			// new : ��ü ����
			// throw : �޼ҵ带 ȣ���ߴ� ������ exception�� ������ (return�� ����)
			// �޼ҵ� �ñ״�ó �κп� throws Exception�� �����ֱ�
		}
		return a;
	}
	
}
