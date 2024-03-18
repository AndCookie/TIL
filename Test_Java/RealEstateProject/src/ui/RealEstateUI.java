package ui;
// ����ڿ��� �������� ȭ��
// Scanner�� ����ڷκ��� �Է� �ޱ�
// ��ü : �޴����� ������ ����

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import service.RealEstateService;
import service.RealEstateServiceImpl;
import vo.BuyingAndSelling;
import vo.Charter;
import vo.MonthlyRent;
import vo.RealEstate;

public class RealEstateUI {
	Scanner keyin = new Scanner(System.in);
	RealEstateService service = new RealEstateServiceImpl();
	
	// �޴� 3�� �����
	// 1. ���θ޴�
	public RealEstateUI() {
		while (true) {
			mainMenu();
			String choice;
			choice = keyin.next();
			keyin.nextLine(); // �Է� ���ۿ� �����ִ� ���͸� ����� �۾� ����
			
			switch (choice) {
			case "1" : regist(); break; // ���
			case "2" : retrieve(); break; // �˻� 
			case "3" : modify(); break; // ����
			case "4" : delete(); break; // ����
			case "5" : retrieveAll(); break; // ��ü���
			case "0" : 
				System.out.println("** ���α׷��� �����մϴ�");
				return; // ����
			default :
				System.out.println("** �޴��� �ٽ� �������ּ���");
			}
		}
	}
	


	private void regist() {
		registMenu();
		String choice;
		choice = keyin.next();
		keyin.nextLine(); // �Է� ���ۿ� �ִ� ���͸� ������ ó������
		
		switch (choice) {
		case "1" : // �Ÿ� ��� (�ּ�, �ְ�����, ũ��, �ŸŰ���)
			input("BuyingAndSelling");
			break;
		case "2" : // ���� ��� 
			input("Charter");
			break;
		case "3" : // ���� ���
			input("MonthlyRent");
			break;
		case "0" : return; // �����޴�
		default :
			System.out.println("** �޴��� �ٽ� �������ּ���");
		}
		
	}


	// �Ź� ������ ������ �� �ߺ������� �Է¹޾� ��ȯ�ϴ� �޼ҵ�
	// �ּ�, �ְ�����, ũ��
	private void input(String type) {
		String address;
		String houseType;
		int size;
		int price = 0; // ���� => �Ÿ�,�������� ���� ��� �ݾ�
		RealEstate realEstate = null;
		
		System.out.println("> �ּ� �Է� : ");
		address = keyin.nextLine(); // ������v���ﵿ �̹Ƿ� next ����
		System.out.println("> �ְ� ���� (����Ʈ, ����, �ܵ�����): ");
		houseType = keyin.next();
		System.out.println("> ũ�� (����) : ");
		size = keyin.nextInt();
		
		switch(type) {
		case "BuyingAndSelling" :
			System.out.println("> �Ÿ� ����");
			price = keyin.nextInt();
			realEstate = new BuyingAndSelling(address, houseType, size, price);
			break;
		case "Charter" :
			System.out.println("> ���� ����");
			price = keyin.nextInt();
			realEstate = new Charter(address, houseType, size, price);
			System.out.println(realEstate);
			break;
		case "MonthlyRent" :
			System.out.println("> ���� ����");
			price = keyin.nextInt();
			realEstate = new MonthlyRent(address, houseType, size, price);
			break; // break�� default ���� ����
		}
		
		System.out.println(address + " / " + houseType
				+ " / " + size + " / " + price);
		
		
		// ui�� �ѱ��
		boolean result = service.insert(realEstate);
		
		if (result) {
			System.out.println("** ������ ��ϵǾ����ϴ�.");
			return;
		}
		System.out.println("** ���� ��� ����!");
	}



