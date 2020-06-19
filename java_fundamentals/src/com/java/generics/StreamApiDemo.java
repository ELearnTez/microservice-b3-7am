package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApiDemo {
	
	
	public static void main(String[] args) {
		List<String> veg = Arrays.asList("Broccoli","Cabbages", "Capsicums", "Carrots", "Cucumber", "Mushrooms");
		List<String> fruits = Arrays.asList("Apple", "Blackberries", "Blueberries", "Cherries","Guava");
		
		List<List<String>> vegAndFruits = new ArrayList<>();
		vegAndFruits.add(veg);
		vegAndFruits.add(fruits);

		/*
		for(List<String> list: vegAndFruits) {
         for(String eachElement: list) {
        	 System.out.println(eachElement);
         }			
		}
		*/
		
		vegAndFruits.stream().map(list -> list.stream()).forEach(i -> System.out.println(i));
		
		// reference list 
		// 
		System.out.println("----------------------------------------------------------------");
		
		vegAndFruits.stream().flatMap(list -> list.stream()).forEach(i -> System.out.println(i));
		
	}

}
