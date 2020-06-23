package com.java.annotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningDemo {

	@SuppressWarnings({"rawtypes","deprecation"})
	public static void main(String[] args) {
		
		
		List numbers = new ArrayList();
		
		Date date = new Date(01,01, 2202); 
		
		System.out.println(numbers+" - "+date);
		
	}
}
