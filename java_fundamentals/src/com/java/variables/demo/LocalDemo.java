package com.java.variables.demo;

public class LocalDemo {

	
	public void checkLocalScope() {
		  int i = 0;
		  String name = ""; // 200 MB
		
		System.out.println("i "+i);
	}
	
	
	
	public void accessIhere() {
		int i = 10;
	}
	
	
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		
		System.out.println(emp);
		
		
	} 
	
}
