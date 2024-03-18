import java.util.Scanner;

/*
 * [문제2] 영화 예약 시스템 만들기
String[] seat = new String[10]; 좌석 // 1-개의 문자열 배열 생성
String name;    예약자 이름 // 1~10
int seatNumber; 좌석 번호

 * 
 * <실행 예시>
 * ============================================
 * [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 * 예약자 이름 입력 : James
 * 좌석 입력 (1~10) : 5
 * ============================================
 * [ ] [ ] [ ] [ ] [James] [ ] [ ] [ ] [ ] [ ]
 * 예약자 이름 입력 : Tom
 * 좌석 입력 (1~10) : 5
 * 이미 예약된 좌석입니다! 다른 좌석을 골라주세요
 * 
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String [] seat = new String[10];
		String name;
		int seatNumber, remain = seat.length;
		
		
		// 전체 좌석 출력
		while (true) {
			System.out.println("\n=============================================");
			// 남은 좌석 수
			System.out.println("** 남은 좌석 수 : " + remain);
			
			for (int i =0; i<seat.length; ++i) {
				System.out.print("[ ");
				if (seat[i] != null) System.out.print(seat[i]);
				System.out.print(" ]");	
			}
			System.out.println();
			
			// 예약자 이름 입력
			System.out.print("예약자 이름 입력 : ");
			name = keyin.next();
			
			// 좌석 번호 입력
			System.out.print("좌석 번호 입력 (1~10) : \n");
			seatNumber = keyin.nextInt();
			
			// 없는 좌석
			if (seatNumber<1||seatNumber>10) {
				System.out.println("없는 좌석입니다. 다른 좌석을 골라주세요!");
				continue;
			}
			// 이미 예약된 좌석
			if (seat[seatNumber-1] != null){
				System.out.println("이미 예약된 좌석입니다. 다른 좌석을 골라주세요!");
				continue;
			}
			// 예약 성공 : 이름 등록 및 남은 좌석수 감소
			seat[seatNumber-1] = name;
			--remain;
		} // end while
	}
		
}