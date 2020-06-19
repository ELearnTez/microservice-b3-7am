package com.java.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

		Stream.of(1,2,3,4,5,6,7,8,9).forEach(number -> System.out.println(number));
		
		
		 
		int total = numbers.stream().reduce(0 ,(sum, number) -> sum= sum+number );
		//System.out.println(total);
		
		
		System.out.println(
				
				numbers.stream().reduce(0 ,(sum, number) -> sum= sum+number )
				
				
				);
		
	}

}
