package com.yuvintech.spring.boot.circular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public PaymentProcesser pp(){
		System.out.println("Thread "+Thread.currentThread().getName());
		PaymentProcesser pp = new PaymentProcesser(); 
		pp.setOc(oc());
		return pp;
	}	
	@Bean
	public OrderConfirmation oc() {
		System.out.println("Thread "+Thread.currentThread().getName());
		OrderConfirmation oc=  new OrderConfirmation();
		oc.setPp(pp());
		return oc;
	}	
}
