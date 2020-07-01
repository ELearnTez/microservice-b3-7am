package com.yuvin.springboot.autowire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main  {
	
	
	
	public static void main(String[] args) {
		 ApplicationContext context =  SpringApplication.run(Main.class, args);
		 
		// IndianMarriage marriage =context.getBean("indianMarriage",IndianMarriage.class);
		// System.err.println("IndianMarriage Music "+marriage.getMusic() +" - Decoration: "+marriage.getDecoration());
		 
		 
		// WesternMarriage westernMarriage =context.getBean("westernMarriage",WesternMarriage.class);
		// System.err.println("WesternMarriage Music "+westernMarriage.getMusic() +
		//		 " WesternMarriage - Decoration: "+westernMarriage.getDecoration());
		 
		 
		 // Devloper 
		// Marriage AMmarriage = new  Marriage(); // JAVA 
		// System.err.println("Music Dev "+AMmarriage.getMusic() +" - Decoration DEV : "+AMmarriage.getDecoration());
	}

	
	
	
	
	
	
	
	
	
}
