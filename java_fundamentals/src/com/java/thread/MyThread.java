package com.java.thread;

public class MyThread {

    
  public static void main(String[] args) {
	
	   Runnable runnable =  ()  -> System.out.println("Can u print this line by using a new Thread : "+ Thread.currentThread().getName());
		
	   Thread thread = new Thread(runnable);
	   thread.start();
	   
	   
	   System.out.println("Main Method ..  "+ Thread.currentThread().getName());
	   
	   Thread thread1 = new Thread(runnable);
	   thread1.start();
	}

}