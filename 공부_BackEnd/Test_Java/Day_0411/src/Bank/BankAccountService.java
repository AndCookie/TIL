package Bank;
// BankAccountTest�� �̹� main�� �����Ƿ� BankAccountSerive���� main�� �ʿ����!
// ================== Ŭ���� ���̾�׷� =================
// main ----> service ----> BankAccount
// main�� service�� �����ϰ�, service�� bankaccount�� �����ϴ� ����
// service : ����� ���� ���.
// bankaccount : �����͸� ���� ����.

import java.util.Scanner;

public class BankAccountService {
	Scanner keyin = new Scanner(System.in);
	// Scanner�� �츮 ������ ���� ��ƴ�. ���� ��� ���� ��
	BankAccount bank; // null
	// ���� ������ ���������̸� �޴� ����� Ȱ���� �� �����Ƿ� ���������� ������ ��
	// ���������� �ڵ����� �ʱ�ȭ��!! // �� �⺻���� �ƴ� �������� ���� �� null�� �ʱ�ȭ��
	// stack ������ bank��� �׸� ���ڿ� BankAccount��� Ÿ���� null�� ����ִ� ���̰�
	// heap �������� ���� �ƹ��͵� ����Ű�� �ʴ� 
	
	public BankAccountService() {
		// ������ó�� �ʱ�ȭ ��Ű�� ���� �ƴ϶� ���𰡸� �����ϴ� ������ ��
//		System.out.println("����Ŭ���� ������");
		// ���ں��� ���ڿ��� �޴� ���� ����. ���ڴ� �߸� �Է½� ���� ���µ�, ���ڿ��� �߸� �Է� �޴��� �ٽ� �Է� �����ϹǷ�
		String choice; // �ʱ�ȭ���� ���� �������� // �ʱ�ȭ �ȵ�!!!
		
		while (true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : deposit(); break; // BankAccount�� deposit, withdraw���� ������ �ٸ�,
			case "3" : withdraw(); break;// BankAccountService�� �Ҽ��� deposit()�� withdraw()
			case "4" : output(); break;
			// �׳� output()�� ���´ٸ� BankAccount�� �ƴ� BankAccountService�� �Ҽ�
			// bank.output()�̸� BankAccount�� �Ҽ�
			case "0" : System.out.println("** ���α׷��� �����մϴ�.");
					   return;
					   // return�� �ڱ⸦ ȣ���ߴ� ������ ��, �����ڷ� ���ư�
					   // : public BankAccountService() => BankAccountService service = new BankAccountService();
					   // �߰�ȣ�� �ɷ� ���� => main�� �����ٴ� ���� ���α׷��� ����Ǿ��ٴ� �ǹ�
			default : System.out.println("> ���� : �޴��� �ٽ� �����Ͻÿ�\n");
//					   continue; // default�̹Ƿ� ������ �Ʒ��� �߰�ȣ�� �ɷ��� while�� �ٽ� ���ư�
			}
			
		}
		
	}
	
	// /**+���� :���� �ּ�
	
	/**
	 * ���
	 */
	private void withdraw() {
		System.out.println("\n[ ��       �� ]");
		int money;
		
		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
		}
		
		System.out.print("* ��ݾ�: ");
		money = keyin.nextInt();
		
		if (money>bank.getBalance()) {
			System.out.println("** �ܾ��� �����մϴ�");
			return;
		} else {
			System.out.println("** ��� �Ϸ�");
			bank.withdraw(money);
			System.out.println(bank.getBalance());
		}
		// ��ȯ�� ���� 0�̸� "** �ܾ��� �����մϴ�."
		// �ƴ϶�� "** ��� �Ϸ�" �޼��� �����ְ� getter�� �̿��Ͽ� ���� �ܾ� ������ֱ�
	}

	/**
	 * �Ա�
	 */
	private void deposit() {
		System.out.println("\n[ ��       �� ]");
		int money;
		
		// ���°� ���� ���¿��� ����� ����� NullPointException�� ������ �߻���
		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
		}
		
		System.out.print("* �Աݾ�: ");
		money = keyin.nextInt();
		
		int result = bank.deposit(money);
		if (result<=0) {
			System.out.println("** �ݾ��� ��Ȯ�� �Է����ּ���");
			return;
		} else {
			System.out.println("** �Ա� �Ϸ�");
			System.out.println(bank.getBalance());
		}
		// ��ȯ�� ���� 0�̸� �Ա��� �ȵǾ��ٴ� �޽��� ������ ��ȯ "** �ݾ��� ��Ȯ�� �Է����ּ���"
		// �ƴ϶�� "** �Ա� �Ϸ�" �޼��� �����ְ� getter�� �̿��Ͽ� ���� �ܾ��� ������ֱ�
	}

	/**
	 * ���� ���� ���
	 */
	private void output() {
		System.out.println("\n[ �ܾ� Ȯ�� ]");
		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
		}
		bank.output();
	}
	/**
	 * ���� ���º�ȣ, �̸�, �ܾ��� �Է¹޾� ���¸� �����Ѵ�.
	 */
	private void create() {
		String accountNo;
		String accountName;
		int balance;
	
		System.out.println("[ ���� ���� ]");
		if (bank!=null) {
			System.out.println("** ���� ������ ��ƽ��ϴ�.");
			return;
			// private void create()�� ȣ���ߴ�
			// switch(choice) {case "1" : create(); break; �� ���ư� ��
			// while(true)�� menu()�� ���� ��
		} else {
			System.out.print("* ���º�ȣ: ");
			accountNo = keyin.next();
			System.out.print("* �����ָ�: ");
			accountName = keyin.next();
			System.out.print("* �Աݾ�: ");
			balance = keyin.nextInt();	
		}
		
		// �����ڸ� ���� �޸𸮿� �ø���
		bank = new BankAccount(accountNo, accountName, balance); //ctrl+space
		System.out.println("** ���� ������ �Ϸ�Ǿ����ϴ�.");
		return;
		
		// �߰�ȣ�� ������ ������ �ڵ����� menu�� ���ư�
	}
	
	private void menu() {
		System.out.println();
		System.out.println("=== [�������� ATM ����] ===");
		System.out.println("       1. ���� ����");
		System.out.println("       2. ��      ��");
		System.out.println("       3. ��      ��");
		System.out.println("       4. �ܾ� Ȯ��");
		System.out.println("       0. ��      ��");
		System.out.println("========================");
		System.out.print  ("      > ���� : ");
	}
	


}
