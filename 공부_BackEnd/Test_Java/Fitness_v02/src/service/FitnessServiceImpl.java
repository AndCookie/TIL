package service;

import java.util.Scanner;
import vo.Fitness;

// FitnessService ���� �޼ҵ带 ���� Implement�� ���� Ŭ���� �����
// �ڽ�    extends  �θ� : Ȯ��
// ���� implements ���� : ����
public class FitnessServiceImpl implements FitnessService {
	Scanner keyin = new Scanner(System.in);
	Fitness[] fitness = new Fitness[50]; // �ٸ� ��Ű���� �־ ���� �߻��� ctrl+shift+o
	int count = 0;
	
	// ���𰡸� �����ϴ� ����
	public FitnessServiceImpl() {
		String choice;
		
		while(true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : insert(); break;
			case "2" : read(); break;
			case "3" : update(); break;
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
	

	
	@Override
	public boolean insert() {
		System.out.println("\n[ ȸ�� ���� ]");
		String id;
		String name;
		double height;
		double weight;
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		// ���̵� �ߺ� üũ
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) { // fitness[i].toString() �����ص� �ڵ����� �ٿ���
				System.out.println("err> �ߺ��� ���̵� �ֽ��ϴ�.");
				return false; // boolean insert�̱� ������ return�� �ƴ� return false
			}
		}
		
		System.out.print("* ��  ��: ");
		name = keyin.next();
		System.out.print("* Ű(cm): ");
		height = keyin.nextDouble();
		System.out.print("* ������(kg): ");
		weight = keyin.nextDouble();
		
		// ��ü ����
		fitness[count] = new Fitness(id, name, height, weight);
		++count;
		
		System.out.println("** ȸ�������� �Ϸ�Ǿ����ϴ�.");
		return true;
	}

	
	@Override
	public void read() {
		System.out.println("\n[ ���� ��ȸ ]");
		String id;
		System.out.print("* ���̵�: ");
		id = keyin.next();
		// ȸ���� ���� ���
		if (count==0) {
			System.out.println("err> ������ ȸ���� �� �� �����ϴ�.");
			return;
		}
		// ���̵� ��ġ Ȯ��
		for (int i=0; i<count; ++i) {
			if(fitness[i].getId().equals(id)) {
				System.out.println(fitness[i]); // .toString() �����ص� �ڵ����� �ٿ���
				return;
			}
		}
		System.out.println("** �Է��� ID�� ȸ���� �����ϴ�.");
		// return; ���� ���� : ������ �Ʒ��� �߰�ȣ ���� �Ŵϱ�
	}

	
	@Override
	public boolean update() {
		System.out.println("\n[ ���� ���� ]");
		String id;
		double height;
		double weight;
		int position = -1; // ��ġ�ϴ� ȸ���� ��ã���� -1�� ����
		
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) {
				position = i; // for�� ������ ����� ���������� i�� ����� �� �����Ƿ�
				// for�� �ȿ��� i�� position���� �����ؾ����� �ۿ��� ����� �����ϴ�
				break;
			}
		}
		
		if (position == -1) {
			System.out.println("** �Է��� ���̵��� ȸ���� �����ϴ�.");
			return false;
		}
		
		System.out.print("* Ű(cm): ");
		height = keyin.nextDouble();
		System.out.print("* ������(kg): ");
		weight = keyin.nextDouble();
		
		// ���ο� Ű�� ������ �Է� (bmi�� ������Ʈ�� ��)
		fitness[position].setHeight(height);
		fitness[position].setWeight(weight);
		System.out.println("** ȸ���� ������ �����Ǿ����ϴ�.");
		
		return true;
	}

	
	@Override
	public boolean delete() {
		System.out.println("\n[ ȸ�� Ż�� ]");
		String id;
		System.out.print("* ���̵�: ");
		id = keyin.next();
		
		// position�� �־ �ٲٱ�
		// ��¥ Ż���� ���� ��Ȯ���ϱ�
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) {
				for (int j=i; j<count-1; ++j) { // count-1 : 5������ �ƹ��͵� ���� null�̹Ƿ� �ű� �� ����
					fitness[j] = fitness[j+1];
				}
				System.out.println("** ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
				--count;
				return true;
			}
		}	
		System.out.println("** �Է��Ͻ� ID�� ȸ���� �����ϴ�.");
		return false;
	}

	
	@Override
	public void selectAll() {
		System.out.println("\n[ ��ü ��ȸ ]");
		// ȸ���� ���� ��� ��ü ��ȸ �Ұ�
		if (count==0) {
			System.out.println("err> ������ ȸ���� �� �� �����ϴ�.");
			return;
		}
		for (int i=0; i<count; ++i) {
			System.out.println(fitness[i]); // .toString() �����ص� �ڵ����� �ٿ���
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
