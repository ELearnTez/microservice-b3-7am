package com.yuvintech.spring.boot.mobile.service;

public class ThreadLocalUtil {

	public static ThreadLocal<String> thredLocal = new  ThreadLocal<>(); 
	
	
	public static void setData(String data) {
		thredLocal.set(data);
	}
	
	public static String getData() {
		return thredLocal.get();
	}
	
	
	
}
