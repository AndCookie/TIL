
public class StringTest2 {

	public static void main(String[] args) {
		// 1.	char charAt(int index)
		String str = "무궁화 꽃이 피었습니다. a";
		char ch = str.charAt(4); // 인덱스 위치의 문자를 반환
		System.out.println(ch);
		
		int len = str.length(); // 전체 길이
		int temp = str.charAt(len-1); // 마지막 문자의 인덱스 = 전체길이 - 1
		System.out.println(temp);
		
		
		// 2.   int compareTo(String anotherString)
		String str1 = "Korea";
		String str2 = "koRea";
		System.out.println("compare값 : " + str1.compareTo(str2));
		// 두 문자열 비교해서 앞작:음수, 앞크:양수, 같:0
		// 같은 인덱스 값끼리 비교 97-65 = 32
		// 비교 결과가 0이면 차이가 날 때까지 다음 인덱스로 넘어감
		// 잔체가 똑같으면 0 반환
		
	
		// 3.	String concat(String str)
		str1 = "무궁화";
		str2 = " 꽃";
		System.out.println(str1 + str2);
		System.out.println(str1.concat(str2));
		String result = str1.concat(str2);
		
		
		// 4.	boolean contains(CharSequence s)
		// 캐릭터시퀀스 타입들은 모두 올 수 있다는 의미
		// 캐릭터시퀀스의 자식 : String, StringBuffer
		System.out.println(result.contains("꽃")); // true
		
		
		// 5.	boolean endsWith(String suffix)
		System.out.println(result.endsWith("꽃")); // true
		System.out.println(result.startsWith("꽃")); // false
		
		
		// 6.	boolean equals(Object obj)
		System.out.println(result.equals("장미꽃")); // false
		
		
		// 7.	int indexOf(int ch)
		System.out.println(result.indexOf('꽃')); // 4
		// 전달인자로 코드에 해당하는 정수 또는 특정 문자를 전달하면
		// 그것의 위치를 반환해줌
		String jumin = "911225-1012345";
		// 성별 : 7번 인덱스의 데이터를 반환
		char gender = jumin.charAt(7);
		String tmp = gender == '1' ? "남자" : "여자"; // 삼항 연산자
		System.out.println(tmp);
		
		
		// 8.	boolean isEmpty()
		System.out.println("".isEmpty()); // 비어있는 문자열
		System.out.println("강아지".isEmpty());
		System.out.println(" ".isEmpty()); // 비어있지 않은 것!!!
		
		
		// 9.	int lastIndexOf(int ch)
		str1 = "나리나리 개나리 입에 따라 물고요";
		str1.lastIndexOf('리'); // 10
		// 뒤에서부터 찾기 시작하여 가장 먼저 찾은 것의 인덱스 반환
		
		
		// 10.	int length()
		System.out.println(str1.length()); // 문자열의 길이를 구하는 메소
		String[] ary = new String[10];
		System.out.println(ary.length); // 배열의 길이를 구하는 속성
		
		
		// 11.	String replace(char oldChar, char newChar)
		str1 = "송아지 송아지 얼룩 송아지";
		System.out.println(str1.replace('송', '강'));
		
		
		// 12.	String[] split(String regex)
		str2 = "홍길동 100 95 87";
		String[] score = str2.split(" ");
		System.out.println("국어: " + score[1]); // 문자열이므로 숫자 합계 연산 불가		
		System.out.println(score[1].getClass()); // 타입 반환 결과 = String
		
		// 문자열----파싱 parsing ----> (문맥을 확인하여) 숫자로 반환
		int kor = Integer.parseInt(score[1]); // Wrapper 클래스 : 기초자료형을 객체화시킨 것
		int math = Integer.parseInt(score[2]);
		int eng = Integer.parseInt(score[3]);
		System.out.println("합계: " + (kor+math+eng)); // 숫자로 변환되었으므로 숫자 합계 연산 가능
		
		// Wrapper 클래스
		// : 기초자료형 8개를 객체화 시킨 클래스
		// : 모두 lang 패키지 안에 들어있는 클래스
		// byte, short, int, long  -->  Byte, Short, Integer, Long
		// float, double	       -->  Float, Double
		// char 		         -->  Character
		// Boolean	       	   -->  Boolean
		
		
		// 13.	String substring(int beginIndex, int endIndex)
		jumin = "911225-1012345";
		String year = jumin.substring(0, 2);
		String month = jumin.substring(2, 4);
		String day = jumin.substring(4, 6);
		System.out.println(year+"년 "+month+"월 "+day+"일 생입니다.");
		
		year = "19".concat(year); // 문자열
		int now = 2023;
		int age = now - Integer.parseInt(year);
		System.out.println("나이는 " + age + "세");
		
		
		// 14.	String trim()
		// 문자열 앞뒤의 불필요한 공백 (빈 문자열) 삭제
		jumin = "    911225-1012345    ";
		jumin = jumin.trim();
		System.out.println(jumin);
	}

}
