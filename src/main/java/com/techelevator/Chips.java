package com.techelevator;


public class Chips extends Items {
	
	public Chips(String name ,double price, String code, double quantity, String endPhrase) {
		super(name, price, code, quantity, endPhrase);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: "  + quantity;
	}

	public String endPhrase() {
		return "Crunch Crunch, Yum!";
	}
}
