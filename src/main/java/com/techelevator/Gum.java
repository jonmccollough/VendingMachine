package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Items {
	
	public Gum(String name ,BigDecimal price, String code, double quantity) {
		super(name, price, code, quantity);
	}
	
	public String toString() {
		return name + price + "Chew Chew, Yum!";
	}

}
