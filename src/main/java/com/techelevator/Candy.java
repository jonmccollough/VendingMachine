package com.techelevator;


public class Candy extends Items {
	
	public Candy(String name ,double price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: " + quantity;
	}
	
	public String endPhrase() {
		return "Munch Munch, Yum!";
	}
}
