package OOPS_Assignment;

public class Employee1 extends Person1{

	public Employee1(String name, double salary) {
		super(name, salary);
	}
	
	public double calculateBonus() {
		return salary*0.10 ;
		
	}
	
	public static void main(String[] args) {
		Employee1 e=new Employee1("BOB", 30000);
		System.out.println("Employee Bonus : "+e.calculateBonus());
	}
}



