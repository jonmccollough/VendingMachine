package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {

		Chips Chips = new Chips("Lays", new BigDecimal(2), "A5", 2.0);  //Demo
		
		
		// File input
		try (File Scanner){
		
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("> (1) Display Vending Machine Items > (2) Purchase > (3) Exit >" );
		String direction = userInput.nextLine();
		
		if(direction.equals("1")) { // Display
			System.out.println( Chips.getName() + " " + Chips.getPrice() + " " + Chips.getCode() + " " + Chips.getQuantity() ); 
			
			
		} if(direction.equals("2")) { // Purchase
			
			
			
		} if(direction.equals("3")) { // Exit
			
			System.out.println("Exited menu");
			
		}	
		
	}

}
