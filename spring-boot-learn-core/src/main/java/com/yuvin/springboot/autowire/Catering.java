package com.yuvin.springboot.autowire;

public class Catering {

	private String name;
	
	public Catering(String name) {
	 this.name = name;
	}

	@Override
	public String toString() {
		return "Catering [" + name + "]";
	}
	
	
	

}
