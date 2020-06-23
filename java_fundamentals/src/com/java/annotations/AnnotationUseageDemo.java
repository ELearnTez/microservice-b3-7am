package com.java.annotations;


@Author(name = "SunilManaka")
public class AnnotationUseageDemo {
	
	@Author(name=" David")
	public AnnotationUseageDemo() {
		System.out.println(" Object Created");
	}
	
	
	@Author(name = "James", version = "1.0.9")
	private static final String text = "text";
	
	
	@Author(name = "Yuvin", version = "1.0.5")	
	//@Author(name = "SunilManaka", version = "1.0.0")
	public  void sayHello() {
		System.out.println("We are using the Annotation..!");
		
	}

}
