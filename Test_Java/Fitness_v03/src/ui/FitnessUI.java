package ui;

import java.util.Scanner;

import service.FitnessService;
import service.FitnessServiceImpl;
import vo.Fitness;

// ����¸� �����ϵ��� ��
public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
	FitnessService service = new FitnessServiceImpl(); // ������
	// �θ� Service�� �ڽ�ServiceImpl�� ����
	
	// ó���� Serivce�� �ϹǷ� ���⼭�� ���� ó���ϴ� ���� ����
	// ������
	public FitnessUI() {
		String choice;
		while (true) {
			menu();
			choice = keyin.next();
			// choice = keyin.nextInt(); �� ������ ����ڰ� ������ �ƴ� ������ �߸� �Է����� ��� ���� �߻���
			
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : retrieve(); break;
			case "3" : modify(); break;
			case "4" : delete(); break;
			case "5" : selectAll(); break;
			case "0" :
				System.out.println("**���α׷��� �����մϴ�.");
				keyin.close();
				return;
			default :
				System.out.println("err> �޴��� �ٽ� �������ּ���");
			}
		}
	}
	
	
	private void create() {
		System.out.println("\n[ ȸ�� ���� ]");
		String id;
		String name;
		double height =0;
		double weight =0;
		
		if (service.getCount() >= FitnessService.MAX) { // service.Max�� ���� ����.
			// FitnessService�� ������ ����� Ŭ���������̱� ����
			System.out.println("** ���� �������� ȸ�������� �Ͻ� �� �����ϴ�.");
			return;
		}
		
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		// ���̵� �ߺ� üũ
		Fitness fitness = service.selectOne(id);
		if (fitness!=null) {
			System.out.println("err> �ߺ��� ���̵� �ֽ��ϴ�.");
			return;
		}
		
		try {
			System.out.print("* ��  ��: ");
			name = keyin.next();
			System.out.print("* Ű(cm): ");
			height = keyin.nextDouble();
			System.out.print("* ������(kg): ");
			weight = keyin.nextDouble();
		} catch (Exception e) {
			System.out.println("err> Ű�� �����Դ� ���ڷ� �Է����ּ���");
			keyin.nextLine(); // �߸� �ԷµǾ� �Է� ���ۿ� �����ִ� ���� Ŭ�����ϱ�!!
			return;
		}
		
		// ��ü ����
		boolean result = service.insert(new Fitness(id, name, height, weight));
		
		if(result)
			System.out.println("** ȸ�������� �Ϸ�Ǿ����ϴ�.");
		else
			System.out.println("** ȸ������ ����");
	}


	private void retrieve() {
		System.out.println("\n[ ���� ��ȸ ]");
		String id;
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		if (fitness==null) {
			System.out.println("** �Է��� ID�� ȸ���� �����ϴ�.");
			return;
		} else
			System.out.println(fitness);
	}


	private void modify() {
		System.out.println("\n[ ���� ���� ]");
		String id;
		double height = 0 ;
		double weight = 0 ;
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness == null) {
			System.out.println("** �Է��� ���̵��� ȸ���� �����ϴ�.");
			return;
		}
		
		try {
			System.out.print("* Ű(cm): ");
			height = keyin.nextDouble();
			System.out.print("* ������(kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> Ű�� �����Դ� ���ڷ� �Է����ּ���");
			keyin.nextLine(); // �߸� �ԷµǾ� �Է� ���ۿ� �����ִ� ���� Ŭ�����ϱ�!!
			return;
		}
			
		// ���ο� Ű�� ������ �Է� (bmi�� ������Ʈ�� ��)
		// ��ü ����
		boolean result = service.update(new Fitness(id, null, height, weight)); // �̸��� �Ⱥ����ٴ� �ǹ�
		
		if (result)
			System.out.println("** ȸ���� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("** ȸ���� ���� ���� ����");
	}


	private void delete() {
		System.out.println("\n[ ȸ�� Ż�� ]");
		String id;
		String answer; // Ż�� �ǻ� ��Ȯ��
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness==null) {
			System.out.println("** �Է��Ͻ� ID�� ȸ���� �����ϴ�.");
			return;
		} else {
			System.out.println("** ������ Ż���Ͻðڽ��ϱ�? (y/n)");
			answer = keyin.next();
			if (!answer.equals("y")) {
				System.out.println("** Ż�� �źεǾ����ϴ�.");
			} else {
				// ��ü ����
				boolean result = service.delete(id); // �̸��� �Ⱥ����ٴ� �ǹ�
				
				if (result)
					System.out.println("** ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
				else
					System.out.println("** Ż�� �۾��� ��ҵǾ����ϴ�.");
				}
		}
	}


	private void selectAll() {
		System.out.println("\n[ ��ü ��ȸ ]");
		
		int count = service.getCount();
		// ȸ���� ���� ��� ��ü ��ȸ �Ұ�
		if (count==0) {
			System.out.println("err> ������ ȸ���� �� �� �����ϴ�.");
			return;
		}
		
		Fitness[] list = service.selectAll();
		for (int i=0; i<count; ++i) {
			System.out.println(list[i]); // .toString() �����ص� �ڵ����� �ٿ���
		}
		
	}
	
	


	public void menu() {
		System.out.println("=====[���� ���� ȸ������]=====");
		System.out.println("     1) ȸ�� ����");
		System.out.println("     2) ���� ��ȸ");
		System.out.println("     3) ���� ����");
		System.out.println("     4) Ż      ��");
		System.out.println("     5) ��ü ��ȸ");
		System.out.println("     0) ��      ��");
		System.out.println("=========================");
		System.out.println("         ���� > ");
	}
	
	
}
