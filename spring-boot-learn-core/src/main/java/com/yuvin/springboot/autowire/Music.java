package com.yuvin.springboot.autowire;

public class Music {
	
    private String name= "Classic";
  
    Music(){
    	System.out.println("music zero arg constructor..!");
    }
    
	@Override
	public String toString() {
		return "MusicDept [" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
