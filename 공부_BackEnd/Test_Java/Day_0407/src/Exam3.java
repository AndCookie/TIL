import java.util.Scanner;

/*
 * [����2] ��ȭ ���� �ý��� �����
String[] seat = new String[10]; �¼� // 1-���� ���ڿ� �迭 ����
String name;    ������ �̸� // 1~10
int seatNumber; �¼� ��ȣ

 * 
 * <���� ����>
 * ============================================
 * [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 * ������ �̸� �Է� : James
 * �¼� �Է� (1~10) : 5
 * ============================================
 * [ ] [ ] [ ] [ ] [James] [ ] [ ] [ ] [ ] [ ]
 * ������ �̸� �Է� : Tom
 * �¼� �Է� (1~10) : 5
 * �̹� ����� �¼��Դϴ�! �ٸ� �¼��� ����ּ���
 * 
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String [] seat = new String[10];
		String name;
		int seatNumber, remain = seat.length;
		
		
		// ��ü �¼� ���
		while (true) {
			System.out.println("\n=============================================");
			// ���� �¼� ��
			System.out.println("** ���� �¼� �� : " + remain);
			
			for (int i =0; i<seat.length; ++i) {
				System.out.print("[ ");
				if (seat[i] != null) System.out.print(seat[i]);
				System.out.print(" ]");	
			}
			System.out.println();
			
			// ������ �̸� �Է�
			System.out.print("������ �̸� �Է� : ");
			name = keyin.next();
			
			// �¼� ��ȣ �Է�
			System.out.print("�¼� ��ȣ �Է� (1~10) : \n");
			seatNumber = keyin.nextInt();
			
			// ���� �¼�
			if (seatNumber<1||seatNumber>10) {
				System.out.println("���� �¼��Դϴ�. �ٸ� �¼��� ����ּ���!");
				continue;
			}
			// �̹� ����� �¼�
			if (seat[seatNumber-1] != null){
				System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� ����ּ���!");
				continue;
			}
			// ���� ���� : �̸� ��� �� ���� �¼��� ����
			seat[seatNumber-1] = name;
			--remain;
		} // end while
	}
		
}