package com.techelevator;


public class Gum extends Items {
	
	public Gum(String name , double price, String code, double quantity, String endPhrase) {
		super(name, price, code, quantity, endPhrase);
	}
	
	public String toString() {
		return " " +name + " price: " + price + " quantity: " + quantity;
	}
  // "Chew Chew, Yum!"
}
