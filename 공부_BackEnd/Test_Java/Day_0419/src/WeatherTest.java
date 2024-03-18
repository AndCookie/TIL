import java.util.Scanner;

public class WeatherTest {

	public static void main(String[] args) {

		Scanner keyin = new Scanner(System.in);
		String choice;
		System.out.println("언어를 선택하세요");
		System.out.println("1) 한글    2) 영어");
		choice = keyin.next();
	
		Weather[] weather = Weather.values();
		
		switch(choice) {
		case "1" : 
			for (Weather w : weather) {
				System.out.println(w + " : " + w.playKor());
			}
			break;
		case "2" :
			for (Weather w : weather) {
				System.out.println(w.getEng() + " : " + w.playEng());
			}
			break;
		}
		
		keyin.close();
	
	}
}
