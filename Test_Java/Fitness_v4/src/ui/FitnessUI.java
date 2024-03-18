/* 
 * ���� ����
 * Service -> ServiceImpl -> UI -> Fitness -> Test
 */
package ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import service.FitnessService;
import service.FitnessServiceImpl;
import vo.Fitness;

public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
	FitnessService service = new FitnessServiceImpl();

	public FitnessUI() {
		String choice;
		while (true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : retrieve(); break;
			case "3" : modify(); break;
			case "4" : delete() ; break;
			case "5" : selectAll(); break;
			case "0" : 
				System.out.println("** ���α׷��� �����մϴ�.");
				keyin.close();
				return;
			default:
				System.out.println("err> �޴��� �ٽ� �������ּ���");
			}
		}
	}

	private void create() {
		System.out.println("\n[ ȸ�� ���� ]");
		
		String id;
		String name;
		double height;
		double weight;
		
//		if (service.getCount() >= FitnessService.MAX) {
//			System.out.println("** ȸ�������� �Ͻ� �� �����ϴ�.");
//			return;
//		}
		// ArrayList�� ���� ���� �����Ƿ� �ʿ� ����!! ===============================
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		// ���̵� �ߺ�üũ
		Fitness fitness = service.selectOne(id);
		if(fitness != null) {
			System.out.println("err> �ߺ��� ���̵� �ֽ��ϴ�.");
			return;
		}
		
		try {
			System.out.print("* �� ��: ");
			name = keyin.next();
			
			System.out.print("* Ű(cm): ");
			height = keyin.nextDouble();
			
			System.out.print("* ������(Kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> Ű�� �����Դ� ���ڷ� �Է����ּ���\n");
			keyin.nextLine(); // ���۸� ���� ����
			return;
		}
		
		boolean result = service.insert(new Fitness(id, name, height, weight));
		
		if(result)
			System.out.println("** ȸ�������� �Ϸ�Ǿ����ϴ�.");
		else
			System.out.println("** ȸ������ ����");
	}

	private void retrieve() {
		System.out.println("\n[ ȸ�� ��ȸ ]");
		
		String id;
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** �Է��� ID�� ȸ���� �����ϴ�.");
			return;
		}
		System.out.println(fitness);
	}

	// ���� ����
	private void modify() {
		System.out.println("\n[ ���� ���� ]");
		
		String id;
		double height;
		double weight;

		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** �Է��� ���̵��� ȸ���� �����ϴ�.");
			return;
		}
		
		try {
			System.out.print("* Ű(cm): ");
			height = keyin.nextDouble();
			
			System.out.print("* ������(Kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> Ű�� �����Դ� ���ڷ� �Է����ּ���\n");
			keyin.nextLine();
			return;
		}
		boolean result = service.update(new Fitness(id, null, height, weight));
		
		if(result) 
			System.out.println("** ȸ���� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("** ȸ���� ���� ���� ����");
	}

	private void delete() {
		System.out.println("\n[ ȸ�� Ż�� ]");
		String id;
		String answer;
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** �Է��Ͻ� ȸ���� �����ϴ�.");
			return;
		}
		
		System.out.print("** ������ Ż���Ͻó���? (y/n) ");
		answer = keyin.next();
		
		if(!answer.equals("y")) {
			System.out.println("** Ż�� �۾��� ��ҵǾ����ϴ�.");
			return;
		}
	
		boolean result = service.delete(id);
		
		if(result) 
			System.out.println("** ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
		else 
			System.out.println("** Ż���۾� ����");
	}

	private void selectAll() {
		System.out.println("\n[ ��ü ��ȸ ]");
		
//		int count = service.getCount(); =============
//		Fitness[] list = service.selectAll(); =============
		List<Fitness> list = service.selectAll(); // List<Fitness>�� ��ȯ
		
		if(list.size() == 0) {
			System.out.println("** ������ ȸ���� �� �� �����ϴ�.");
			return ;
		}
		
//		for (int i=0; i<count; ++i) {
//			System.out.println(list[i]); // .toString() �����ص� �ڵ����� �ٿ���
//		}
		// iterator �� �����Ͽ� ��ü ��ȸ
		Iterator<Fitness> iter = list.iterator();
		
		// iterator �����Ͽ� ��ȸ�� ������ get���� ����
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}			

	}

	public void menu() {
		System.out.println("===[XX ���� ȸ������]===");
		System.out.println("    1) ȸ�� ����");
		System.out.println("    2) ���� ��ȸ");
		System.out.println("    3) ���� ����");
		System.out.println("    4) Ż     ��");
		System.out.println("    5) ��ü ��ȸ");
		System.out.println("    0) ��     ��");
		System.out.println("========================");
		System.out.print  ("        ���� > ");
	}
}