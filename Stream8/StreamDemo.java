package Stream8;

import java.util.Arrays;
import java.util.List;



public class StreamDemo {
	public static void main(String[] args) {

		/*Find the smallest String in an Array
        {“Milind”,”Mehta”,”follow”,”java8",”Microservice”,”Springboot”}*/	

		List<String> list = Arrays.asList("milin", "mehta", "follow", "java8", "springBoot", "microservice");
		String smallest = list.stream().min((s1,s2)->Integer.compare(s1.length(), s2.length())).orElse(null);
		System.out.println(smallest);
	}


	
}
