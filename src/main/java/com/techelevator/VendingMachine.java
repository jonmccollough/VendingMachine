package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		String vendingFile = "vendingmachine.csv";

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
		reader.close();


		boolean exit = false;

		Purchase p = new Purchase();

		while (!exit) {

			System.out.println("> (1) Display Vending Machine Items > (2) Purchase > (3) Exit >");
			String direction = userInput.nextLine();

			if (direction.equals("1")) { // Display
				for (String key : map.keySet()) {
					System.out.println(key + ":" + map.get(key));
				}
			}

			if (direction.equals("2")) { // Purchase
				boolean purchaseExit = false;
				try {
					while (!purchaseExit) {

						boolean moneyExit = false;
						try {
							while (!moneyExit) {
								System.out.println(

										"Please feed your money ($1, $2, $5, or $10) now or enter (d) when done. Current Money Provided: "

												+ p.getCurrentMoneyProvided());

								String moneyInputed = userInput.nextLine();

								
								
								if (!moneyInputed.equals("1") && !moneyInputed.equals("2") && !moneyInputed.equals("5")
										&& !moneyInputed.equals("10") && !moneyInputed.equals("d")) {
									System.out.println("Invalid bill, try again.");
									continue;
									
								} if (moneyInputed.equalsIgnoreCase("d")) {
									moneyExit = true;

								}else {

									File logFile = new File("Log.txt"); // For logFile
									SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									Date dateAndTime = new Date();
									try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {

										writer.print(" > " + formatter.format(dateAndTime) + " FEED MONEY ");
										writer.print(p.getCurrentMoneyProvided() + " ");


										double moneyBigDec = Double.parseDouble(moneyInputed);

										p.setCurrentMoneyProvided(p.getCurrentMoneyProvided() + moneyBigDec);

										writer.print(p.getCurrentMoneyProvided() + " > ");

									} catch (IOException e) {
										System.out.println("Error printing FEED MONEY to log");
										e.printStackTrace();
									}
								}

							}

							for (String key : map.keySet()) {
								System.out.println(key + ":" + map.get(key));
							}

							System.out.println(
									"\n" + "Please make your selection and enter code or enter (d) when done.");
							String userSelection = userInput.nextLine();
							Items selectedItem = map.get(userSelection);

							if (userSelection.equalsIgnoreCase("d")) {
								purchaseExit = true;
								break;
							}

							if (selectedItem == null) {
								System.out.println("Selection does not exist");

							} else if (p.getCurrentMoneyProvided() >= selectedItem.getPrice()) {


								if (selectedItem.getQuantity() <= 0) {
									System.out.println("Item is SOLD OUT");
									break;
								}
				
								File logFile = new File("Log.txt"); // For logFile

								SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
								Date dateAndTime = new Date();

								try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {

									writer.print(" > " + formatter.format(dateAndTime) + " ");
									writer.print(selectedItem.getName() + " " + selectedItem.getCode() + " ");
									writer.print(p.getCurrentMoneyProvided());

									p.setCurrentMoneyProvided(p.getCurrentMoneyProvided() - selectedItem.getPrice());
									selectedItem.setQuantity(selectedItem.getQuantity() - 1);

									writer.print(p.getCurrentMoneyProvided());

								} catch (IOException e1) {
									System.out.println("Error printing purchase to log");
									e1.printStackTrace();
								}


								System.out.println(selectedItem.getName() + " Price: " + selectedItem.getPrice()
										+ " Money Remaining: " + p.getCurrentMoneyProvided());

								if (selectedItem.getCode().contains("A")) {
									System.out.println("Crunch Crunch, Yum!");
								}

								if (selectedItem.getCode().contains("B")) {
									System.out.println("Munch Munch, Yum!");
								}

								if (selectedItem.getCode().contains("C")) {
									System.out.println("Glug Glug, Yum!");
								}

								if (selectedItem.getCode().contains("D")) {
									System.out.println("Chew Chew, Yum!");
								}

							} else if (p.getCurrentMoneyProvided() < selectedItem.getPrice()) {
								System.out.println("Insufficient Funds");
							}

						} catch (NumberFormatException e) {
							System.out.println("Not valid input");
						}

					} // purchase exit end

				} catch (NumberFormatException e) {
					System.out.println("Not valid input");
				}

			}

			if (direction.equals("3")) { // Exit

				double nickels = 0;
				double dimes = 0;
				double quarters = 0;


				File logFile = new File("Log.txt"); // For logFile
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date dateAndTime = new Date();
				try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {

					writer.print(" > " + formatter.format(dateAndTime));
					writer.print(" GIVE CHANGE: ");
					writer.print(p.getCurrentMoneyProvided() + "  ");

					while (p.getCurrentMoneyProvided() >= .25) {
						quarters++;
						p.setCurrentMoneyProvided(p.getCurrentMoneyProvided() - .25);
					}
					while (p.getCurrentMoneyProvided() >= .10) {
						dimes++;
						p.setCurrentMoneyProvided(p.getCurrentMoneyProvided() - .10);
					}
					while (p.getCurrentMoneyProvided() >= .05) {
						nickels++;
						p.setCurrentMoneyProvided(p.getCurrentMoneyProvided() - .05);
					}

					writer.print(p.getCurrentMoneyProvided() + " > ");

				} catch (IOException e) {
					System.out.println("Error printing CHANGE to log");
					e.printStackTrace();

				}

				System.out.println("Quarters " + quarters + " Dimes " + dimes + " Nickels " + nickels);
				p.setCurrentMoneyProvided(0);
				System.out.println("Exited menu");
				// dispense change

			}

		}

		userInput.close();

	}
}
