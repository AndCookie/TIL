package bank_v3;
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
    // BankAccount bank; // null
	BankAccount[] bank = new BankAccount[5]; // 최대 5명까지 입력받을 수 있음
	// 고객의 정보가 지역변수이면 메뉴 실행시 활용할 수 없으므로 전역변수로 만들어야 함
	// 지역변수는 자동으로 초기화됨!! // 단 기본형이 아닌 참조형은 전부 다 null로 초기화됨
	// stack 영역에 bank라는 네모 상자에 BankAccount라는 타입의 null이 들어있는 것이고
	// heap 영역에는 아직 아무것도 가리키지 않는 5개의 null 박스가 있는 것
	int count=0;
	
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
			case "4" : retrieve(); break;
			case "5" : output(); break;
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
	 * 특정 고객 계좌 조회
	 */
	private void retrieve() {
		System.out.println("\n[ 특정 고객 계좌 확인 ]");
		String accountNo; // 조회할 계좌 번호 입력
		
//		if (bank==null) { // 계좌가 아직 개설이 안되었다면
		if (count==0) { // 아직 고객이 한 명도 없다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
			// output을 호출했던 switch로 돌아감
		} 
		
		// 조회할 계좌번호를 입력 받는다
		System.out.print("* 조회 계좌번호: ");
		accountNo = keyin.next(); // 계좌번호로 "7"을 입력받았다고 가정 후 중복 여부 확인하기
		for (int i=0; i<count; ++i) { // length가 아닌 count를 써야함!
			// 계좌번호를 찾았으면 입금
			if (bank[i].getAccountNo().equals(accountNo)) {
				// 문자열은 (==:주소값 비교)가 아니라 equals(실제값 비교)로 비교해야 함
				// 각 방의 계좌번호와 방금 입력받은 계좌번호("7")이 같으면 입금 성공!!
				bank[i].output();
				return; // 조회 성공 후 리턴
				// if가 아닌 for을 벗어나 "계좌번호가 잘못되었습니다"로  넘어가게 됨
			}
		}
		System.out.println("> 계좌번호가 잘못되었습니다");
		return; // 조회 실패 후 리턴
	}


	/**
	 * 출금
	 */
	private void withdraw() {
		System.out.println("\n[ 출       금 ]");
		int money; // 출금할 금액
		String accountNo; // 출금할 계좌번호
		int position = -1; // 찾은 계좌번호의 위치값 : -1이면 계좌를 못찾은 걸로!
		
//		if (bank==null) { // 계좌가 아직 개설이 안되었다면
		if (count==0) { // 아직 고객이 한 명도 없다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
			// output을 호출했던 switch로 돌아감
		}
		
		// 입금할 계좌번호를 입력 받는다
		System.out.print("* 출금 계좌번호: ");
		accountNo = keyin.next(); // 계좌번호로 "7"을 입력받았다고 가정 후 중복 여부 확인하기
		for (int i=0; i<count; ++i) { // length가 아닌 count를 써야함!
			BankAccount temp = bank[i]; // 계좌번호, 계좌주명, 잔액 세 개가 들어있음
			// 계좌번호를 찾았으면 입금
			if (temp.getAccountNo().equals(accountNo)) {
				// 문자열은 (==:주소값 비교)가 아니라 equals(실제값 비교)로 비교해야 함
				// 각 방의 계좌번호와 방금 입력받은 계좌번호("7")이 같으면 입금 성공!!
				position = i; // 찾은 계좌의 위치를 저장
				break;
				// if가 아닌 for을 벗어나 "계좌번호가 잘못되었습니다"로  넘어가게 됨
			}
		}
		
		// position(찾은 계좌번호의 위치값)이 중요
		if (position == -1) { // 계좌번호를 못찾았다는 의미
			System.out.println("> 계좌번호가 잘못되었습니다");
			return; // 출금 실패 후 리턴
		} else { // 계좌번호를 찾았다는 의미
			// 금액을 입력받아 출금
			System.out.println("** 얼마를 출금하시겠습니까?");
			money = keyin.nextInt();
			int result = bank[position].withdraw(money);
			if (result<=0) {
				System.out.println("> 금액을 정확히 입력해주세요");
				return;
			} else {
				System.out.println("** 출금 완료");
				System.out.println("** 출금 후 잔액: " + bank[position].getBalance());
				return; // 출금 성공 후 리턴
			}	
		}
	}


	/**
	 * 입금
	 * for문으로 계좌번호 하나씩 꺼내서 물어본 후
	 * 없으면 ** 계좌번호가 잘못되었습니다 // 찾았으면 입금시키기
	 */
	private void deposit() {
		System.out.println("\n[ 입       금 ]");
		int money; // 입금할 금액
		String accountNo; // 입금할 계좌번호
		int position = -1; // 찾은 계좌번호의 위치값 : -1이면 계좌를 못찾은 걸로!
		
//		if (bank==null) { // 계좌가 아직 개설이 안되었다면
		if (count==0) { // 아직 고객이 한 명도 없다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
			// output을 호출했던 switch로 돌아감
		}
		
		// 입금할 계좌번호를 입력 받는다
		System.out.print("* 입금 계좌번호: ");
		accountNo = keyin.next(); // 계좌번호로 "7"을 입력받았다고 가정 후 중복 여부 확인하기
		for (int i=0; i<count; ++i) { // length가 아닌 count를 써야함!
			BankAccount temp = bank[i]; // 계좌번호, 계좌주명, 잔액 세 개가 들어있음
			// 계좌번호를 찾았으면 입금
			if (temp.getAccountNo().equals(accountNo)) {
				// 문자열은 (==:주소값 비교)가 아니라 equals(실제값 비교)로 비교해야 함
				// 각 방의 계좌번호와 방금 입력받은 계좌번호("7")이 같으면 입금 성공!!
				position = i; // 찾은 계좌의 위치를 저장
				break;
				// if가 아닌 for을 벗어나 "계좌번호가 잘못되었습니다"로  넘어가게 됨
			}
		}
		
		// position(찾은 계좌번호의 위치값)이 중요
		if (position == -1) { // 계좌번호를 못찾았다는 의미
			System.out.println("> 계좌번호가 잘못되었습니다");
			return; // 입금 실패 후 리턴
		} else { // 계좌번호를 찾았다는 의미
			// 금액을 입력받아 입금
			System.out.println("** 얼마를 입금하시겠습니까?");
			money = keyin.nextInt();
			int result = bank[position].deposit(money);
			if (result<=0) {
				System.out.println("> 금액을 정확히 입력해주세요");
				return;
			} else {
				System.out.println("** 입금 완료");
				System.out.println("** 입금 후 잔액: " + bank[position].getBalance());
				return; // 입금 성공 후 리턴
			}	
		}
	}
	

	/**
	 * 전체 고객 계좌 출력
	 */
	private void output() {
		System.out.println("\n[ 전체 고객 계좌 확인 ]");
//		if (bank==null) { // 계좌가 아직 개설이 안되었다면
		if (count==0) { // 아직 고객이 한 명도 없다면
			System.out.println("> 계좌개설이 안되어 있습니다.");
			return;
			// output을 호출했던 switch로 돌아감
		} else {
			for (int i=0; i<count; ++i) {
				bank[i].output();
			}
		}
	}
	
	/**
	 * 고객의 계좌번호, 이름, 잔액을 입력받아 계좌를 개설하되
	 * count가 5보다 작은 경우에만 가능 (5명 이하만 등록 가능하므로)
	 * 동일한 계좌번호로는 계좌 개설 불능
	 */
	private void create() {
		String accountNo;
		String accountName;
		int balance;
	
		System.out.println("\n[ 계좌 개설 ]");
		if (count>=bank.length) {
			System.out.println("** 계좌 개설이 어렵습니다.");
			return;
			// private void create()를 호출했던
			// switch(choice) {case "1" : create(); break; 로 돌아간 후
			// while(true)의 menu()를 띄우는 것
		} else { // 계좌를 생성하기 위해 입력을 받는다
			System.out.print("* 계좌번호: ");
			accountNo = keyin.next(); // 계좌번호로 "7"을 입력받았다고 가정 후 중복 여부 확인하기
			for (int i=0; i<count; ++i) { // length가 아닌 count를 써야함!
				BankAccount temp = bank[i]; // 계좌번호, 계좌주명, 잔액 세 개가 들어있음
				if (temp.getAccountNo().equals(accountNo)) {
					// 문자열은 (==:주소값 비교)가 아니라 equals(실제값 비교)로 비교해야 함
					// 각 방의 계좌번호와 방금 입력받은 계좌번호("7")이 같으면 안됨!!
					System.out.println("> 계좌번호가 잘못되었습니다");
					return;
				}
			}
			System.out.print("* 계좌주명: ");
			accountName = keyin.next();
			System.out.print("* 입금액: ");
			balance = keyin.nextInt();	
			// 각각의 데이터를 객체로 변환한 다음에 메모리에 올려야 함!!! (아래 단계 참조)
		}
		
		// 생성자를 통해 메모리에 올리기
		bank[count] = new BankAccount(accountNo, accountName, balance); //ctrl+space
		// bank의 count번 방에 들어가게 되는 것
		++count; // 고객이 한 명 늘어난 것
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
		System.out.println("       4. 특정 계좌 조회");
		System.out.println("       5. 전체 계좌 조회");
		System.out.println("       0. 종      료");
		System.out.println("========================");
		System.out.print  ("      > 선택 : ");
	}
	


}
