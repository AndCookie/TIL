
public class PersonTest {

	public static void main(String[] args) {
//		Person p = Person.�տ���;
//		System.out.println(p);
//		
//		System.out.println(p.getNickName());
//		System.out.println(p.work());
		
		Person[] person = Person.values();
		
		for (Person p : person) {
			System.out.println(p + " " + p.getNickName() + " " + p.work());
		}
		
		

	}

}
