
public class SwitchTest1 {

	public static void main(String[] args) {
		String family = "dog";
				
		switch(family) {
		case "mother" : System.out.println("����"); break;
		case "father" : System.out.println("�ƺ�"); break;
		case "sister" : System.out.println("��������"); break;
		case "brother" : System.out.println("��������"); break;
		default : System.out.println("���׳�");
		}
		
		System.out.println("��");
		
		//==============
		int data = 20;
		String msg = null;
		switch(data%2) {
		case 0 : msg = "¦��"; break; //¦��
		case 1 : msg = "Ȧ��"; //Ȧ��
		// default ����
		}
		System.out.println(msg);
		System.out.println("��");
		
		
		
		// =================
		family = "mother";
		
		switch(family) {
		case "mother" : 
		case "father" : System.out.println("�θ��"); break;
		case "sister" : 
		case "brother" : System.out.println("����"); break;
		default : System.out.println("���׳�");
		}
		
		System.out.println("��");

	}

}
