package Client_Question;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
	//[4, 5, 2, 25] next greater element
	/*
	 * 4 --> 5 
	 * 5 --> 25 
	 * 2 --> 25
	 *  25 --> -1
	 */
	
	/*
	 * int a[] = {4, 5, 2, 25}; for(int i=0; i>=a.length; i++) { for(int j=i;
	 * j>=a.length; j++) { if(a[i]<a[j]) { System.out.println(a[j]); break; } else
	 * if (a[i]==a[j]) return -1; } }
	 */
		 String str1 = new String("Hello World");

	        String str2 = new String("Hello World");
	 
	        String str3 = "Hello World";

	        String str4 = "Hello World";
	 
	        int a = 0, b = 0, c = 0;
	 
	        if (str3 == str4)

	            a = 1;

	        else

	            a = 2;
	 
	        if (str1.equals(str3))

	            b = 1;

	        else

	            b = 2;
	 
	        if (str1 == str4)

	            c = 1;

	        else

	            c = 2;
	 
	        // Printing values in variables

	        System.out.println("a= " + a + " b= " + b

	                           + " c= " + c);

}
}


