package com.yuvintech.spring.boot.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ScopeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ScopeApplication.class, args);
		
		Organization org1 = context.getBean("google", Organization.class);
		System.out.println(org1);
		
		Organization org2 = context.getBean("google", Organization.class);
		System.out.println(org2);
		
		Organization org3 = context.getBean("google", Organization.class);
		System.out.println(org3);
		
		Organization org4 = context.getBean("google", Organization.class);
		System.out.println(org4);
		
		System.out.println(context.getBean(Employee.class).getOrg());
		
		
		System.out.println( context.getBean(Summit.class).getOrg() );
		
		
		
	}
	
}
