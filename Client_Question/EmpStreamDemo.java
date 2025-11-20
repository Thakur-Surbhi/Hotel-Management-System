package Client_Question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//How would you find the top 3 highest salaries from an 
//employee list using streams?
public class EmpStreamDemo {

	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList(
				new Employee("AAA", 122000),
				new Employee("AAA", 5002000),
				new Employee("AAA", 200000),
				new Employee("AAA", 412000)
				
        );

		List<Employee> res =list.stream().sorted(Comparator.comparingDouble(Employee::getSal).reversed()).limit(3).collect(Collectors.toList());
		res.forEach(System.out::println);
		//System.out.println(res);
			
	}
}
