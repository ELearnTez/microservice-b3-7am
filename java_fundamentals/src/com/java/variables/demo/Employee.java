package com.java.variables.demo;

public class Employee {

	// Class Loading 
	static {
		System.err.println("This is Static Block1 "); // Driver Class - JDBC API 
		                                              // native Library -
													  // DataSource
		                                              // MQ
	}
	
	static {
		System.err.println("This is Static Block2");
	}
	
	static String companyName; // initialize
	// Class Loading 
	
	//Instance Loading
	{
		System.err.println("This is instance Block1 ");
	}
	
	{
		System.err.println("This is instance Block2 ");
	}
	private String name;// initialize
	private int id;//0 initialize	
	//Instance Loading
	
	
	Employee(){
		
		//...
	}
	
	Employee(String name, int id){
		this.name = name;
		this.id = id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getCompantName() {
		return companyName;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "] - compantName: "+companyName ;
	}
	
	
	
	
}
