package com.yuvintech.spring.boot.circular;

public class PaymentProcesser {

	private OrderConfirmation oc;

	public OrderConfirmation getOc() {
		return oc;
	}

	public void setOc(OrderConfirmation oc) {
		this.oc = oc;
	}

	public PaymentProcesser() {
		System.out.println("Thread "+Thread.currentThread().getName());
		
	}
	
	
	
	
	
}
