package edu.kh.jsp.model.dto;

public class Pizza {

	private String name; 
	private int price;
	 
	public Pizza() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Pizza(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
	
}
