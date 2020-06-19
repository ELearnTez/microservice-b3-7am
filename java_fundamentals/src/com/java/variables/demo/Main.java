package com.java.variables.demo;

public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException {
		
		//Class.forName("com.java.variables.demo.Employee"); // Loading the class into memory
		
		//Loading the class into memory - static
		// Creating Object - instance 
		Employee emp = new Employee();
		
		
	}
	
	
	
	
	public static void main_15_June(String[] args) {
		
		Employee.getCompantName();
		
		Employee emp1 = new Employee("Sunil", 10001);
		
		//emp1.getCompantName();
		
		System.out.println(emp1);
		
		Employee emp2 = new Employee("Anil", 10002);		
		System.out.println(emp2);
		
		Employee emp3 = new Employee("James", 10003);		
		System.out.println(emp3);
		
		Employee emp4 = new Employee("Adom", 10004);		
		//emp4.setCompantName("Microsoft");
		
		System.out.println(emp4);
		System.out.println(emp1);
		System.out.println(emp2);
		
		
		/// 9999
		
      Employee emp10000 = new Employee("Kathy", 10005);		
		System.out.println(emp10000);
		
		
	}
}
