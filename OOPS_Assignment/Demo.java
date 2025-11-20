package OOPS_Assignment;

public class Demo {
	public static void main(String[] args) {
		int n = 100;
		
		for(int i=2; i*i<=100; i++) {
			if(n%i==0) {
				System.out.println("Prime No : "+i+" ");

			}
		}
	}
}

