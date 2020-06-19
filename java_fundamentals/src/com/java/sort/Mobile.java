package com.java.sort;

public class Mobile {
	
	public Mobile(String name, int price) {
      this.name = name;
      this.price = price;
	}
	
	private String name;
	
	private Integer price;
	
	private float customerReview;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [name=" + name + ", price=" + price + "]";
	}
	
	

}
