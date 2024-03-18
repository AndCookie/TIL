
public class SwitchTest1 {

	public static void main(String[] args) {
		String family = "dog";
				
		switch(family) {
		case "mother" : System.out.println("엄마"); break;
		case "father" : System.out.println("아빠"); break;
		case "sister" : System.out.println("여자형제"); break;
		case "brother" : System.out.println("남자형재"); break;
		default : System.out.println("나그네");
		}
		
		System.out.println("끝");
		
		//==============
		int data = 20;
		String msg = null;
		switch(data%2) {
		case 0 : msg = "짝수"; break; //짝수
		case 1 : msg = "홀수"; //홀수
		// default 생략
		}
		System.out.println(msg);
		System.out.println("끝");
		
		
		
		// =================
		family = "mother";
		
		switch(family) {
		case "mother" : 
		case "father" : System.out.println("부모님"); break;
		case "sister" : 
		case "brother" : System.out.println("형제"); break;
		default : System.out.println("나그네");
		}
		
		System.out.println("끝");

	}

}
