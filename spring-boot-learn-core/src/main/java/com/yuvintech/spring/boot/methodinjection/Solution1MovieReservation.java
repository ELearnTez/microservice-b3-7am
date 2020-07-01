package com.yuvintech.spring.boot.methodinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class Solution1MovieReservation implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	public Seat getSeat() {
		return this.applicationContext.getBean("seat", Seat.class);// Dependency Lookup
	}

	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
