package com.yuvintech.spring.boot.scope;



public class Organization {
	
	public Organization() {
	  System.err.println("Organization object created..");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	

}
