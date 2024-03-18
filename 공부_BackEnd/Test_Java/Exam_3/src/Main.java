import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		Point[] p = new Point[100];
		
		int count = 0;
		String choice;
		double radius = 0;
		int x, y, width, height = 0;
		
		while (true) {
			System.out.println("1. 원 2. 사각형 3. 전체보기 4. 종료 : ");
			
			choice = keyin.next();
			
			System.out.println("x : ");
			x = keyin.nextInt();
			System.out.println("y : ");
			y = keyin.nextInt();
			
			switch(choice) {
			case "1" : 
				System.out.println("radius : ");
				radius = keyin.nextDouble();
				p[count] = new Circle(x, y, radius);
				count++;
				break;
			case "2" :
				System.out.println("width : ");
				width = keyin.nextInt();
				System.out.println("height : ");
				height = keyin.nextInt();
				p[count] = new Rectangle(x,y, width, height);
				count++;
				break;
			case "3" :
				print(p);
				break;
			case "4" : 
				keyin.close();
				return;
			}
		}

	}

	public static double calArea(Point point) {
		double result = 0;
		if (point instanceof Circle) {	
			result = ((Circle)point).area(); // 쓰려는 시점에서는 다운캐스팅해야한다
		} else {
			result = ((Rectangle)point).area();
		}
		return result;
	}

	public static void print(Point[] point) {
		for (int i=0; i<point.length; ++i) {
			if (point[i] == null) return;
			
			if (point[i] instanceof Circle) {
				System.out.println((i+1)+") 원 : ");
				System.out.println(point[i].getX() + ", " + point[i].getY());
				System.out.println(((Circle)point[i]).getRadius() + ", ");
				System.out.println(calArea(point[i]));
			} else {
				System.out.println((i+1)+") 사각형 : ");
				System.out.println(point[i].getX() + ", " + point[i].getY());
				System.out.println(((Rectangle)point[i]).getWidth() + ", ");
				System.out.println(((Rectangle)point[i]).getHeight() + ", ");
				System.out.println(calArea(point[i]));
			}
		}
	}

}
