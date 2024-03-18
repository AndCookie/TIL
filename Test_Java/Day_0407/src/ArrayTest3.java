
public class ArrayTest3 {

	public static void main(String[] args) {
		int a=10, b=10;
		if (a==b) System.out.println("같은 값");
		else System.out.println("다른 값");
		
		String s1 = "홍길동"; // String Pool
		String s2 = "홍길동";
		String s3 = new String("홍길동");
		
		// 일반 비교연산자 사용시 참조값(주소)를 비교함
		// s1은 홍길동 일 때, s2는 새로 홍길동을 만들지 않고 찾다보니
		// s1,s2 은 같은 주소값을 갖게 된다.
		// new 홍길동을 선언하면, 주소값이 다름 ㅇㅇ
		
		// 참조값 (주소를 비교)
		if (s1 == s2) System.out.println("같은 값");
		else System.out.println("다른 값");
		
		// 주소를 비교
		if (s1 == s3) System.out.println("같은 값");
		else System.out.println("다른 값");
		
		// 내용을 비교
		if (s2.equals(s3)) System.out.println("같은 값");
		else System.out.println("다른 값");
		
		
		// ============================================
		String b1 = "홍길동";
		String b2 = "홍길동"; // b1과 b2의 주소값이 같음
		b2 = "전우치"; // b2의 주소값을 새로 만들게 됨
		b1 = "손오공"; // b1도 새로운 주소값을 갖게되어, 홍길동은 가비지 콜렉터에 의해 삭제됨
		// 홍길동 : GC에 의해 메모리에서 제거 : 즉시 제거되는 것은 아님 : 우선순위가 낮으므로 CPU가 한가할 때 제거될 예정
		String temp = "안녕하세요" + "여러분" + "ooo" + "ooo";
	}

}
