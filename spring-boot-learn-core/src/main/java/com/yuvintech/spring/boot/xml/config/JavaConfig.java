package com.yuvintech.spring.boot.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public String message() {
		return "This is Java String Object";
	}
	
}
