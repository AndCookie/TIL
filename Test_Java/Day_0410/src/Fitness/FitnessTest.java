package Fitness;

public class FitnessTest {

	public static void main(String[] args) {
		// ���̷�Ʈ ����
//		Fitness hong = new Fitness();
//		hong.id = 123;
//		hong.name = "ȫ�浿";
//		hong.weight = 65.8;
//		hong.height = 173.6;
//		hong.bmi = hong.weight / ((hong.height/100) * (hong.height/100));		
		
		// �޼ҵ带 ���ؼ� ��ȸ������ ����
		Fitness hong = new Fitness();
		hong.setId(123);
		hong.setName("ȫ�浿");
		hong.setHeight(173.6);
		hong.setWeight(65.8);
//		hong.setBmi(hong.getWeight() / ((hong.getHeight()/100) * (hong.getHeight()/100)));
		
//		output(hong);  =================
		hong.output();
		System.out.println();
		
		
		Fitness son = new Fitness();
		son.setId(200);
		son.setName("�տ���");
		son.setWeight(54.8);
		son.setHeight(170.5);
//		son.setBmi(son.getWeight() / ((son.getHeight()/100) * (son.getHeight()/100)));
		
//		output(son);	==============
		son.output();
		
		// �Ķ��� ���� : 
		// �ʷϻ� �׸� : �޼ҵ�� (public���� ����� �޼ҵ��)
	}
	
//	
//	public static void output(Fitness f) { ============
//		// main�� static�̹Ƿ� ���⵵ static�ؾ� ȣ�� ����
//		System.out.println("ȸ�� ID : " + f.getId());
//		System.out.println("ȸ���̸� : " + f.getName());
//		System.out.println("������(Kg) : " + f.getWeight());
//		System.out.println("Ű(cm) : " + f.getHeight());
//		System.out.println("BMI : " + f.getBmi());
//	}

}
