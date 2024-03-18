package bank_v3;
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
    // BankAccount bank; // null
	BankAccount[] bank = new BankAccount[5]; // �ִ� 5����� �Է¹��� �� ����
	// ���� ������ ���������̸� �޴� ����� Ȱ���� �� �����Ƿ� ���������� ������ ��
	// ���������� �ڵ����� �ʱ�ȭ��!! // �� �⺻���� �ƴ� �������� ���� �� null�� �ʱ�ȭ��
	// stack ������ bank��� �׸� ���ڿ� BankAccount��� Ÿ���� null�� ����ִ� ���̰�
	// heap �������� ���� �ƹ��͵� ����Ű�� �ʴ� 5���� null �ڽ��� �ִ� ��
	int count=0;
	
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
			case "4" : retrieve(); break;
			case "5" : output(); break;
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
	 * Ư�� �� ���� ��ȸ
	 */
	private void retrieve() {
		System.out.println("\n[ Ư�� �� ���� Ȯ�� ]");
		String accountNo; // ��ȸ�� ���� ��ȣ �Է�
		
//		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
		if (count==0) { // ���� ���� �� �� ���ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
			// output�� ȣ���ߴ� switch�� ���ư�
		} 
		
		// ��ȸ�� ���¹�ȣ�� �Է� �޴´�
		System.out.print("* ��ȸ ���¹�ȣ: ");
		accountNo = keyin.next(); // ���¹�ȣ�� "7"�� �Է¹޾Ҵٰ� ���� �� �ߺ� ���� Ȯ���ϱ�
		for (int i=0; i<count; ++i) { // length�� �ƴ� count�� �����!
			// ���¹�ȣ�� ã������ �Ա�
			if (bank[i].getAccountNo().equals(accountNo)) {
				// ���ڿ��� (==:�ּҰ� ��)�� �ƴ϶� equals(������ ��)�� ���ؾ� ��
				// �� ���� ���¹�ȣ�� ��� �Է¹��� ���¹�ȣ("7")�� ������ �Ա� ����!!
				bank[i].output();
				return; // ��ȸ ���� �� ����
				// if�� �ƴ� for�� ��� "���¹�ȣ�� �߸��Ǿ����ϴ�"��  �Ѿ�� ��
			}
		}
		System.out.println("> ���¹�ȣ�� �߸��Ǿ����ϴ�");
		return; // ��ȸ ���� �� ����
	}


	/**
	 * ���
	 */
	private void withdraw() {
		System.out.println("\n[ ��       �� ]");
		int money; // ����� �ݾ�
		String accountNo; // ����� ���¹�ȣ
		int position = -1; // ã�� ���¹�ȣ�� ��ġ�� : -1�̸� ���¸� ��ã�� �ɷ�!
		
//		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
		if (count==0) { // ���� ���� �� �� ���ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
			// output�� ȣ���ߴ� switch�� ���ư�
		}
		
		// �Ա��� ���¹�ȣ�� �Է� �޴´�
		System.out.print("* ��� ���¹�ȣ: ");
		accountNo = keyin.next(); // ���¹�ȣ�� "7"�� �Է¹޾Ҵٰ� ���� �� �ߺ� ���� Ȯ���ϱ�
		for (int i=0; i<count; ++i) { // length�� �ƴ� count�� �����!
			BankAccount temp = bank[i]; // ���¹�ȣ, �����ָ�, �ܾ� �� ���� �������
			// ���¹�ȣ�� ã������ �Ա�
			if (temp.getAccountNo().equals(accountNo)) {
				// ���ڿ��� (==:�ּҰ� ��)�� �ƴ϶� equals(������ ��)�� ���ؾ� ��
				// �� ���� ���¹�ȣ�� ��� �Է¹��� ���¹�ȣ("7")�� ������ �Ա� ����!!
				position = i; // ã�� ������ ��ġ�� ����
				break;
				// if�� �ƴ� for�� ��� "���¹�ȣ�� �߸��Ǿ����ϴ�"��  �Ѿ�� ��
			}
		}
		
		// position(ã�� ���¹�ȣ�� ��ġ��)�� �߿�
		if (position == -1) { // ���¹�ȣ�� ��ã�Ҵٴ� �ǹ�
			System.out.println("> ���¹�ȣ�� �߸��Ǿ����ϴ�");
			return; // ��� ���� �� ����
		} else { // ���¹�ȣ�� ã�Ҵٴ� �ǹ�
			// �ݾ��� �Է¹޾� ���
			System.out.println("** �󸶸� ����Ͻðڽ��ϱ�?");
			money = keyin.nextInt();
			int result = bank[position].withdraw(money);
			if (result<=0) {
				System.out.println("> �ݾ��� ��Ȯ�� �Է����ּ���");
				return;
			} else {
				System.out.println("** ��� �Ϸ�");
				System.out.println("** ��� �� �ܾ�: " + bank[position].getBalance());
				return; // ��� ���� �� ����
			}	
		}
	}


	/**
	 * �Ա�
	 * for������ ���¹�ȣ �ϳ��� ������ ��� ��
	 * ������ ** ���¹�ȣ�� �߸��Ǿ����ϴ� // ã������ �Աݽ�Ű��
	 */
	private void deposit() {
		System.out.println("\n[ ��       �� ]");
		int money; // �Ա��� �ݾ�
		String accountNo; // �Ա��� ���¹�ȣ
		int position = -1; // ã�� ���¹�ȣ�� ��ġ�� : -1�̸� ���¸� ��ã�� �ɷ�!
		
//		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
		if (count==0) { // ���� ���� �� �� ���ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
			// output�� ȣ���ߴ� switch�� ���ư�
		}
		
		// �Ա��� ���¹�ȣ�� �Է� �޴´�
		System.out.print("* �Ա� ���¹�ȣ: ");
		accountNo = keyin.next(); // ���¹�ȣ�� "7"�� �Է¹޾Ҵٰ� ���� �� �ߺ� ���� Ȯ���ϱ�
		for (int i=0; i<count; ++i) { // length�� �ƴ� count�� �����!
			BankAccount temp = bank[i]; // ���¹�ȣ, �����ָ�, �ܾ� �� ���� �������
			// ���¹�ȣ�� ã������ �Ա�
			if (temp.getAccountNo().equals(accountNo)) {
				// ���ڿ��� (==:�ּҰ� ��)�� �ƴ϶� equals(������ ��)�� ���ؾ� ��
				// �� ���� ���¹�ȣ�� ��� �Է¹��� ���¹�ȣ("7")�� ������ �Ա� ����!!
				position = i; // ã�� ������ ��ġ�� ����
				break;
				// if�� �ƴ� for�� ��� "���¹�ȣ�� �߸��Ǿ����ϴ�"��  �Ѿ�� ��
			}
		}
		
		// position(ã�� ���¹�ȣ�� ��ġ��)�� �߿�
		if (position == -1) { // ���¹�ȣ�� ��ã�Ҵٴ� �ǹ�
			System.out.println("> ���¹�ȣ�� �߸��Ǿ����ϴ�");
			return; // �Ա� ���� �� ����
		} else { // ���¹�ȣ�� ã�Ҵٴ� �ǹ�
			// �ݾ��� �Է¹޾� �Ա�
			System.out.println("** �󸶸� �Ա��Ͻðڽ��ϱ�?");
			money = keyin.nextInt();
			int result = bank[position].deposit(money);
			if (result<=0) {
				System.out.println("> �ݾ��� ��Ȯ�� �Է����ּ���");
				return;
			} else {
				System.out.println("** �Ա� �Ϸ�");
				System.out.println("** �Ա� �� �ܾ�: " + bank[position].getBalance());
				return; // �Ա� ���� �� ����
			}	
		}
	}
	

	/**
	 * ��ü �� ���� ���
	 */
	private void output() {
		System.out.println("\n[ ��ü �� ���� Ȯ�� ]");
//		if (bank==null) { // ���°� ���� ������ �ȵǾ��ٸ�
		if (count==0) { // ���� ���� �� �� ���ٸ�
			System.out.println("> ���°����� �ȵǾ� �ֽ��ϴ�.");
			return;
			// output�� ȣ���ߴ� switch�� ���ư�
		} else {
			for (int i=0; i<count; ++i) {
				bank[i].output();
			}
		}
	}
	
	/**
	 * ���� ���¹�ȣ, �̸�, �ܾ��� �Է¹޾� ���¸� �����ϵ�
	 * count�� 5���� ���� ��쿡�� ���� (5�� ���ϸ� ��� �����ϹǷ�)
	 * ������ ���¹�ȣ�δ� ���� ���� �Ҵ�
	 */
	private void create() {
		String accountNo;
		String accountName;
		int balance;
	
		System.out.println("\n[ ���� ���� ]");
		if (count>=bank.length) {
			System.out.println("** ���� ������ ��ƽ��ϴ�.");
			return;
			// private void create()�� ȣ���ߴ�
			// switch(choice) {case "1" : create(); break; �� ���ư� ��
			// while(true)�� menu()�� ���� ��
		} else { // ���¸� �����ϱ� ���� �Է��� �޴´�
			System.out.print("* ���¹�ȣ: ");
			accountNo = keyin.next(); // ���¹�ȣ�� "7"�� �Է¹޾Ҵٰ� ���� �� �ߺ� ���� Ȯ���ϱ�
			for (int i=0; i<count; ++i) { // length�� �ƴ� count�� �����!
				BankAccount temp = bank[i]; // ���¹�ȣ, �����ָ�, �ܾ� �� ���� �������
				if (temp.getAccountNo().equals(accountNo)) {
					// ���ڿ��� (==:�ּҰ� ��)�� �ƴ϶� equals(������ ��)�� ���ؾ� ��
					// �� ���� ���¹�ȣ�� ��� �Է¹��� ���¹�ȣ("7")�� ������ �ȵ�!!
					System.out.println("> ���¹�ȣ�� �߸��Ǿ����ϴ�");
					return;
				}
			}
			System.out.print("* �����ָ�: ");
			accountName = keyin.next();
			System.out.print("* �Աݾ�: ");
			balance = keyin.nextInt();	
			// ������ �����͸� ��ü�� ��ȯ�� ������ �޸𸮿� �÷��� ��!!! (�Ʒ� �ܰ� ����)
		}
		
		// �����ڸ� ���� �޸𸮿� �ø���
		bank[count] = new BankAccount(accountNo, accountName, balance); //ctrl+space
		// bank�� count�� �濡 ���� �Ǵ� ��
		++count; // ���� �� �� �þ ��
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
		System.out.println("       4. Ư�� ���� ��ȸ");
		System.out.println("       5. ��ü ���� ��ȸ");
		System.out.println("       0. ��      ��");
		System.out.println("========================");
		System.out.print  ("      > ���� : ");
	}
	


}
