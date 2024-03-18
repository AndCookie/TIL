package third;

public class Employee { // vo는 select문에 의해서 결정된다
	private String firstName;
	private String departmentName;
	private double salary;
	
	// 생성자
	public Employee() {
		super();
	}
	public Employee(String firstName, String departmentName, double salary) {
		super();
		this.firstName = firstName;
		this.departmentName = departmentName;
		this.salary = salary;
	}
	
	// getter setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// toString
	@Override
	public String toString() {
		String temp = String.format("%11s\t %16s\t %9.2f\n", firstName, departmentName, salary);
		return temp;
	}
	
}
