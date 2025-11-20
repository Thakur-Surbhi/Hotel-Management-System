package OOPS_Assignment;

public class Car2 extends Vehicle2 {
	
	public void start() {
		System.out.println("Car is Starting.. ");
	}

	public static void main(String[] args) {
		Vehicle2 v= new Car2();
		v.start();
		
	}
}
