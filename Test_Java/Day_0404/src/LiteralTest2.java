
public class LiteralTest2 {

	public static void main(String[] args) {
		String song = "송아지 송아지 \t얼룩 송아지\n엄마소도 얼룩소\n 엄마닮았네";
		System.out.println(song);
		
		String str = "강아지가 짖었어요 \"왈왈왈\"";
		System.out.println(str);
		
		byte by = 127; // 128은 오류
		byte result = -128; // 최하값
		result = 10+1;
		
		int data = 15;
		data = 20;
		
		final int temp=15; // 딱 한 번만 값을 넣으면 수정 불가
		// temp = 20
		
		
	}

}
