package com.yuvintech.spring.boot.methodinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;import org.springframework.stereotype.Component;

@SpringBootApplication
public class Solution2Main {
	
	public static void main(String[] args) {
		
		ApplicationContext conetxt = SpringApplication.run(Solution2Main.class, args);
		
		
		Solution2MovieReservation mr1 = conetxt.getBean(Solution2MovieReservation.class);
		
		Solution2MovieReservation mr2 = conetxt.getBean(Solution2MovieReservation.class);
		
		
		
		System.out.println(mr1.getSeat());
		
		System.out.println(mr2.getSeat());
		
	}

}
