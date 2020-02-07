package com.techelevator;


public class Beverages extends Items {
	
	public Beverages(String name ,double price, String code, double quantity, String endPhrase) {
		super(name, price, code, quantity, endPhrase);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: " + quantity;
	}
 // "Glug Glug, Yum!"
}