	private void retrieve() {
		retrieveMenu();
		String choice, address;
		String type = null;
		List<RealEstate> list = null;
		
		choice = keyin.next();
		keyin.nextLine(); // �Է� ���ۿ� �����ִ� ���͸� ����� ����
		
		switch (choice) {
		case "1" : {
			System.out.println("> �˻��� �ּ� �Է�");
			address = keyin.next();
			RealEstate realEstate = service.selectByAddress(address);
			System.out.println(realEstate);
			}
			return; // retrieve�� ����� retrieve�� ȣ����  mainmenu ������ ����
		case "2" : { // �Ÿ� ���� �˻�
			type = "BuyingAndSelling";
			}
			break;
		case "3" : { // ���� ���� �˻�
			type = "Charter";
			}
			break;
		case "4" : { // ���� ���� �˻�
			type = "MonthlyRent";
			}
		default :
			System.out.println("** �޴��� �ٽ� �������ּ���");
			return;
		}
		list = service.selectByType(type);
		if (list.size()==0) {
			System.out.println("** ã�� ������ �����ϴ�");
			return;
		}
		
		
		// iterator�� ���
		Iterator<RealEstate> iter = list.iterator();
		
		// iterator �����Ͽ� ��ȸ�� ������ ����
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}	
	}



	private void modify() {
		String address;
		int price;
		
		System.out.println("|���� ������ �ּ�|");
		address = keyin.nextLine();
		
		RealEstate realEstate = service.selectByAddress(address);
		// �ּҷ� �˻��ϴ� �޼ҵ� ����� -> Serivce -> Impl
		if (realEstate == null) {
			System.out.println("** �ش� �ּ��� ������ �����ϴ�");
		}
		System.out.println("��ϵ� ����" + 
				"\r\n==================================\r\n" +
				realEstate + "\r\n===================================");
		
		
		// ���� ����
		// instanceof : ������ �װ� ����Ű�� �ִ°� ����?!
		if (realEstate instanceof BuyingAndSelling) {
			System.out.println("> �Ÿ� ���� : ");
			price = keyin.nextInt();
			((BuyingAndSelling)realEstate).setPrice(price);
			// �θ� Ŭ������ realEstate���� getprice�� �����Ƿ�
			// �ٿ�ĳ���� �ؾ��Ѵ�!
		}
		else if (realEstate instanceof Charter) {
			System.out.println("> ���� �Ӵ뺸���� : ");
			price = keyin.nextInt();
			((Charter)realEstate).setDepositMoney(price);
		}
		else if (realEstate instanceof MonthlyRent) {
			System.out.println("> ���� �Ӵ�� : ");
			price = keyin.nextInt();
			((MonthlyRent)realEstate).setMonthlyRent(price);
		}
		
		boolean result = service.update(realEstate);
		
		if (result) {
			System.out.println("** ������ �Ϸ�Ǿ����ϴ�");
			System.out.println(realEstate);
			return;
		}
		System.out.println("** ���� ����!");
		
	}



	private void delete() {
		String address;
		
		System.out.println("|���� ������ �ּ�|");
		address = keyin.nextLine();
		
		boolean result = service.delete(address);
		if (result) System.out.println("** ���� �����Ǿ����ϴ�");
		else 		System.out.println("** ���� ����!");
		
	}



	private void retrieveAll() {
		List<RealEstate> list = service.selectAll(); // List<realEstate>�� ��ȯ
		
		if(list.size() == 0) {
			System.out.println("** ��ϵ� �Ź��� �����ϴ�.");
			return ;
		}
		
		// iterator �� �����Ͽ� ��ü ��ȸ
		Iterator<RealEstate> iter = list.iterator();
		
		// iterator �����Ͽ� ��ȸ�� ������ ����
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}	
		
	}



	private void mainMenu() {
		System.out.println("--------------------------\r\n" + 
				"     �ε��� �߰� ���� �ý��� \r\n" + 
				"--------------------------\r\n" + 
				"	1. ��	��\r\n" + 
				"	2. ��	��\r\n" + 
				"	3. ��	��\r\n" + 
				"	4. ����(�ŷ��Ϸ�) \r\n" + 
				"	5. ��ü���\r\n" + 
				"	0. ��	��\r\n" + 
				"--------------------------\r\n" + 
				"�޴� ��ȣ�� �����ϼ��� =>");
	}
	
	private void registMenu() {
		System.out.println("--------------------------\r\n" + 
				"     �ε��� �Ź� ���� ��� \r\n" + 
				"--------------------------\r\n" + 
				"	1. ��	��\r\n" + 
				"	2. ��	��\r\n" + 
				"	3. ��	��\r\n" + 
				"	4. �����޴�\r\n" + 
				"--------------------------\r\n" + 
				"�޴� ��ȣ�� �����ϼ��� =>");
	}
	
	
	private void retrieveMenu() {
		System.out.println("--------------------------\r\n" + 
				"     �ε��� �Ź� ���� �˻� \r\n" + 
				"--------------------------\r\n" +
				"	1. �ּҷ� �˻�\r\n" + 
				"	2. �Ÿ� ���� �˻�\r\n" + 
				"	3. ���� ���� �˻�\r\n" + 
				"	4. ���� ���� �˻�\r\n" + 
				"--------------------------\r\n" +
				"�޴� ��ȣ�� �����ϼ��� => ");
	}
	
	
}