
public class StringBufferTest {

	public static void main(String[] args) {
		// String과 달리 new 생성자 필수이며 생략 불가!!!
		StringBuffer sb1 = new StringBuffer(); // 기본생성자
		System.out.println("용량: "+sb1.capacity()); // default=16
		
		StringBuffer sb2 = new StringBuffer("동해물과 백두산이 ");
		System.out.println("용량: "+sb2.capacity()); // 26 = 16+10
		
		String temp = "동해물과 백두산이 ";
		System.out.println("글자 개수: " + temp.length()); // 10
		// 문자열에는 capacity라는 개념 자체가 아예 없고
		// temp.length()는 용량이 아닌, 그저 글자의 개수만 알려주는 것
		
		sb2.append("닳도록 "); // 끝에 추가
		sb2.insert(10, "마르고 "); // 중간에 추가
		System.out.println(sb2);
		System.out.println("글자 개수: " + sb2.length()); // 글자 개수 18
		System.out.println("용량: "+sb2.capacity()); // 용량 26
		
		sb2.delete(0, 5);
		System.out.println(sb2);
		System.out.println(sb2.reverse());
		System.out.println("글자 개수: " + sb2.length()); // 글자 개수 18
		System.out.println("용량: "+sb2.capacity()); // 용량 26
		
		sb2.trimToSize(); // 남아있는 용량을 포함하여 모든 공백 삭제
		System.out.println(sb2);
		System.out.println("글자 개수: " + sb2.length()); // 글자 개수 13
		System.out.println("용량: "+sb2.capacity()); // 용량 13
		
		String data = sb2.toString();
		// StringBuffer을 String으로 바꿔서
		// immutable, 즉 변경 불가능한 것으로 만들기
		// String을 + 더하기 연산자로 추가하면 매번 새로운 문자열을 생성하게 되므로 메모리 낭비 발생
		// StringBuffer로 append 후 맨 마지막에 String으로 변환해주면 좋다!!
		System.out.println(data);
		
	}

}
