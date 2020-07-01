package com.yuvin.springboot.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Main.class, args);
		
		A a = context.getBean(A.class);
		System.gc();// memory 
		
	}
}
