package com.techelevator;


public class Beverages extends Items {
	
	public Beverages(String name ,double price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: " + quantity;
	}
	
	public String endPhrase() {
		return "Glug Glug, Yum!";
	}

}

