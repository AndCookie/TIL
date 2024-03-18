package master.ui;

import java.util.Scanner;

import master.service.ScoreService;
import master.service.ScoreServiceImpl;
import master.vo.Student;

public class ScoreUI {
	Scanner keyin = new Scanner(System.in);
	ScoreService service = new ScoreServiceImpl(); // ������

	// ó���� Serivce�� �ϹǷ� ���⼭�� ���� ó���ϴ� ���� ����
	// ������
	public ScoreUI() {
		while (true) {
			menu();
			String choice;
			choice = keyin.next();

			switch(choice) {
			case "1" : regist(); break; // ���� ���
			case "2" : retrieve(); break; // ���� ��ȸ
			case "3" : retrieveAll(); break; // ��ü ���� ��ȸ
			case "4" : delete(); break; // ����
			case "5" : modify(); break; // ����
			case "6" : scoreAnaly(); break; // ���� ��� ��ȸ
			case "0" : // ����
				System.out.println("** ���α׷��� �����մϴ�.");
				return;
			default : 
				System.out.println("** �޴��� �ٽ� �������ּ���");
			}
		}
	}

	private void regist() {
		System.out.println("\n[ ���� ��� ]");
		String stdid;
		String stdname;
		double it;
		double language;
		double basic;

		if (service.getCount() >= ScoreService.MAX) { // service.Max�� ���� ����.
			// ScoreService�� ������ ����� Ŭ���������̱� ����
			System.out.println("** �ο� �ʰ��� ���� ���� ��� �Ұ�");
			return;
		}

		System.out.print("* �й�: ");
		stdid = keyin.next();

		// ���̵� �ߺ� üũ
		Student student = service.selectOne(stdid);
		if (student!=null) {
			System.out.println("err> �ߺ��� ���̵� �ֽ��ϴ�.");
			return;
		}

		System.out.print("* �̸�: ");
		stdname = keyin.next();
		System.out.print("* IT: ");
		it = keyin.nextDouble();
		System.out.print("* �ܱ���: ");
		language = keyin.nextDouble();
		System.out.print("* ������: ");
		basic = keyin.nextDouble();

		// ��ü ����
		boolean result = service.insert(new Student(stdid, stdname, it, language, basic));

		if(result)
			System.out.println("** ���� ��� �Ϸ�");
		else
			System.out.println("** ���� ��� ����");
	}


	private void retrieve() {
		System.out.println("\n[ ���� ��ȸ ]");
		String stdid;
		System.out.print("* �й�: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);
		if (student==null) {
			System.out.println("** �Է��� �й��� �л��� �����ϴ�.");
			return;
		} else
			System.out.println(student);
	}


	private void retrieveAll() {
		System.out.println("\n[ ��ü ���� ��ȸ ]");
		int count = service.getCount();
		// ȸ���� ���� ��� ��ü ��ȸ �Ұ�
		if (count==0) {
			System.out.println("err> ��ϵ� �л��� �� �� �����ϴ�.");
			return;
		}

		Student[] list = service.selectAll();
		for (int i=0; i<count; ++i) {
			System.out.println(list[i]); // .toString() �����ص� �ڵ����� �ٿ���
		}
	}

	private void delete() {
		System.out.println("\n[ ���� ]");
		String stdid;
		String answer; // ���� �ǻ� ��Ȯ��

		System.out.print("* �й�: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);

		if (student==null) {
			System.out.println("** �Է��Ͻ� �й��� �л��� �����ϴ�.");
			return;
		} else {
			System.out.println("** ������ �����Ͻðڽ��ϱ�? (y/n)");
			answer = keyin.next();
			if (!answer.equals("y")) {
				System.out.println("** ������ �źεǾ����ϴ�.");
			} else {
				// ��ü ����
				boolean result = service.delete(stdid); // �̸��� �Ⱥ����ٴ� �ǹ�

				if (result)
					System.out.println("** ������ �Ϸ�Ǿ����ϴ�.");
				else
					System.out.println("** ���� �۾��� ��ҵǾ����ϴ�.");
			}
		}

	}

	private void modify() {
		System.out.println("\n[ ���� ]");
		String stdid;
		double it;
		double language;
		double basic;

		System.out.print("* �й�: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);

		if (student == null) {
			System.out.println("** �Է��Ͻ� �й��� �л��� �����ϴ�.");
			return;
		}

		System.out.print("* IT: ");
		it = keyin.nextDouble();
		System.out.print("* �ܱ���: ");
		language = keyin.nextDouble();
		System.out.print("* ������: ");
		basic = keyin.nextDouble();

		// ���ο� ���� �Է� (avg�� ������Ʈ�� ��)
		// ��ü ����
		boolean result = service.update(new Student(stdid, null, it, language, basic)); // �̸��� �Ⱥ����ٴ� �ǹ�

		if (result)
			System.out.println("** ���� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("** ���� ���� ���� ����");

	}

	private void scoreAnaly() {
		System.out.println("\n[ ���� ��� ��ȸ ]");

		int count = service.getCount();
		// ȸ���� ���� ��� ��ü ��ȸ �Ұ�
		if (count==0) {
			System.out.println("err> ��ϵ� �л��� �� �� �����ϴ�.");
			return;
		}


		double[] list1 = service.scoreAnaly();
		System.out.println("���� ���� �Ʒ��� �����ϴ�");
		for (int i=0; i<ScoreService.SUBJECT; ++i) {
			System.out.printf("%.2f%n", list1[i]); // .toString() �����ص� �ڵ����� �ٿ���
		}
		System.out.println("���� ����� �Ʒ��� �����ϴ�");
		for (int j=0; j<ScoreService.SUBJECT; ++j) {
			list1[j] = list1[j]/count;
			System.out.printf("%.2f%n", list1[j]); // .toString() �����ص� �ڵ����� �ٿ���
		}
	}


	private void menu() {
		System.out.println("=====[MASTER ��������]=====");
		System.out.println("     1) ���� ���");
		System.out.println("     2) ���� ��ȸ");
		System.out.println("     3) ��ü ���� ��ȸ");
		System.out.println("     4) ��      ��");
		System.out.println("     5) ��      ��");
		System.out.println("     6) ���� ��� ��ȸ");
		System.out.println("     0) ��      ��");
		System.out.println("=========================");
		System.out.println("         ���� > ");


	}


}
