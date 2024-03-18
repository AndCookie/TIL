package master.ui;

import java.util.Scanner;

import master.service.ScoreService;
import master.service.ScoreServiceImpl;
import master.vo.Student;

public class ScoreUI {
	Scanner keyin = new Scanner(System.in);
	ScoreService service = new ScoreServiceImpl(); // 다형성

	// 처리는 Serivce가 하므로 여기서는 따로 처리하는 것은 없음
	// 생성자
	public ScoreUI() {
		while (true) {
			menu();
			String choice;
			choice = keyin.next();

			switch(choice) {
			case "1" : regist(); break; // 성적 등록
			case "2" : retrieve(); break; // 성적 조회
			case "3" : retrieveAll(); break; // 전체 성적 조회
			case "4" : delete(); break; // 삭제
			case "5" : modify(); break; // 수정
			case "6" : scoreAnaly(); break; // 성적 통계 조회
			case "0" : // 종료
				System.out.println("** 프로그램을 종료합니다.");
				return;
			default : 
				System.out.println("** 메뉴를 다시 선택해주세요");
			}
		}
	}

	private void regist() {
		System.out.println("\n[ 성적 등록 ]");
		String stdid;
		String stdname;
		double it;
		double language;
		double basic;

		if (service.getCount() >= ScoreService.MAX) { // service.Max로 쓰지 않음.
			// ScoreService에 생성된 상수는 클래스변수이기 때문
			System.out.println("** 인원 초과로 인한 성적 등록 불가");
			return;
		}

		System.out.print("* 학번: ");
		stdid = keyin.next();

		// 아이디 중복 체크
		Student student = service.selectOne(stdid);
		if (student!=null) {
			System.out.println("err> 중복된 아이디가 있습니다.");
			return;
		}

		System.out.print("* 이름: ");
		stdname = keyin.next();
		System.out.print("* IT: ");
		it = keyin.nextDouble();
		System.out.print("* 외국어: ");
		language = keyin.nextDouble();
		System.out.print("* 베이직: ");
		basic = keyin.nextDouble();

		// 객체 생성
		boolean result = service.insert(new Student(stdid, stdname, it, language, basic));

		if(result)
			System.out.println("** 성적 등록 완료");
		else
			System.out.println("** 성적 등록 실패");
	}


	private void retrieve() {
		System.out.println("\n[ 성적 조회 ]");
		String stdid;
		System.out.print("* 학번: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);
		if (student==null) {
			System.out.println("** 입력한 학번의 학생은 없습니다.");
			return;
		} else
			System.out.println(student);
	}


	private void retrieveAll() {
		System.out.println("\n[ 전체 성적 조회 ]");
		int count = service.getCount();
		// 회원이 없는 경우 전체 조회 불가
		if (count==0) {
			System.out.println("err> 등록된 학생이 한 명도 없습니다.");
			return;
		}

		Student[] list = service.selectAll();
		for (int i=0; i<count; ++i) {
			System.out.println(list[i]); // .toString() 생략해도 자동으로 붙여줌
		}
	}

	private void delete() {
		System.out.println("\n[ 삭제 ]");
		String stdid;
		String answer; // 삭제 의사 재확인

		System.out.print("* 학번: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);

		if (student==null) {
			System.out.println("** 입력하신 학번의 학생이 없습니다.");
			return;
		} else {
			System.out.println("** 정말로 삭제하시겠습니까? (y/n)");
			answer = keyin.next();
			if (!answer.equals("y")) {
				System.out.println("** 삭제가 거부되었습니다.");
			} else {
				// 객체 생성
				boolean result = service.delete(stdid); // 이름은 안보낸다는 의미

				if (result)
					System.out.println("** 삭제가 완료되었습니다.");
				else
					System.out.println("** 삭제 작업이 취소되었습니다.");
			}
		}

	}

	private void modify() {
		System.out.println("\n[ 수정 ]");
		String stdid;
		double it;
		double language;
		double basic;

		System.out.print("* 학번: ");
		stdid = keyin.next();

		Student student = service.selectOne(stdid);

		if (student == null) {
			System.out.println("** 입력하신 학번의 학생이 없습니다.");
			return;
		}

		System.out.print("* IT: ");
		it = keyin.nextDouble();
		System.out.print("* 외국어: ");
		language = keyin.nextDouble();
		System.out.print("* 베이직: ");
		basic = keyin.nextDouble();

		// 새로운 성적 입력 (avg도 업데이트될 것)
		// 객체 생성
		boolean result = service.update(new Student(stdid, null, it, language, basic)); // 이름은 안보낸다는 의미

		if (result)
			System.out.println("** 성적 정보가 수정되었습니다.");
		else
			System.out.println("** 성적 정보 수정 실패");

	}

	private void scoreAnaly() {
		System.out.println("\n[ 성적 통계 조회 ]");

		int count = service.getCount();
		// 회원이 없는 경우 전체 조회 불가
		if (count==0) {
			System.out.println("err> 등록된 학생이 한 명도 없습니다.");
			return;
		}


		double[] list1 = service.scoreAnaly();
		System.out.println("과목별 통계는 아래와 같습니다");
		for (int i=0; i<ScoreService.SUBJECT; ++i) {
			System.out.printf("%.2f%n", list1[i]); // .toString() 생략해도 자동으로 붙여줌
		}
		System.out.println("과목별 평균은 아래와 같습니다");
		for (int j=0; j<ScoreService.SUBJECT; ++j) {
			list1[j] = list1[j]/count;
			System.out.printf("%.2f%n", list1[j]); // .toString() 생략해도 자동으로 붙여줌
		}
	}


	private void menu() {
		System.out.println("=====[MASTER 성적관리]=====");
		System.out.println("     1) 성적 등록");
		System.out.println("     2) 성적 조회");
		System.out.println("     3) 전체 성적 조회");
		System.out.println("     4) 삭      제");
		System.out.println("     5) 수      정");
		System.out.println("     6) 성적 통계 조회");
		System.out.println("     0) 종      료");
		System.out.println("=========================");
		System.out.println("         선택 > ");


	}


}
