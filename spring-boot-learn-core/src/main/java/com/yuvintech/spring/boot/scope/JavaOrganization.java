package com.yuvintech.spring.boot.scope;

public class JavaOrganization {

	private static final JavaOrganization javaOrganization = new JavaOrganization(); 
	
	private JavaOrganization() {}
	
	public static JavaOrganization javaOrganization() {
		return javaOrganization;
	}
	
}
