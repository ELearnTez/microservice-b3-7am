package com.yuvintech.spring.boot.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
	

	@Bean
	//@Scope("prototype")
	public Organization google() {
		Organization google = new Organization();
		google.setName("google");
		return google;
	}
	
	
	@Bean
	@Scope("singleton")
	public Organization microsoft() {
		Organization mirosoft = new Organization();
		mirosoft.setName("microsoft");
		return mirosoft;
	}
	

}
