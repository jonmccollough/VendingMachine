package com.techelevator;

import java.math.BigDecimal;

abstract public class Items {

	protected String name;
	protected BigDecimal price;
	protected String code;
	protected double quantity;

	public Items(String name ,BigDecimal price, String code, double quantity) {
		this.name = name;
		this.price = price;
		this.code = code;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCode() {
		return code;
	}

	public double getQuantity() {
		return quantity;
	}


}