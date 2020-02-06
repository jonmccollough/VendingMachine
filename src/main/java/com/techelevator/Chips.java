package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Items {
	
	public Chips(String name ,BigDecimal price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return name + price + "Crunch Crunch, Yum!";
	}

}
