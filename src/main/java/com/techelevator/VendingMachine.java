package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		String vendingFile = "vendingmachine.csv";

		// File newFile = new File(pointer.getParent(), "Log.txt");

		// File input
		Map<String, Items> map = new HashMap<String, Items>();

		Scanner reader = new Scanner(new FileReader(vendingFile));

		while (reader.hasNextLine()) {

			String fileLine = reader.nextLine();
			String[] parts = fileLine.split("\\|");

			String code = parts[0];
			String name = parts[1];
			double price = Double.parseDouble(parts[2]);

			if (parts[3].equals("Chip")) {
				Items chip = new Chips(name, price, code, 5);
				map.put(code, chip);
			}

			if (parts[3].equals("Candy")) {
				Items candy = new Candy(name, price, code, 5);
				map.put(code, candy);
			}

			if (parts[3].equals("Drink")) {
				Items drink = new Beverages(name, price, code, 5);
				map.put(code, drink);
			}

			if (parts[3].equals("Gum")) {
				Items gum = new Gum(name, price, code, 5);
				map.put(code, gum);
			}
		}

//		System.out.println(map);

		boolean exit = false;

		while (!exit) {

			System.out.println("> (1) Display Vending Machine Items > (2) Purchase > (3) Exit >");
			String direction = userInput.nextLine();

			if (direction.equals("1")) { // Display
				for (String key : map.keySet()) {
					System.out.println(key + ":" + map.get(key));
				}
			} 
			double currentMoneyProvided = 0;
			
			if (direction.equals("2")) { // Purchase
				boolean purchaseExit = false;
				try {
					while (!purchaseExit) {

						boolean moneyExit = false;
						try {
							while (!moneyExit) {
								System.out.println("Please feed your money now or enter (d) when done. Current Money Provided: "
								+ currentMoneyProvided);

								String moneyInputed = userInput.nextLine();

								if (moneyInputed.equalsIgnoreCase("d")) {
									moneyExit = true;

								} else {

									double moneyBigDec = Double.parseDouble(moneyInputed);

									currentMoneyProvided = currentMoneyProvided + moneyBigDec;
								}

							

						} 

						for (String key : map.keySet()) {
							System.out.println(key + ":" + map.get(key));
						}

						System.out.println("\n" + "Please make your selection and enter code.");
						String userSelection = userInput.nextLine();
						Items selectedItem = map.get(userSelection);

						if (selectedItem == null) {
							System.out.println("Selection does not exist");
							
						}else if ( currentMoneyProvided >= selectedItem.getPrice() ) {
						
							currentMoneyProvided -= selectedItem.getPrice() ;
							
						
							System.out.println( selectedItem.getName() + " Price: " + selectedItem.getPrice() + " Money Remaining: " + currentMoneyProvided);
						
							if (selectedItem.getCode().contains("A") ) {
								System.out.println("Crunch Crunch, Yum!");
							}

							if (selectedItem.getCode().contains("B") ) {
								System.out.println("Munch Munch, Yum!");
							}

							if (selectedItem.getCode().contains("C") ) {
								System.out.println("Glug Glug, Yum!");
							}

							if (selectedItem.getCode().contains("D") ) {
								System.out.println("Chew Chew, Yum!");
							}
						
						} else if (currentMoneyProvided < selectedItem.getPrice()) {
							System.out.println("Insufficient Funds");
						}
						
						} catch (NumberFormatException e) {
							System.out.println("Not valid input");
						}
						
						
					} //purchase exit end
				
			} catch (NumberFormatException e) {
				System.out.println("Not valid input");
			}
			}
			if (direction.equals("3")) { // Exit

				System.out.println("Exited menu");
				//dispense change
				System.exit(0);
			}
		
			}

		System.exit(0);
	}

}
