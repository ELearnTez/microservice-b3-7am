package com.yuvin.springboot.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class A implements InitializingBean, DisposableBean { // 2006 - implements InitializingBean, DisposableBean 
	static {
		System.out.println("Static block");
	}
	
	{
		System.out.println("Instance Block");
	}
	
	A(){
		System.out.println("Constructor");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Just Now the constructor execution completes..");
	}

	@Override
	public void destroy() throws Exception {
		System.err.println("This Object is removing from Spring Context Pool.");
		
	}
	
	/**
	 * Don't use 
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("this is finalize..");
	}
	

}
