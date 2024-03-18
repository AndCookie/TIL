package net.sort;

public class TraineeMain {

	public static void main(String[] args) {
		Trainee[] list = new Trainee[10];
		
		// 초기화
		init(list); // 배열에 데이터를 저장함
		System.out.println(">>>>>>> 원본");
		
		// 출력
		output(list);
		
		// 순위
		ranking(list);
		System.out.println("\n>>>>>>> 순위 처리");
		output(list);
		
		// 버블 정렬
		bubbleSort(list);
		System.out.println("\n>>>>>>> 이름으로 오름차순");
		output(list);
		
	}

	
	private static void bubbleSort(Trainee[] list) {
		Trainee temp = null; // 바꿀 때 사용할 그릇
		// 앞의 이름이 뒷사람의 이름보다 크면 바꾼다
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
					// 등수를 알아와서 +1하여 다시 등수에 저장
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
		   list [0] = new Trainee("장비", 100, 89, 98);
		   list [1] = new Trainee("제갈량", 99, 86, 98);
		   list [2] = new Trainee("이순신", 85, 100, 98);
		   list [3] = new Trainee("관우", 98, 99, 98);
		   list [4] = new Trainee("유관순", 89, 87, 98);
		   list [5] = new Trainee("김유신", 77, 65, 98);
		   list [6] = new Trainee("전우치", 67, 90, 98);
		   list [7] = new Trainee("임꺽정", 99, 100, 98);
		   list [8] = new Trainee("제갈공명", 80, 72, 98);
		   list [9] = new Trainee("유비", 76, 70, 98);
	}

}
