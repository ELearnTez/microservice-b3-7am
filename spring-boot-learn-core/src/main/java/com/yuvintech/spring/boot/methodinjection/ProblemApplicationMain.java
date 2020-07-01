package com.yuvintech.spring.boot.methodinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProblemApplicationMain {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProblemApplicationMain.class, args);
		
		ProblemMovieReservation movieReservation1 = context.getBean("movieReservation",ProblemMovieReservation.class);
		  
		ProblemMovieReservation movieReservation2 = context.getBean("movieReservation",ProblemMovieReservation.class);
		
		System.out.println(movieReservation1.getSeat());
		
		System.out.println(movieReservation2.getSeat());
		
	}
	
}
