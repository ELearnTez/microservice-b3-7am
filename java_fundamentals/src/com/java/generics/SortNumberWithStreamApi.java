package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortNumberWithStreamApi {

	// 
	
	public static void main(String[] args) {
		
		List<Integer>  numbers = Arrays.asList(1, 2,3,4,5,6,7,9,10,8,13,16,17);
		
		/*
		Stream<Integer> numberStream = numbers.stream();
		
		Predicate<Integer> checkIsItEvenNumber = t  -> 	t % 2 == 0;
		
		Stream<Integer> evenNumbersStream =  numberStream.filter(checkIsItEvenNumber); // 2,4,6,8,16
		
		// function integer as input then double the value return that doubled 
		Function<Integer, Integer> doubleFuntion = t -> t * 2;
		
		//Each element on Stream 
		Stream<Integer> evenNumbersDoubledStream = evenNumbersStream.map(doubleFuntion); // 4,8,12,16,32
		
		Consumer<Integer> printData = t -> System.out.println(t);
		
		evenNumbersDoubledStream.forEach(printData);
		*/
		
		
		/* Phase -2 
		 * Stream<Integer> numberStream = numbers.stream();
		
		Stream<Integer> evenNumbersStream =  numberStream.filter( t  -> 	t % 2 == 0); // 2,4,6,8,16
		
		// function integer as input then double the value return that doubled 
		//Each element on Stream 
		Stream<Integer> evenNumbersDoubledStream = evenNumbersStream.map(t -> t * 2); // 4,8,12,16,32
		
		evenNumbersDoubledStream.forEach( t -> System.out.println(t));
		*/
		
		// Phase - 3 (Internal Loops) 1-> functional Coding , Readable 
		/*numbers.stream()
				.filter( t  -> 	t % 2 == 0)// 2,4,6,8,16
				.map(t -> t * 2)// 4,8,12,16,32
				.forEach( t -> System.out.println(t)); //print that info on console
				
				*/
		
		
		 
		 // JDK 1.0 --> Impartive Code Style
		/*
		 * List<Integer>  evenNumbers = new ArrayList<>();
		for(int i=0; i < numbers.size(); i++ ) {			
			int value = numbers.get(i);			
			if(value % 2 == 0) {
				value = value *2;
				evenNumbers.add(value);
			}			
		}	
		for(int i=0;i< evenNumbers.size();i++) {
             System.out.println(evenNumbers.get(i));
		}
		
		
		//Jdk 1.5 --> External Loops
		List<Integer>  evenNumbers2 = new ArrayList<>();
		for(int number: numbers) {
			if(number % 2 == 0) {
				number = number *2;
				evenNumbers.add(number);
			}	
		}		
		for(int i=0;i< evenNumbers.size();i++) {
            System.out.println(evenNumbers.get(i));
		}*/
		
		List<Integer> newData = evenDoubledNumbers(numbers);
		
	}
	
	
	// filter
	// map
	// collect
	// forEach
	
	// of()
	// flatMap
	// reduce
	
	
	public static List<Integer> evenDoubledNumbers(List<Integer> numbers){
		
		//List<Integer> evenDoubledNumbers = numbers.stream().filter(t -> t%2 ==0 ).map(t -> t *2).collect(Collectors.toList());
	    //	return evenDoubledNumbers;		
		return  numbers.stream().filter(t -> t%2 ==0 ).map(t -> t *2).collect(Collectors.toList());
		
	}
	
     public List<Integer> oddDoubledNumbers(List<Integer> numbers){
		return  numbers.stream().filter(t -> t%2 !=0 ).map(t -> t *2).collect(Collectors.toList());
		
	}
	
}
