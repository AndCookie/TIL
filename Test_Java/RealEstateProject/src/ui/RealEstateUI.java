package ui;
// 사용자에게 보내지는 화면
// Scanner로 사용자로부터 입력 받기
// 객체 : 뒷단으로 보내기 위함

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
	
	// 메뉴 3개 만들기
	// 1. 메인메뉴
	public RealEstateUI() {
		while (true) {
			mainMenu();
			String choice;
			choice = keyin.next();
			keyin.nextLine(); // 입력 버퍼에 남아있는 엔터를 지우는 작업 수행
			
			switch (choice) {
			case "1" : regist(); break; // 등록
			case "2" : retrieve(); break; // 검색 
			case "3" : modify(); break; // 수정
			case "4" : delete(); break; // 삭제
			case "5" : retrieveAll(); break; // 전체출력
			case "0" : 
				System.out.println("** 프로그램을 종료합니다");
				return; // 종료
			default :
				System.out.println("** 메뉴를 다시 선택해주세요");
			}
		}
	}
	


	private void regist() {
		registMenu();
		String choice;
		choice = keyin.next();
		keyin.nextLine(); // 입력 버퍼에 있던 엔터를 날려서 처리해줌
		
		switch (choice) {
		case "1" : // 매매 등록 (주소, 주거형태, 크기, 매매가격)
			input("BuyingAndSelling");
			break;
		case "2" : // 전세 등록 
			input("Charter");
			break;
		case "3" : // 월세 등록
			input("MonthlyRent");
			break;
		case "0" : return; // 상위메뉴
		default :
			System.out.println("** 메뉴를 다시 선택해주세요");
		}
		
	}


	// 매물 정보의 데이터 중 중복데이터 입력받아 반환하는 메소드
	// 주소, 주거형태, 크기
	private void input(String type) {
		String address;
		String houseType;
		int size;
		int price = 0; // 가격 => 매매,전월세에 대한 모든 금액
		RealEstate realEstate = null;
		
		System.out.println("> 주소 입력 : ");
		address = keyin.nextLine(); // 강남구v역삼동 이므로 next ㄴㄴ
		System.out.println("> 주거 형태 (아파트, 빌라, 단독주택): ");
		houseType = keyin.next();
		System.out.println("> 크기 (평형) : ");
		size = keyin.nextInt();
		
		switch(type) {
		case "BuyingAndSelling" :
			System.out.println("> 매매 가격");
			price = keyin.nextInt();
			realEstate = new BuyingAndSelling(address, houseType, size, price);
			break;
		case "Charter" :
			System.out.println("> 전세 가격");
			price = keyin.nextInt();
			realEstate = new Charter(address, houseType, size, price);
			System.out.println(realEstate);
			break;
		case "MonthlyRent" :
			System.out.println("> 월세 가격");
			price = keyin.nextInt();
			realEstate = new MonthlyRent(address, houseType, size, price);
			break; // break와 default 생략 가능
		}
		
		System.out.println(address + " / " + houseType
				+ " / " + size + " / " + price);
		
		
		// ui로 넘기기
		boolean result = service.insert(realEstate);
		
		if (result) {
			System.out.println("** 물건이 등록되었습니다.");
			return;
		}
		System.out.println("** 물건 등록 실패!");
	}



	private void retrieve() {
		retrieveMenu();
		String choice, address;
		String type = null;
		List<RealEstate> list = null;
		
		choice = keyin.next();
		keyin.nextLine(); // 입력 버퍼에 남아있는 엔터를 지우는 역할
		
		switch (choice) {
		case "1" : {
			System.out.println("> 검색할 주소 입력");
			address = keyin.next();
			RealEstate realEstate = service.selectByAddress(address);
			System.out.println(realEstate);
			}
			return; // retrieve를 벗어나서 retrieve를 호출한  mainmenu 쪽으로 간다
		case "2" : { // 매매 물건 검색
			type = "BuyingAndSelling";
			}
			break;
		case "3" : { // 전세 물건 검색
			type = "Charter";
			}
			break;
		case "4" : { // 월세 물건 검색
			type = "MonthlyRent";
			}
		default :
			System.out.println("** 메뉴를 다시 선택해주세요");
			return;
		}
		list = service.selectByType(type);
		if (list.size()==0) {
			System.out.println("** 찾는 물건이 없습니다");
			return;
		}
		
		
		// iterator로 출력
		Iterator<RealEstate> iter = list.iterator();
		
		// iterator 생성하여 순회할 때마다 추출
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}	
	}



	private void modify() {
		String address;
		int price;
		
		System.out.println("|수정 물건의 주소|");
		address = keyin.nextLine();
		
		RealEstate realEstate = service.selectByAddress(address);
		// 주소로 검색하는 메소드 만들기 -> Serivce -> Impl
		if (realEstate == null) {
			System.out.println("** 해당 주소의 물건은 없습니다");
		}
		System.out.println("등록된 정보" + 
				"\r\n==================================\r\n" +
				realEstate + "\r\n===================================");
		
		
		// 가격 수정
		// instanceof : 실제로 네가 가리키고 있는게 뭐냐?!
		if (realEstate instanceof BuyingAndSelling) {
			System.out.println("> 매매 가격 : ");
			price = keyin.nextInt();
			((BuyingAndSelling)realEstate).setPrice(price);
			// 부모 클래스인 realEstate에는 getprice가 없으므로
			// 다운캐스팅 해야한다!
		}
		else if (realEstate instanceof Charter) {
			System.out.println("> 전세 임대보증금 : ");
			price = keyin.nextInt();
			((Charter)realEstate).setDepositMoney(price);
		}
		else if (realEstate instanceof MonthlyRent) {
			System.out.println("> 월세 임대료 : ");
			price = keyin.nextInt();
			((MonthlyRent)realEstate).setMonthlyRent(price);
		}
		
		boolean result = service.update(realEstate);
		
		if (result) {
			System.out.println("** 수정이 완료되었습니다");
			System.out.println(realEstate);
			return;
		}
		System.out.println("** 수정 실패!");
		
	}



	private void delete() {
		String address;
		
		System.out.println("|삭제 물건의 주소|");
		address = keyin.nextLine();
		
		boolean result = service.delete(address);
		if (result) System.out.println("** 정상 삭제되었습니다");
		else 		System.out.println("** 삭제 실패!");
		
	}



	private void retrieveAll() {
		List<RealEstate> list = service.selectAll(); // List<realEstate>로 반환
		
		if(list.size() == 0) {
			System.out.println("** 등록된 매물이 없습니다.");
			return ;
		}
		
		// iterator 로 수정하여 전체 순회
		Iterator<RealEstate> iter = list.iterator();
		
		// iterator 생성하여 순회할 때마다 추출
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}	
		
	}



	private void mainMenu() {
		System.out.println("--------------------------\r\n" + 
				"     부동산 중개 관리 시스템 \r\n" + 
				"--------------------------\r\n" + 
				"	1. 등	록\r\n" + 
				"	2. 검	색\r\n" + 
				"	3. 수	정\r\n" + 
				"	4. 삭제(거래완료) \r\n" + 
				"	5. 전체출력\r\n" + 
				"	0. 종	료\r\n" + 
				"--------------------------\r\n" + 
				"메뉴 번호를 선택하세요 =>");
	}
	
	private void registMenu() {
		System.out.println("--------------------------\r\n" + 
				"     부동산 매물 정보 등록 \r\n" + 
				"--------------------------\r\n" + 
				"	1. 매	매\r\n" + 
				"	2. 전	세\r\n" + 
				"	3. 월	세\r\n" + 
				"	4. 상위메뉴\r\n" + 
				"--------------------------\r\n" + 
				"메뉴 번호를 선택하세요 =>");
	}
	
	
	private void retrieveMenu() {
		System.out.println("--------------------------\r\n" + 
				"     부동산 매물 정보 검색 \r\n" + 
				"--------------------------\r\n" +
				"	1. 주소로 검색\r\n" + 
				"	2. 매매 물건 검색\r\n" + 
				"	3. 전세 물건 검색\r\n" + 
				"	4. 월세 물건 검색\r\n" + 
				"--------------------------\r\n" +
				"메뉴 번호를 선택하세요 => ");
	}
	
	
}