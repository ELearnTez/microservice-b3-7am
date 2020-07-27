package com.yuvintech.spring.boot.mobile.entity;

public enum LineOfBusiness {
	
	ONLINE(0),
	RETAIL(1),
	INDIRECT(2);
	
	private int value;
	
	private LineOfBusiness(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	
}
