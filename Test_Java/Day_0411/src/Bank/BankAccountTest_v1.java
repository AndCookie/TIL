package Bank;

public class BankAccountTest_v1 {
	// 프로그램을 실행하기 위해서는 main이 반드시 있어야 하므로
	// 테스트용 만들때는 무조건 main이 있어야 함
	public static void main(String[] args) {
		// 메소드를 통해서 우회적으로 접근
		// 클래스를 생성해서 사용한다 = 메모리에 올려서 참조한다
		int money = 5000;
		
		
		// 기본 생성자
		BankAccount ba = new BankAccount(); // 생성자 매소드 (Constructor)
		// 여기서 ba는 stack 영역에 만들어지는 지역변수
		// 이때 heap 영역에 만들어지는 것은 '객체'
		ba.output();
		System.out.println("================");
		
		
		// 오버로드된 생성자
		BankAccount bc = new BankAccount("4567", "임꺽정", 50000); // 생성자 매소드 (Constructor)
		// 여기서 ba는 stack 영역에 만들어지는 지역변수
		// 이때 heap 영역에 만들어지는 것은 '객체'
		bc.output();
		System.out.println("================");
		
		
		ba.setAccountNo("1234");
		ba.setAccountName("전우치");
		ba.setBalance(10000);
		
		// 만약 따로 지정을 해두지 않고 바로 ba.output(); 실행시 기본값으로 세팅된 0이 출력됨
		System.out.println(money + "원 입금");
		ba.deposit(money);
		int result = ba.getBalance(); // 입금하지 않고도 잔액확인 가능한 메소드
		// 커서 : 초록색 동그라미=public / Bank=패키지명 / BankAccount=클래그명
		System.out.println("잔액확인 : " + result);
		ba.output();
		
		money = 20000;
		System.out.println();
		System.out.println(money + "원 출금");
		result = ba.withdraw(money);
		System.out.println("결과 : " + result);
		System.out.println("잔액확인 : " + ba.getBalance());
		ba.output();		
		
	}

}
