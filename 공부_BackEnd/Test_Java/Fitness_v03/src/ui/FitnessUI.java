package ui;

import java.util.Scanner;

import service.FitnessService;
import service.FitnessServiceImpl;
import vo.Fitness;

// 입출력만 수행하도록 함
public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
	FitnessService service = new FitnessServiceImpl(); // 다형성
	// 부모 Service가 자식ServiceImpl을 참조
	
	// 처리는 Serivce가 하므로 여기서는 따로 처리하는 것은 없음
	// 생성자
	public FitnessUI() {
		String choice;
		while (true) {
			menu();
			choice = keyin.next();
			// choice = keyin.nextInt(); 로 받으면 사용자가 정수가 아닌 것으로 잘못 입력했을 경우 오류 발생함
			
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : retrieve(); break;
			case "3" : modify(); break;
			case "4" : delete(); break;
			case "5" : selectAll(); break;
			case "0" :
				System.out.println("**프로그램을 종료합니다.");
				keyin.close();
				return;
			default :
				System.out.println("err> 메뉴를 다시 선택해주세요");
			}
		}
	}
	
	
	private void create() {
		System.out.println("\n[ 회원 가입 ]");
		String id;
		String name;
		double height =0;
		double weight =0;
		
		if (service.getCount() >= FitnessService.MAX) { // service.Max로 쓰지 않음.
			// FitnessService에 생성된 상수는 클래스변수이기 때문
			System.out.println("** 정원 마감으로 회원가입을 하실 수 없습니다.");
			return;
		}
		
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		// 아이디 중복 체크
		Fitness fitness = service.selectOne(id);
		if (fitness!=null) {
			System.out.println("err> 중복된 아이디가 있습니다.");
			return;
		}
		
		try {
			System.out.print("* 이  름: ");
			name = keyin.next();
			System.out.print("* 키(cm): ");
			height = keyin.nextDouble();
			System.out.print("* 몸무게(kg): ");
			weight = keyin.nextDouble();
		} catch (Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요");
			keyin.nextLine(); // 잘못 입력되어 입력 버퍼에 남아있는 것은 클리어하기!!
			return;
		}
		
		// 객체 생성
		boolean result = service.insert(new Fitness(id, name, height, weight));
		
		if(result)
			System.out.println("** 회원가입이 완료되었습니다.");
		else
			System.out.println("** 회원가입 실패");
	}


	private void retrieve() {
		System.out.println("\n[ 정보 조회 ]");
		String id;
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		if (fitness==null) {
			System.out.println("** 입력한 ID의 회원은 없습니다.");
			return;
		} else
			System.out.println(fitness);
	}


	private void modify() {
		System.out.println("\n[ 정보 수정 ]");
		String id;
		double height = 0 ;
		double weight = 0 ;
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness == null) {
			System.out.println("** 입력한 아이디의 회원이 없습니다.");
			return;
		}
		
		try {
			System.out.print("* 키(cm): ");
			height = keyin.nextDouble();
			System.out.print("* 몸무게(kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요");
			keyin.nextLine(); // 잘못 입력되어 입력 버퍼에 남아있는 것은 클리어하기!!
			return;
		}
			
		// 새로운 키와 몸무게 입력 (bmi도 업데이트될 것)
		// 객체 생성
		boolean result = service.update(new Fitness(id, null, height, weight)); // 이름은 안보낸다는 의미
		
		if (result)
			System.out.println("** 회원의 정보가 수정되었습니다.");
		else
			System.out.println("** 회원의 정보 수정 실패");
	}


	private void delete() {
		System.out.println("\n[ 회원 탈퇴 ]");
		String id;
		String answer; // 탈퇴 의사 재확인
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness==null) {
			System.out.println("** 입력하신 ID의 회원이 없습니다.");
			return;
		} else {
			System.out.println("** 정말로 탈퇴하시겠습니까? (y/n)");
			answer = keyin.next();
			if (!answer.equals("y")) {
				System.out.println("** 탈퇴가 거부되었습니다.");
			} else {
				// 객체 생성
				boolean result = service.delete(id); // 이름은 안보낸다는 의미
				
				if (result)
					System.out.println("** 회원 탈퇴가 완료되었습니다.");
				else
					System.out.println("** 탈퇴 작업이 취소되었습니다.");
				}
		}
	}


	private void selectAll() {
		System.out.println("\n[ 전체 조회 ]");
		
		int count = service.getCount();
		// 회원이 없는 경우 전체 조회 불가
		if (count==0) {
			System.out.println("err> 가입한 회원이 한 명도 없습니다.");
			return;
		}
		
		Fitness[] list = service.selectAll();
		for (int i=0; i<count; ++i) {
			System.out.println(list[i]); // .toString() 생략해도 자동으로 붙여줌
		}
		
	}
	
	


	public void menu() {
		System.out.println("=====[선재 센터 회원관리]=====");
		System.out.println("     1) 회원 가입");
		System.out.println("     2) 정보 조회");
		System.out.println("     3) 정보 수정");
		System.out.println("     4) 탈      퇴");
		System.out.println("     5) 전체 조회");
		System.out.println("     0) 종      료");
		System.out.println("=========================");
		System.out.println("         선택 > ");
	}
	
	
}
