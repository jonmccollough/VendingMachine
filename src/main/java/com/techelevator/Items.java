package com.techelevator;


abstract public class Items {

	protected String name;
	protected double price;
	protected String code;
	protected double quantity;
	protected Items selectedItmes;
	
	public Items(String name ,double price, String code, double quantity) {
		this.name = name;
		this.price = price;
		this.code = code;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCode() {
		return code;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Items getSelectedItmes() {
		return selectedItmes;
	}

	public void setSelectedItmes(Items selectedItmes) {
		this.selectedItmes = selectedItmes;
	}


}