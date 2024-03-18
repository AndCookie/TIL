/* 
 * 수정 순서
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
				System.out.println("** 프로그램을 종료합니다.");
				keyin.close();
				return;
			default:
				System.out.println("err> 메뉴를 다시 선택해주세요");
			}
		}
	}

	private void create() {
		System.out.println("\n[ 회원 가입 ]");
		
		String id;
		String name;
		double height;
		double weight;
		
//		if (service.getCount() >= FitnessService.MAX) {
//			System.out.println("** 회원가입을 하실 수 없습니다.");
//			return;
//		}
		// ArrayList는 길이 제한 없으므로 필요 ㄴㄴ!! ===============================
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		// 아이디 중복체크
		Fitness fitness = service.selectOne(id);
		if(fitness != null) {
			System.out.println("err> 중복된 아이디가 있습니다.");
			return;
		}
		
		try {
			System.out.print("* 이 름: ");
			name = keyin.next();
			
			System.out.print("* 키(cm): ");
			height = keyin.nextDouble();
			
			System.out.print("* 몸무게(Kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요\n");
			keyin.nextLine(); // 버퍼를 비우는 역할
			return;
		}
		
		boolean result = service.insert(new Fitness(id, name, height, weight));
		
		if(result)
			System.out.println("** 회원가입이 완료되었습니다.");
		else
			System.out.println("** 회원가입 실패");
	}

	private void retrieve() {
		System.out.println("\n[ 회원 조회 ]");
		
		String id;
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** 입력한 ID의 회원이 없습니다.");
			return;
		}
		System.out.println(fitness);
	}

	// 정보 수정
	private void modify() {
		System.out.println("\n[ 정보 수정 ]");
		
		String id;
		double height;
		double weight;

		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** 입력한 아이디의 회원이 없습니다.");
			return;
		}
		
		try {
			System.out.print("* 키(cm): ");
			height = keyin.nextDouble();
			
			System.out.print("* 몸무게(Kg): ");
			weight = keyin.nextDouble();
		} catch(Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요\n");
			keyin.nextLine();
			return;
		}
		boolean result = service.update(new Fitness(id, null, height, weight));
		
		if(result) 
			System.out.println("** 회원의 정보가 수정되었습니다.");
		else
			System.out.println("** 회원의 정보 수정 실패");
	}

	private void delete() {
		System.out.println("\n[ 회원 탈퇴 ]");
		String id;
		String answer;
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if(fitness == null) {
			System.out.println("** 입력하신 회원이 없습니다.");
			return;
		}
		
		System.out.print("** 정말로 탈퇴하시나요? (y/n) ");
		answer = keyin.next();
		
		if(!answer.equals("y")) {
			System.out.println("** 탈퇴 작업이 취소되었습니다.");
			return;
		}
	
		boolean result = service.delete(id);
		
		if(result) 
			System.out.println("** 회원 탈퇴가 완료되었습니다.");
		else 
			System.out.println("** 탈퇴작업 실패");
	}

	private void selectAll() {
		System.out.println("\n[ 전체 조회 ]");
		
//		int count = service.getCount(); =============
//		Fitness[] list = service.selectAll(); =============
		List<Fitness> list = service.selectAll(); // List<Fitness>로 반환
		
		if(list.size() == 0) {
			System.out.println("** 가입한 회원이 한 명도 없습니다.");
			return ;
		}
		
//		for (int i=0; i<count; ++i) {
//			System.out.println(list[i]); // .toString() 생략해도 자동으로 붙여줌
//		}
		// iterator 로 수정하여 전체 순회
		Iterator<Fitness> iter = list.iterator();
		
		// iterator 생성하여 순회할 때마다 get으로 추출
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}			

	}

	public void menu() {
		System.out.println("===[XX 센터 회원관리]===");
		System.out.println("    1) 회원 가입");
		System.out.println("    2) 정보 조회");
		System.out.println("    3) 정보 수정");
		System.out.println("    4) 탈     퇴");
		System.out.println("    5) 전체 조회");
		System.out.println("    0) 종     료");
		System.out.println("========================");
		System.out.print  ("        선택 > ");
	}
}