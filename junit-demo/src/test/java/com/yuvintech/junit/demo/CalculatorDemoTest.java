package com.yuvintech.junit.demo;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorDemoTest {

	@Test
	public void testSumof2PositiveNumber() {
		CalculatorDemo calDemo = new CalculatorDemo();
		int number = calDemo.sum(2, 3);
		Assert.assertEquals(5, number);		
	}
	
	@Test
	public void testSumof2NegavtiveNumber() {
		CalculatorDemo calDemo = new CalculatorDemo();
		int number = calDemo.sum(-2, -3);
		Assert.assertEquals(-5, number);		
	}
	
	
}
