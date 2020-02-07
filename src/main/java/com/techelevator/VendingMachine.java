package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		String vendingFile = "vendingmachine.csv";

		// File newFile = new File(pointer.getParent(), "Log.txt");

		// File input
		HashMap<String, Items> map = new HashMap<String, Items>();

		Scanner reader = new Scanner(new FileReader(vendingFile));

		while (reader.hasNextLine()) {

			String fileLine = reader.nextLine();
			String[] parts = fileLine.split("\\|");

			String code = parts[0];
			String name = parts[1];
			BigDecimal price = new BigDecimal(parts[2]);

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
			if (direction.equals("2")) { // Purchase

//				boolean purchaseExit = false;
//				while (!purchaseExit) {

					BigDecimal currentMoneyProvided = BigDecimal.ZERO;

					boolean moneyExit = false;
					try {
						while (!moneyExit) {
							System.out.println(
									"Please feed your money now or enter (d) when done. Current Money Provided: "
											+ currentMoneyProvided);

							String moneyInputed = userInput.nextLine();

							if (moneyInputed.equals("d")) {
								moneyExit = true;

							} else {

								BigDecimal moneyBigDec = new BigDecimal(Integer.parseInt(moneyInputed));

								currentMoneyProvided = currentMoneyProvided.add(moneyBigDec);
							}

						}
					} catch (NumberFormatException e) {
						System.out.println("Not valid input");
					}
					System.out.println("you exited the loop");
//				}
			}
			if (direction.equals("3")) { // Exit

				System.out.println("Exited menu");
		}
		

		}

		System.exit(0);
	}

}
