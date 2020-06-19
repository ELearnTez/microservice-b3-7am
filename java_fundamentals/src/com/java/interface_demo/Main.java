package com.java.interface_demo;

public class Main {
	
	public static void main(String[] args) {
		
		Calculator c1  = new Calculator() {
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	
		// InvokeDynamic - Kotlin
		//Calculator c1 = (a, b) -> a+b; // Implementation 1
		
		
		Calculator c2 = ( a, 	 b) ->  0;
		
	}
	
	//public static Calculator object() {
		//......................
	//}

	
	
	
}
