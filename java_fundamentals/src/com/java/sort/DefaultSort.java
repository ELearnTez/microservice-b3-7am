package com.java.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultSort {

	public static void main(String[] args) {
		
		//List<Integer> numbers = Arrays.asList(11,3,5,8,2,5,9);
		
		List<String> vegs = Arrays.asList("Broccoli","Cabbages", "Capsicums", "Carrots", "Cucumber", "Mushrooms");
		
		// jdk 1.7
		Collections.sort(vegs);
		for(String veg: vegs) {
			System.out.println(veg);
		}
		
		//java 1.8
		vegs.stream().sorted().forEach(veg -> System.out.println(veg));
		
	}
	
}
