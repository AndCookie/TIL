package net.sort;

public class TraineeMain {

	public static void main(String[] args) {
		Trainee[] list = new Trainee[10];
		
		// �ʱ�ȭ
		init(list); // �迭�� �����͸� ������
		System.out.println(">>>>>>> ����");
		
		// ���
		output(list);
		
		// ����
		ranking(list);
		System.out.println("\n>>>>>>> ���� ó��");
		output(list);
		
		// ���� ����
		bubbleSort(list);
		System.out.println("\n>>>>>>> �̸����� ��������");
		output(list);
		
	}

	
	private static void bubbleSort(Trainee[] list) {
		Trainee temp = null; // �ٲ� �� ����� �׸�
		// ���� �̸��� �޻���� �̸����� ũ�� �ٲ۴�
		for(int i=0; i<list.length-1; ++i) {
			for (int j=0; j<list.length-1; ++j) {
				if (list[j].getName().compareTo(list[j+1].getName()) >0) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		
	}


	private static void ranking(Trainee[] list) {
		for(int i=0; i<list.length; ++i) {
			list[i].setRank(1);
			for (int j=0; j<i; ++j) {
				if (list[i].getAvg() < list[j].getAvg()) {
					// ����� �˾ƿͼ� +1�Ͽ� �ٽ� ����� ����
					list[j].setRank(list[j].getRank() + 1);
				} else if (list[i].getAvg() > list[j].getAvg()) {
					list[i].setRank(list[i].getRank() + 1);
				}
			}
		} // end for
		
	}


	private static void output(Trainee[] list) {
		for(Trainee e : list)
			System.out.println(e);
	}

	
	private static void init(Trainee[] list) {
		   list [0] = new Trainee("���", 100, 89, 98);
		   list [1] = new Trainee("������", 99, 86, 98);
		   list [2] = new Trainee("�̼���", 85, 100, 98);
		   list [3] = new Trainee("����", 98, 99, 98);
		   list [4] = new Trainee("������", 89, 87, 98);
		   list [5] = new Trainee("������", 77, 65, 98);
		   list [6] = new Trainee("����ġ", 67, 90, 98);
		   list [7] = new Trainee("�Ӳ���", 99, 100, 98);
		   list [8] = new Trainee("��������", 80, 72, 98);
		   list [9] = new Trainee("����", 76, 70, 98);
	}

}
