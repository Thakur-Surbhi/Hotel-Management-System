package Stream8;

public class Demo  {
public static void main(String[] args) {
	MyInterface m = (a,b)->a*b;
	int result = m.multiply(3, 4);
	System.out.println(result);
  }
	}


