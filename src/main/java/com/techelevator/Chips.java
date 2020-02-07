package com.techelevator;


public class Chips extends Items {
	
	public Chips(String name ,double price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: "  + quantity;
	}

	public String endPhrase() {
		return "Crunch Crunch, Yum!";
	}
}
