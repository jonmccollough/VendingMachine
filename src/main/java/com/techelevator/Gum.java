package com.techelevator;


public class Gum extends Items {
	
	public Gum(String name , double price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " +name + " price: " + price + " quantity: " + quantity;
	}

	public String endPhrase() {
		return "Chew Chew, Yum!";
	}
}
