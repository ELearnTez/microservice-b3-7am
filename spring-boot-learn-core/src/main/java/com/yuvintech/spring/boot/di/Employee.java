package com.yuvintech.spring.boot.di;

public class Employee {
	
	public Employee(String name, int empId) {
		this.name = name;
		this.empId = empId;
	}
	
	private String name;
	
	private int empId;
	
	private String workSpace;

	public String getName() {
		return name;
	}

	public int getEmpId() {
		return empId;
	}

}
