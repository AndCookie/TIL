package Bank;
// BankAccountTest에 이미 main이 있으므로 BankAccountSerive에는 main이 필요없음!
// ================== 클래스 다이어그램 =================
// main ----> service ----> BankAccount
// main이 service를 실행하고, service가 bankaccount를 실행하는 구조
// service : 기능을 갖고 운영함.
// bankaccount : 데이터를 갖고 있음.

import java.util.Scanner;

public class BankAccountService {
	Scanner keyin = new Scanner(System.in);
	// Scanner는 우리 멤버라고 보기 어렵다. 그저 운영을 위한 것
	BankAccount bank; // null
	// 고객의 정보가 지역변수이면 메뉴 실행시 활용할 수 없으므로 전역변수로 만들어야 함
	// 지역변수는 자동으로 초기화됨!! // 단 기본형이 아닌 참조형은 전부 다 null로 초기화됨
	// stack 영역에 bank라는 네모 상자에 BankAccount라는 타입의 null이 들어있는 것이고
	// heap 영역에는 아직 아무것도 가리키지 않는 
	
	public BankAccountService() {
		// 생성자처럼 초기화 시키는 것이 아니라 무언가를 실행하는 역할을 함
//		System.out.println("서비스클래스 생성자");
		// 숫자보다 문자열로 받는 것이 나음. 숫자는 잘못 입력시 에러 나는데, 문자열은 잘못 입력 받더라도 다시 입력 가능하므로
		String choice; // 초기화되지 않은 지역변수 // 초기화 안됨!!!
		
		while (true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : deposit(); break; // BankAccount의 deposit, withdraw과는 완전히 다른,
			case "3" : withdraw(); break;// BankAccountService의 소속의 deposit()과 withdraw()
			case "4" : output(); break;
			// 그냥 output()만 적는다면 BankAccount가 아닌 BankAccountService의 소속
			// bank.output()이면 BankAccount의 소속
			case "0" : System.out.println("** 프로그램을 종료합니다.");
					   return;
					   // return시 자기를 호출했던 쪽으로 즉, 생성자로 돌아감
					   // : public BankAccountService() => BankAccountService service = new BankAccountService();
					   // 중괄호에 걸려 끝남 => main이 닫혔다는 것은 프로그램이 종료되었다는 의미
			default : System.out.println("> 오류 : 메뉴를 다시 선택하시오\n");
//					   continue; // default이므로 어차피 아래의 중괄호에 걸려서 while로 다시 돌아감
			}
			
		}
		
	}
	
	// /**+엔터 :문서 주석
	
	/**
	 * 출금
	 */
	private void withdraw() {
		System.out.println("\n[ 출       금 ]");
		int money;
		
		if (bank==null) { // 계좌가 아직 개설이 안되었다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
		}
		
		System.out.print("* 출금액: ");
		money = keyin.nextInt();
		
		if (money>bank.getBalance()) {
			System.out.println("** 잔액이 부족합니다");
			return;
		} else {
			System.out.println("** 출금 완료");
			bank.withdraw(money);
			System.out.println(bank.getBalance());
		}
		// 반환된 값이 0이면 "** 잔액이 부족합니다."
		// 아니라면 "** 출금 완료" 메세지 보내주고 getter를 이용하여 현재 잔액 출력해주기
	}

	/**
	 * 입금
	 */
	private void deposit() {
		System.out.println("\n[ 입       금 ]");
		int money;
		
		// 계좌가 없는 상태에서 입출금 실행시 NullPointException의 오류가 발생함
		if (bank==null) { // 계좌가 아직 개설이 안되었다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
		}
		
		System.out.print("* 입금액: ");
		money = keyin.nextInt();
		
		int result = bank.deposit(money);
		if (result<=0) {
			System.out.println("** 금액을 정확히 입력해주세요");
			return;
		} else {
			System.out.println("** 입금 완료");
			System.out.println(bank.getBalance());
		}
		// 반환된 값이 0이면 입금이 안되었다는 메시지 보내고 반환 "** 금액을 정확히 입력해주세요"
		// 아니라면 "** 입금 완료" 메세지 보내주고 getter를 이용하여 현재 잔액을 출력해주기
	}

	/**
	 * 계좌 정보 출력
	 */
	private void output() {
		System.out.println("\n[ 잔액 확인 ]");
		if (bank==null) { // 계좌가 아직 개설이 안되었다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
		}
		bank.output();
	}
	/**
	 * 고객의 계좌변호, 이름, 잔액을 입력받아 계좌를 개설한다.
	 */
	private void create() {
		String accountNo;
		String accountName;
		int balance;
	
		System.out.println("[ 계좌 개설 ]");
		if (bank!=null) {
			System.out.println("** 계좌 개설이 어렵습니다.");
			return;
			// private void create()를 호출했던
			// switch(choice) {case "1" : create(); break; 로 돌아간 후
			// while(true)의 menu()를 띄우는 것
		} else {
			System.out.print("* 계좌변호: ");
			accountNo = keyin.next();
			System.out.print("* 계좌주명: ");
			accountName = keyin.next();
			System.out.print("* 입금액: ");
			balance = keyin.nextInt();	
		}
		
		// 생성자를 통해 메모리에 올리기
		bank = new BankAccount(accountNo, accountName, balance); //ctrl+space
		System.out.println("** 계좌 개설이 완료되었습니다.");
		return;
		
		// 중괄호를 만나서 끝나면 자동으로 menu로 돌아감
	}
	
	private void menu() {
		System.out.println();
		System.out.println("=== [선재은행 ATM 서비스] ===");
		System.out.println("       1. 계좌 개설");
		System.out.println("       2. 입      금");
		System.out.println("       3. 출      금");
		System.out.println("       4. 잔액 확인");
		System.out.println("       0. 종      료");
		System.out.println("========================");
		System.out.print  ("      > 선택 : ");
	}
	


}
