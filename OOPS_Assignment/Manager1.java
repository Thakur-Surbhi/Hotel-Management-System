package OOPS_Assignment;

public class Manager1 extends Person1 {

	public Manager1(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	private int teamSize;

	public Manager1(String name, double salary, int teamSize) {
		super(name, salary);
		this.teamSize = teamSize;
	}
	
	public double calculateBonus() {
		return salary*0.10+teamSize*500;
		
	}

	public static void main(String[] args) {
		Manager1 m = new Manager1("Alice", 45000, 5);
		System.out.println("Manager bonus "+m.calculateBonus());
	}
}
