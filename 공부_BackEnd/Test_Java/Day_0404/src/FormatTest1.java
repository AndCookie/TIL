
public class FormatTest1 {

	public static void main(String[] args) {
		int idata = 15;
		double ddata = 3.14;
		char cdata = '&';
		String sdata = "����ȭ ���� �Ǿ����ϴ�.";
				
		System.out.printf("�������� => %d%n", idata); //%n �Ǵ� \n���� ����
		System.out.printf("�Ǽ����� => %.2f\n", ddata); //default : �Ҽ��� ���� �����ڸ�

		System.out.printf("���ڰ��� => %c%n", cdata); //%n �Ǵ� \n���� ����
		System.out.printf("���ڿ���=> %s\n", sdata);
	}

}
