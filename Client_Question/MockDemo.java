package Client_Question;

public class MockDemo {

	public static void main(String[] args) {
		
	
	//Implement a function to check if a string is a palindrome.
	String s = "naman";
	String temp = s;
	String sb = new StringBuffer(s).reverse().toString();
	System.out.println("Reverse : "+sb);
	if(temp.equals(sb)) {
		System.out.println("Palindrom");
	}
	else {
		System.out.println("Not Palindrom");
	}
	
	} 
	
	
	
}
