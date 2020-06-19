package com.java.generics;

import java.util.function.Function;

// One Argument as Input, and Any Argument as output
public interface GenericFunctionalDemo {



	
	
	public static void main(String[] args) {
	
		//String as Input, and one String as output
		Function<String, String> gd = t  -> t.toLowerCase();
		
		//String as Input, and one Integer as output
		Function<String, Integer> gd1 = t  -> t.length();
		
	}
	
}


