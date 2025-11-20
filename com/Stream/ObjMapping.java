package com.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//63. Demonstrate how to map objects from one type to another using Stream map().
public class ObjMapping {
	public static void main(String[] args) {
		List<People> person = Arrays.asList(
				new People("Surbhi" , 30),
				new People("Amit", 28),
				new People("Namu", 32),
				new People("Chandan", 38)
				);
		List<EmployeeDTO> emp =person.stream().map(p->new EmployeeDTO(p.name, p.age)).collect(Collectors.toList());
			emp.forEach(System.out::println);
	}

}
