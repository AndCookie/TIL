package board;

public class BoardTest {

	public static void main(String[] args) {
	// �޼ҵ带 ���ؼ� ��ȸ������ ����
		// Ŭ������ �����ؼ� ����Ѵ� = �޸𸮿� �÷��� �����Ѵ�
		Board b1 = new Board(); // ������ �żҵ� (Constructor)
		b1.setBoardseq(123);
		b1.setTitle("������ ������");
		b1.setWriter("ȫ�浿");
		b1.setRegdate("2023-04-10");
		b1.setContents("�������� �������� ����");
		b1.setAttachment("java.docx");
		b1.setViewcount(15);
		
		b1.output();
		System.out.println();		
		}

}
