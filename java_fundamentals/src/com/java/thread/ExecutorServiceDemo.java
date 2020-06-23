package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	
	public static void main(String[] args) {
		
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		for(int i =0;i< 1000 ; i++) {
			
			final int j = i;
			
			Runnable  task = () -> System.out.println(j+ "This is Done By a separate Thread "+ Thread.currentThread().getName()); 
			
			//Thread thread = new Thread(task);
			
			//thread.start();
			threadPool.submit(task);
		}
		
		System.out.println("Main Thread "+ Thread.currentThread().getName());
		
		
		//threadPool.shutdown();
	}
	
}
