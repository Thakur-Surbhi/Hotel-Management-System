package Java8_Pratiksha;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpProgram {
	public static void main(String[] args) {
		List<Employee> empList = 
				Arrays.asList(new Employee (1, "Yanksha", 28, 123, "F", "HR", "Mumbai", 2010),
						new Employee (2, "Franscesca", 27, 120, "M", "HR", "Hydrabad", 2011),
						new Employee (3, "Ramesh", 30, 140, "M", "Admin", "Mumbai", 2008),
						new Employee (4, "Saurabh", 34, 129, "M", "IT", "Pune", 2014),
						new Employee (5, "Surbhi", 30, 145, "F", "Admin", "Pune", 2019),
						new Employee (6, "Namu", 32, 160, "F", "HR", "Bhopal", 2015),
						new Employee (7, "AMit", 28, 150, "M", "IT", "Mumbai", 2011),
						new Employee (8, "Abhilash", 32, 190, "M", "HR", "Chennai", 2012),
						new Employee (9, "Megharaj", 36, 195, "F", "IT", "Hydrabad", 2017)
						);

		//1 Group by city
		Map<String, List<Employee>> empByCity =empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Employe Group By city : \n"+empByCity);

		//2 Group by age
		Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("\nEmployee Group By age : \n"+empByAge);

		//3 Count of male and female employee
		Map<String, Long> noOfmaleAndFemale = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("\nNo of Male and Female in Organization : "+noOfmaleAndFemale);

		//4 Count of male and female in each department
		Map<String, Map<String, Long>> genderMapInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("\nMale and female in each department : "+genderMapInDept);

		// 5. All Distinct Department
		System.out.println("\nName of all department in organization : ");
		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

		//6 all empl details whose age is greater than 28
		System.out.println("\nEmployee details having age greater than 28 : ");
		empList.stream().filter(e->e.getAge()<28).collect(Collectors.toList()).forEach(System.out::println);

		//7 Find Maximun age/ oldest of employee in organization
		Optional<Employee> maxAge = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("\nOldest Emp all deatils : "+maxAge.get());
		OptionalInt max1 =empList.stream().mapToInt(Employee::getAge).max();
		if(max1.isPresent())
			System.out.println("\nOldest Emp on Other way : "+max1.getAsInt());

		//8 Average age of Male n femal
		Map<String, Double> avgAge =empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("\nAverage age of male and femal : "+avgAge);


		//9. Average age of Male n femal in each department
		Map<String, Map<String, Double>> avgAgeDept =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
		avgAgeDept.forEach((dept, age)->System.out.println("\nDepartment Average age  : "+dept+"  : "+age));

		//10 Print No of emp in each dept
		Map<String, Long> countByDEpt =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("\nNo of emp in each dept");
		for(Map.Entry<String, Long> entry : countByDEpt.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}

		//11 Longest Serving employee
		Optional<Employee> LongestServedEmp =empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		System.out.println("\nLongest Serving employee : "+LongestServedEmp);

		//12 Longest Serving employee by dept
		System.out.println("\nLongest Serving employee by dept : \n");
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)))).forEach((dept, empOpt)->System.out.println(dept+" : "+empOpt));;

		//13 Find average age of gender in each dept
		Map<String, Map<String, Double>> avgAgeByDept =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
		avgAgeByDept.forEach((Dept, Age)->System.out.println("Average age of gender in each Dept : "+Dept+" : "+Age));

		//14 Find youngest Female emplyee 
		Optional<Employee> YoungestFemaleEmp = empList.stream().filter(e->e.getGender()=="F").min(Comparator.comparingInt(Employee::getAge));
		System.out.println("youngest Female emplyee : "+YoungestFemaleEmp.get());

		//15 Youngest Employee in each department
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, 
				Collectors.maxBy(Comparator.comparing(Employee::getYearOfJoining))))
		.forEach((dept, empOpt)->empOpt.ifPresent(
				emp->System.out.println(
						dept+"-> "+emp.getName()+"(DOJ-"+emp.getYearOfJoining()+")")));;

						
		//16 Find the employee whose age is greater than 30 and less than 30
		System.out.println("\nEmployee whose age is greater than 30 and less than 30");
		Map<Boolean, List<Employee>> partitionEmpByAge =empList.stream().collect(Collectors.partitioningBy(e->e.getAge()>30));

		Set<Map.Entry<Boolean, List<Employee>>> empSet =partitionEmpByAge.entrySet();
		for(Entry<Boolean, List<Employee>> entry :empSet) {
			if(Boolean.TRUE.equals(entry.getKey())) {
				System.out.println("Employee Greater than 30 : "+entry.getValue());
			}
			else {
				System.out.println("Employee less than 30 : "+entry.getValue());
			}
		}
		
		//17 Find the department name which has the highest number of employee
		Map.Entry<String, Long> maxNoOfEmpInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("\nMax number of employee in each department : "+maxNoOfEmpInDept);
		
		//18 Find if there is any employee in HR department
		Optional<Employee> HREmp = empList.stream().filter(e->e.getDeptName().equalsIgnoreCase("HR")).findAny();
		System.out.println(HREmp);
		
		//19 Find the dept name that these employee work for, Where the no of emp os over 3
		System.out.println("\nDept Name where no of employee works is over 3 :: ");
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>3).forEach(System.out::println);
		
		//20 Find all empl who live in pune , sort by name and print the name of employee
		empList.stream().filter(e->e.getCity().equalsIgnoreCase("Pune"))
		.sorted(Comparator.comparing(Employee::getName)).forEach(e->System.out.println("Employee staying in Pune : "+e.getName()));

		//21 No of emp in organization
		Long empCount = empList.stream().count();
		System.out.println("No of emp in organization : "+empCount);
		
		//22 Find emp count in every dept
		System.out.println("\nemp count in every dept : ");
		Map<String, Long>  empCountInDept=empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		//.entrySet().stream().forEach(System.out::println);
		empCountInDept.forEach((k, v)->System.out.println(k+" : "+v));		
		
		//23 Find the Department which has a highest employee 
		Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = empCountInDept.entrySet().stream().max(Map.Entry.comparingByValue());
		if(deptNameWithHighestEmp.isPresent()) {
			System.out.println("\nDepartment Name with highest employee : "+deptNameWithHighestEmp.get());
		}
		
		//24 Find a stream by age and name field
		System.out.println("Sorting based on name and age : ");
		Comparator<Employee> comp1 = Comparator.comparing(Employee::getAge);
		Comparator<Employee> comp2 = Comparator.comparing(Employee::getName);
		empList.stream().sorted(comp1.thenComparing(comp2)).forEach(System.out::println);
		
		System.out.println("Sorted a stream by Age and Name ");
		empList.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName)).forEach(System.out::println);		
		
		// 25 Print average and total salary of organization
		DoubleSummaryStatistics empSal1  = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average sal of emp : "+empSal1.getAverage());
		System.out.println("Total Sal of emp : "+empSal1.getSum());
		
		// 26 print the avg salary of each dept
		System.out.println("print the avg salary of each dept ");
		Map<String, Double> avgSal = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
				//.entrySet().stream().forEach(System.out::println);
		
		  Set<Map.Entry<String, Double>> entrySet =avgSal.entrySet();
		  for(Map.Entry<String, Double> entry :entrySet) {
		  System.out.println(entry.getKey()+" : "+entry.getValue()); }
		 
		  //27 print average salaray by gender in each dept
		  System.out.println("\nprint average salaray by gender in each dept");
		  empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))).entrySet().stream().forEach(System.out::println);		
	
		  //28 To get the list of employee from each dept whose sslary is greater than the average salary of their dept
			
			
			/*
			 * empList.stream().filter(e->e.getSalary()>averageMap.get(e.getDeptName())).
			 * collect(Collectors.groupingBy(Employee::getDeptName)) .forEach((dept,
			 * empListAboveAvg)->{ System.out.
			 * println("employee from each dept whose sslary is greater than the average salary of their dept"
			 * +dept); empListAboveAvg.forEach(e->System.out.println(""+e.getName()+"-> "+e.
			 * getSalary())); });
			 */
			 
		  //29 Highest Salary in the organization
		 Optional<Employee> highestSal= empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
		//empList.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);	
		 System.out.println("\nHighest salary : "+highestSal.get().getSalary());
		  
			 //30 Second Highest Sala
		 Optional<Employee> SecondHighestSal= empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();		  
		 System.out.println("\nSecondHighest salary : "+SecondHighestSal.get().getSalary());
	
		 //31 Nth Highest Salary
		 int n=8;
		 Optional<Employee> N_HighestSal= empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(n-1).findFirst();		  
		 System.out.println("\nN_Highest salary : "+N_HighestSal.get().getSalary());
	
		 //32 Top 3 Highest Salary earned employee
		 System.out.println("\nTop 3 Highest Salary earned employee : \n");
		 empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
		
		 //33 Print Top 2 Highest Salary Earned employee in Each Dept
		 System.out.println("\n Top 2 by Dept");
		 empList.stream()
		 .collect(Collectors.groupingBy(Employee::getDeptName))
		 .forEach((Dept, emp)-> {
			 emp.stream()
				 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				 .limit(2)
				 .forEach(System.out::println);
		 });
	
		 //34 Highest Paid salary in organization based on gender
		 //Map<String, Optional<Employee>> emp1 =
				 empList.stream()
				 .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
				 .forEach((gen, salDetail)->System.out.println(gen+" : "+salDetail));
		 
		 
	
	}
}
