package net.kd.cashbook.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.kd.cashbook.dao.CashbookDAO;
import net.kd.cashbook.vo.CashItem;
import net.kd.cashbook.vo.Cashbook;



public class CashbookUI {
	Scanner keyin = new Scanner(System.in);
	CashbookDAO dao = new CashbookDAO();
	List<CashItem> itemList;

	public CashbookUI() {
		itemList = dao.selectCashItem();
		String choice;

		while(true) {
			mainMenu();
			choice = keyin.nextLine();

			switch(choice) {
			case "1" : input();  		break;
			case "2" : list();   		break;
			case "3" : delete(); 		break;
			case "4" : statistics(); 	break;
			case "0" : 
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	// 메인 메뉴
	private void mainMenu() {
		System.out.println("===== [ 지출 관리] =====");
		System.out.println("    1) 지출 내역 입력");
		System.out.println("    2) 지출 내역 조회");
		System.out.println("    3) 내역 삭제");
		System.out.println("    4) 지출 통계보기");
		System.out.println("    0) 프로그램 종료"); 
		System.out.println("======================");
		System.out.print  ("      선택> ");
	}

	// 지출 내역 입력
	private void input() {
		int itemid;
		String detail;
		int amount;
		String note;
		
		System.out.println("\n<< 지출 내역 입력 >>");
		printItemList();
		
		try {
			System.out.println("## 항목번호 : ");
			itemid = keyin.nextInt();
			if (!(itemid>=1 && itemid<=7)) {
				System.out.println("정확한 데이터를 입력해주세요");
				keyin.nextLine();
				return;
			}
		} catch(Exception e) {
			System.out.println("err> 데이터가 잘못 입력되었습니다.");
			keyin.nextLine();
			return;
		}
		
		System.out.println("## 세부내역 : ");
		detail = keyin.nextLine();
		
		try {
			System.out.println("## 금액 : ");
			amount = keyin.nextInt();
		} catch(Exception e) {
			System.out.println("err> 데이터가 잘못 입력되었습니다.");
			keyin.nextLine();
			return;
		}
	    
		System.out.println("## 메모내용 : ");
		note = keyin.nextLine();
		

		// 저장한다.
		int result = 0;
		result = dao.insertCashbook(new Cashbook (0, null, itemid, detail, amount, note));

		System.out.println(result +"개의 항목이 저장되었습니다.");
	}

	// 지출 목록 출력
	private void printItemList() {
		List<CashItem> list = dao.selectCashItem();
		
		if(list.size() == 0) {
			System.out.println("** 등록된 지출이 없습니다.");
			return ;
		}
		
		// iterator 로 수정하여 전체 순회
		Iterator<CashItem> iter = list.iterator();
		System.out.println(iter);
	}

	// 지출 내역 조회
	private void list() {
		System.out.println("\n<< 월별 지출 보기 >>");
		
		String date = inputDate();
		if(date == null) {
			System.out.println("데이터가 잘못 입력되었습니다.");
			return;
		}
		if (!(date.length()>=1 && date.length()<=7)) {
			System.out.println("데이터가 잘못 입력되었습니다");
			return;
		}
		
		List<Cashbook> list = dao.ReadCashbookByDate(date);
		
		// iterator 로 수정하여 전체 순회
		Iterator<Cashbook> iter = list.iterator();
		System.out.println(iter);
	}

	// 가계부 삭제
	private void delete() {
		int seq;
		String answer;
		int result = 0;
		
		System.out.println("\n<< 내역 삭제 >>");
		
		list();
		System.out.println("삭제할 내역 번호를 입력 : ");
		seq = keyin.nextInt();
		System.out.println("삭제하시겠습니까?(y/n)");
		answer = keyin.nextLine();
		
		if(!answer.equals("y")) {
			System.out.println("** 삭제 작업이 취소되었습니다.");
			keyin.nextLine();
			return;
		}

		result = dao.deleteCashbook(seq);
		System.out.println(result +"개의 지출 내역이 삭제되었습니다.");
	}

	// 지출 통계보기
	private void statistics() {
		System.out.println("\n<< 지출 통계보기 >>");

		String date = inputDate();
		if(date == null) {
			System.out.println("데이터가 잘못 입력되었습니다.");
			return;
		}
		
		// Code here
		
	}
	
	// 년도와 월을 입력받는 메소드 
	// 입력받은 년도와 월을 YY/MM 과 같은 형식으로 만들어 리턴한다.
	// 년도와 월은 길이가 각각 2자리여야 한다.
	private String inputDate() {
		String year, month, date = null ;
		
		System.out.println("연도를 2자리로 입력하세요 : ");
		year = keyin.nextLine();
		System.out.println("월을 2자리로 입력하세요 : ");
		month = keyin.nextLine();
		
		date = year + "/" + month;
		return date;
	}
}
