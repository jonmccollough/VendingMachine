package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items {
	
	public Candy(String name ,BigDecimal price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: " + quantity ;
	}
	
 // "Munch Munch, Yum!"
}
