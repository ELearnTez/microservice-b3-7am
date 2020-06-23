package com.java.exception;

public class AgeTest {
	
	public static void main(String[] args) {

		System.out.println(isValidAge(95));
	}

	
	// throws key word, try/catch 
	public static boolean isValidAge(int age){

			  if(age < 18){
				throw new MinAgeException("Please reach us after you cross 18 years.");
			  }

			  
			  return true;
	}
}
