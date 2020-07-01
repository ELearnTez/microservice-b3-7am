package com.yuvintech.spring.boot.xml.config;

public class HelloWorld {
	
	private String message = "Hi Friend Welcome to Spring";

	public HelloWorld() {
		System.out.println("HelloWorld Instantiation . Exectuing Zero Arg Constructor ..!");
	}
	
	public HelloWorld(String message) {
		System.out.println("HelloWorld Instantiation . Exectuing Zero Arg Constructor ..!");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
