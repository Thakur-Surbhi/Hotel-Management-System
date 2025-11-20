package com.Lamda;

import java.util.Arrays;
import java.util.List;

public class EmpComparator {
	public static void main(String[] args) {
		List<Employee> emp = Arrays.asList(
				new Employee(10, "Chandan", 40),
				new Employee(23, "Surbhi", 30),
				new Employee(34, "Amit", 28)
				);

		System.out.println("Before age sorting ");
		emp.forEach(System.out::println);
		
		//emp.sort((e1, e2)->Integer.compare(e1.age, e2.age));
		//emp.sort((e1, e2)->e1.name.compareTo(e2.name));
		emp.sort((e3,e4)->Integer.compare(e3.id, e4.id));
		
		System.out.println("After age sorting ");
		emp.forEach(System.out::println);
	}

}
