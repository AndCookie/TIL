
public class ExceptionTest1 {

	public static void main(String[] args) {
		try {
			String [] str = {"1", "0", "a"}; // �迭 ������ ���ÿ� �ʱ�ȭ
			
			int num1 = Integer.parseInt(str[0]); // ����
			int num2 = Integer.parseInt(str[1]); // �и� : ���� ���� �߻�x
			int num3 = Integer.parseInt(str[2]);
			int num4 = Integer.parseInt(str[3]); // 3������ �������� ����
			
			
			int result1 = num1 / num1;
			System.out.println("������ ���: " + result1);
			
			int result2 = num1 / num2;
			System.out.println("������ ���: " + result2);
			// Exception in thread "main" : ���� ���������� ���� �߻�
			// java.lang.ArithmeticException : arithmetic�̶�� ���� �߻�
			// by zero : ���� ��ü�� �̸�
			// at ExceptionTest1.main(ExceptionTest1.java:10) : ���� �߻� ��ġ
			
			int result3 = num1 / num3;
			System.out.println("������ ���: " + result3);
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "a"
			// at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
			// at java.lang.Integer.parseInt(Integer.java:580)
			// at java.lang.Integer.parseInt(Integer.java:615)
			// at ExceptionTest1.main(ExceptionTest1.java:10)
			// Tracing : ���� ���� �߻� ������ 10°�� �����ε�, �̰��� Integer.java�� **���ο� ����Ͽ� ���޵Ǿ��ٴ� �ǹ�
			
			int result4 = num1 / num4;
			System.out.println("������ ���: " + result4);
			// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
			// at ExceptionTest1.main(ExceptionTest1.java:11)

		
		} catch(ArithmeticException e) {
			// ���ܸ� �������ڷ� �ޱ� // ������ e
			System.out.println(e.getMessage());
			e.printStackTrace(); // ������ ���������� tracing �����Ͽ� ������
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
			// ���� �ڽĵ��� ����Ƴ���, �θ��� exception�� ����ִ� ��
			// exception�� �� ���� ���� �Ǹ�, �Ʒ��� �ڽ��ڵ�� ���� �ڵ尡 �Ǿ������.
		} finally {
			// exception�� �߻��Ǵ��� �ݵ�� ����Ǵ� �ڵ�!!!!!
			// �޸𸮸� ��ȯ�ϰų� Scanner close �ϴ� �� ���
		}

	}

}