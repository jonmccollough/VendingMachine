package com.techelevator;


public class Gum extends Items {
	
	public Gum(String name , double price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " +name + " price: " + price + " quantity: " + quantity;
	}
<<<<<<< HEAD

	public String endPhrase() {
		return "Chew Chew, Yum!";
	}
=======
>>>>>>> dc42b347731a3b4907f961d77c5c4d6ad6e53b8e
}
