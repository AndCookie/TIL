/*
 * 
 * 주어진 섭씨 온도 C를 화씨 온도 F 로 바꾸어 주는 프로그램을 설계한 후 작성하시오.
주어진 섭씨 온도는 15° 이다.
섭씨 온도를 화씨로 바꾸는 공식은 아래와 같다.
 * 
 */
public class Exam_1 {

	public static void main(String[] args) {
		int celsius = 15;
		double fahrenheit = 9/(double)5*celsius +32;
		// double fahrenheit = (double)9/5*celsius +32;
		// double fahrenheit = 9.0/5*celsius +32;
		System.out.println("섭씨 온도 C "+ celsius +"°는 " + "화씨 온도 F" + fahrenheit + "와 같습니다.");		
	}

}
