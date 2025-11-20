package Client_Question;

public class Employee {
	
	
	//How would you find the top 3 highest salaries from an employee list using streams?
	 
	private String name;
	private long sal;
	
	public Employee(String name, long sal) {
		super();
		this.name = name;
		this.sal = sal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSal() {
		return sal;
	}
	public void setSal(long sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	
	

}
