package com.yuvintech.spring.boot.methodinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BestPractiseJavaConfig {

	@Bean
	public ProblemMovieReservation movieReservation() {
		return new ProblemMovieReservation() {
			@Override
			public Seat getSeat() {
				return seat();
			}
			
		};
	}
	
	@Bean
	@Scope("prototype")
	public Seat seat() {
		return new Seat();
	}
	
	
}
