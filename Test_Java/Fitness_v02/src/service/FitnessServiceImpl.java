package service;

import java.util.Scanner;
import vo.Fitness;

// FitnessService 내의 메소드를 구현 Implement한 서비스 클래스 만들기
// 자식    extends  부모 : 확장
// 하위 implements 상위 : 구현
public class FitnessServiceImpl implements FitnessService {
	Scanner keyin = new Scanner(System.in);
	Fitness[] fitness = new Fitness[50]; // 다른 패키지에 있어서 오류 발생시 ctrl+shift+o
	int count = 0;
	
	// 무언가를 실행하는 역할
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
				System.out.println("**프로그램을 종료합니다.");
				keyin.close();
				return;
			default :
				System.out.println("err> 메뉴를 다시 선택해주세요");
			}
		}
	}
	

	
	@Override
	public boolean insert() {
		System.out.println("\n[ 회원 가입 ]");
		String id;
		String name;
		double height;
		double weight;
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		// 아이디 중복 체크
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) { // fitness[i].toString() 생략해도 자동으로 붙여줌
				System.out.println("err> 중복된 아이디가 있습니다.");
				return false; // boolean insert이기 때문에 return이 아닌 return false
			}
		}
		
		System.out.print("* 이  름: ");
		name = keyin.next();
		System.out.print("* 키(cm): ");
		height = keyin.nextDouble();
		System.out.print("* 몸무게(kg): ");
		weight = keyin.nextDouble();
		
		// 객체 생성
		fitness[count] = new Fitness(id, name, height, weight);
		++count;
		
		System.out.println("** 회원가입이 완료되었습니다.");
		return true;
	}

	
	@Override
	public void read() {
		System.out.println("\n[ 정보 조회 ]");
		String id;
		System.out.print("* 아이디: ");
		id = keyin.next();
		// 회원이 없는 경우
		if (count==0) {
			System.out.println("err> 가입한 회원이 한 명도 없습니다.");
			return;
		}
		// 아이디 일치 확인
		for (int i=0; i<count; ++i) {
			if(fitness[i].getId().equals(id)) {
				System.out.println(fitness[i]); // .toString() 생략해도 자동으로 붙여줌
				return;
			}
		}
		System.out.println("** 입력한 ID의 회원은 없습니다.");
		// return; 생략 가능 : 어차피 아래의 중괄호 만날 거니까
	}

	
	@Override
	public boolean update() {
		System.out.println("\n[ 정보 수정 ]");
		String id;
		double height;
		double weight;
		int position = -1; // 일치하는 회원을 못찾으면 -1을 리턴
		
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) {
				position = i; // for문 밖으로 벗어나면 지역번수인 i를 사용할 수 없으므로
				// for문 안에서 i를 position으로 대입해야지만 밖에서 사용이 가능하다
				break;
			}
		}
		
		if (position == -1) {
			System.out.println("** 입력한 아이디의 회원이 없습니다.");
			return false;
		}
		
		System.out.print("* 키(cm): ");
		height = keyin.nextDouble();
		System.out.print("* 몸무게(kg): ");
		weight = keyin.nextDouble();
		
		// 새로운 키와 몸무게 입력 (bmi도 업데이트될 것)
		fitness[position].setHeight(height);
		fitness[position].setWeight(weight);
		System.out.println("** 회원의 정보가 수정되었습니다.");
		
		return true;
	}

	
	@Override
	public boolean delete() {
		System.out.println("\n[ 회원 탈퇴 ]");
		String id;
		System.out.print("* 아이디: ");
		id = keyin.next();
		
		// position을 넣어서 바꾸기
		// 진짜 탈퇴할 건지 재확인하기
		for (int i=0; i<count; ++i) {
			if (fitness[i].getId().equals(id)) {
				for (int j=i; j<count-1; ++j) { // count-1 : 5번방은 아무것도 없는 null이므로 옮길 것 없음
					fitness[j] = fitness[j+1];
				}
				System.out.println("** 회원 탈퇴가 완료되었습니다.");
				--count;
				return true;
			}
		}	
		System.out.println("** 입력하신 ID의 회원이 없습니다.");
		return false;
	}

	
	@Override
	public void selectAll() {
		System.out.println("\n[ 전체 조회 ]");
		// 회원이 없는 경우 전체 조회 불가
		if (count==0) {
			System.out.println("err> 가입한 회원이 한 명도 없습니다.");
			return;
		}
		for (int i=0; i<count; ++i) {
			System.out.println(fitness[i]); // .toString() 생략해도 자동으로 붙여줌
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
