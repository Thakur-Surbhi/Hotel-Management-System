package Stream8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
	public static void main(String[] args) {
		List<String> myList1 = Arrays.asList("Pune", "Delhi", "Mumbai");
		List<String> myList2 = Arrays.asList("Pune", "Kolkata", "Hydrabad", "Delhi");
		
	      List<List<String>> result = Arrays.asList(myList1, myList2);
	      
	      List<String> res =result.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
	      System.out.println(res);
	}

}
