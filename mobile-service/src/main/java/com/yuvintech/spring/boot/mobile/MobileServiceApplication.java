package com.yuvintech.spring.boot.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.yuvintech.msk.common.entity")
public class MobileServiceApplication {
	
	
    public static void main(String[] args) {
		SpringApplication.run(MobileServiceApplication.class, args);
	}

	
    
	
	
}
