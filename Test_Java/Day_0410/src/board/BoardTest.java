package board;

public class BoardTest {

	public static void main(String[] args) {
	// 메소드를 통해서 우회적으로 접근
		// 클래스를 생성해서 사용한다 = 메모리에 올려서 참조한다
		Board b1 = new Board(); // 생성자 매소드 (Constructor)
		b1.setBoardseq(123);
		b1.setTitle("오늘은 월요일");
		b1.setWriter("홍길동");
		b1.setRegdate("2023-04-10");
		b1.setContents("월요일은 일주일의 시작");
		b1.setAttachment("java.docx");
		b1.setViewcount(15);
		
		b1.output();
		System.out.println();		
		}

}
