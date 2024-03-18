package Fitness;

public class FitnessTest {

	public static void main(String[] args) {
		// 다이렉트 접근
//		Fitness hong = new Fitness();
//		hong.id = 123;
//		hong.name = "홍길동";
//		hong.weight = 65.8;
//		hong.height = 173.6;
//		hong.bmi = hong.weight / ((hong.height/100) * (hong.height/100));		
		
		// 메소드를 통해서 우회적으로 접근
		Fitness hong = new Fitness();
		hong.setId(123);
		hong.setName("홍길동");
		hong.setHeight(173.6);
		hong.setWeight(65.8);
//		hong.setBmi(hong.getWeight() / ((hong.getHeight()/100) * (hong.getHeight()/100)));
		
//		output(hong);  =================
		hong.output();
		System.out.println();
		
		
		Fitness son = new Fitness();
		son.setId(200);
		son.setName("손오공");
		son.setWeight(54.8);
		son.setHeight(170.5);
//		son.setBmi(son.getWeight() / ((son.getHeight()/100) * (son.getHeight()/100)));
		
//		output(son);	==============
		son.output();
		
		// 파란색 세모 : 
		// 초록색 네모 : 메소드명 (public으로 선언된 메소드들)
	}
	
//	
//	public static void output(Fitness f) { ============
//		// main이 static이므로 여기도 static해야 호출 가능
//		System.out.println("회원 ID : " + f.getId());
//		System.out.println("회원이름 : " + f.getName());
//		System.out.println("몸무게(Kg) : " + f.getWeight());
//		System.out.println("키(cm) : " + f.getHeight());
//		System.out.println("BMI : " + f.getBmi());
//	}

}
