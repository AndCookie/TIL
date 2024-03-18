import java.util.Scanner;

public class InputTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //ctrl + shift + o
		int age;
		double height;
		String name;
		
		System.out.print("나이를 입력 : ");
		age = scanner.nextInt();
		
		System.out.print("키를 입력 : ");
		height = scanner.nextDouble();
		
		System.out.print("이름을 입력 : ");
		name = scanner.next();
		
		System.out.println(name + ", "+ age + "살, " + height +  "cm");
		
		scanner.close(); // 한 번 닫으면 끝나므로 가장 마지막 단계에 입력해야함
	}

}
