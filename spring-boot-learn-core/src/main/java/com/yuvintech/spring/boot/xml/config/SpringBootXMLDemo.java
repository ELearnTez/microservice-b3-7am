package com.yuvintech.spring.boot.xml.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "spring-boot-xml-config.xml") // XML
@Import(value = JavaConfig.class)  // Loading Java Configuration
public class SpringBootXMLDemo {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootXMLDemo.class, args);
		
		
		//Spring Container
		HelloWorld hw = context.getBean("helloWorld",HelloWorld.class);
		
		System.out.println(
				
				hw.getMessage()
				);
		
		
	}
	
}
