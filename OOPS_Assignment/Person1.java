package OOPS_Assignment;

/*Inheritance Question 2: EmployeeManagement
Problem: Design a Person superclass with subclasses Employee and Manager. 
The Manager class should have an additional field teamSize.
Calculate bonus based on role and team size.
Input:
Manager m = new Manager("Alice", 45000, 5); 
Employee e = new Employee("Bob", 30000); 
System.out.println(m.calculateBonus()); 
System.out.println(e.calculateBonus()); 
Output:
Manager Bonus: 7500 
Employee Bonus: 3000 */

public class Person1 {
	
	protected String name;
	protected double salary;
	
	public Person1(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}



	protected double calculateBonus() {
		return 0;
	}
}
