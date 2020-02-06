package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Items {
	
	public Beverages(String name ,BigDecimal price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return " " + name + " price: " + price + " quantity: " + quantity;
	}
 // "Glug Glug, Yum!"
}
