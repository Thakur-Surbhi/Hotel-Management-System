package com.Stream;

public class EmployeeDTO {
	
	String fullName;
	int years;
	
	public EmployeeDTO(String fullName, int years) {
		this.fullName = fullName;
		this.years = years;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [fullName=" + fullName + ", years=" + years + "]";
	}
	

}
