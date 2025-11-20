package Client_Question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Emp1Demo {
	public static void main(String[] args) {
		
		List<Employee1> emp = Arrays.asList(
				   new Employee1(1, "Alice", "Engineering", 120000),
				   new Employee1(2, "Bob", "HR", 80000),
				   new Employee1(3, "Charlie", "Engineering", 110000),
				   new Employee1(4, "David", "Engineering", 115000),
				   new Employee1(5, "Eve", "HR", 85000),
				   new Employee1(6, "Frank", "Sales", 90000)
				);
		
		Map<String, Double> res= emp.stream().collect(Collectors.groupingBy(Employee1::getDepartment,
				Collectors.averagingDouble(Employee1::getSalary)));
				
		 //res.forEach((dept, avgSal)->System.out.println("Dept : "+dept+" Average Sal : "+avgSal));
		
		  Set<Map.Entry<String, Double>> entry = res.entrySet(); 
		  for(Map.Entry<String,Double> e :entry) 
		  { 
			  System.out.println(e.getKey()+" : "+e.getValue()); 
			  }
		  
		 
	}

}
