package com.yuvintech.spring.boot.circular;

public class OrderConfirmation {
 
	private PaymentProcesser pp;

	public PaymentProcesser getPp() {
		return pp;
	}

	public void setPp(PaymentProcesser pp) {
		this.pp = pp;
	}
	
	public OrderConfirmation() {
		System.out.println("Thread "+Thread.currentThread().getName());
	}
	
	
	
}
