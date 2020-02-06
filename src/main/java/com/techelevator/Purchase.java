package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Purchase {
	public static void main(String[] args) {

			
			boolean exit = false;
		
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("Please make a selection: (1) Feed Money (2) Select Product (3) Finish Transaction");
			String selection = userInput.nextLine();
			
			while (!exit) {
				
			BigDecimal feedMoney =  BigDecimal.ZERO;
			
			if (selection.equals("1")) {
				
			}
			if (selection.equals("2")) {

			}
			if (selection.equals("3")) {
				
				
				exit = true;
			}
//			userInput.close();
		}

	}

}