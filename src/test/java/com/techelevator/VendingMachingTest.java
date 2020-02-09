package com.techelevator;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachingTest extends VendingMachine {

	VendingMachine vendingMaching = new VendingMachine();

	@Test
	public void fileTest() throws FileNotFoundException {
		String vendingFile = "vendingmachine.csv";
		Scanner reader = new Scanner(new FileReader(vendingFile));
		Assert.assertEquals("vendingmachine.csv", vendingFile);
	}
	
	@Test
	public void while_String_Array_Test() throws FileNotFoundException {
		String vendingFile = "vendingmachine.csv";
		Scanner reader = new Scanner(new FileReader(vendingFile));
		String fileLine = reader.nextLine();
		String[] parts = fileLine.split("\\|");
		String code = parts[0];
		String name = parts[1];
		double price = Double.parseDouble(parts[2]);
		Assert.assertEquals( 3.05, price, 0);
	}
	
	@Test
	public void while_Test() throws FileNotFoundException {
		Map<String, Items> map = new HashMap<String, Items>();
		String vendingFile = "vendingmachine.csv";
		Scanner reader = new Scanner(new FileReader(vendingFile));
		String fileLine = reader.nextLine();
		String[] parts = fileLine.split("\\|");
		double price = Double.parseDouble(parts[2]);
		Assert.assertEquals("Chip", parts[3]);
	}
	
	@Test
	public void chip_Map_Test() throws FileNotFoundException {
		Map<String, Items> map = new HashMap<String, Items>();
		String vendingFile = "vendingmachine.csv";
		Scanner reader = new Scanner(new FileReader(vendingFile));
		String fileLine = reader.nextLine();
		String[] parts = fileLine.split("\\|");
		String code = parts[0];
		String name = parts[1];
		double price = Double.parseDouble(parts[2]);
		Items chip = new Chips(name, price, code, 5);
		map.put(code, chip);
		Assert.assertEquals("A1", parts[0]);
		Assert.assertEquals("Potato Crisps", parts[1]);
	}
	
//	@Test
//	public void candy_Map_Test() throws FileNotFoundException {
//		Map<String, Items> map = new HashMap<String, Items>();
//		String vendingFile = "vendingmachine.csv";
//		Scanner reader = new Scanner(new FileReader(vendingFile));
//		String fileLine = reader.nextLine();
//		String[] parts = fileLine.split("\\|");
//		String code = parts[0];
//		String name = parts[1];
//		double price = Double.parseDouble(parts[2]);
//		Items candy = new Candy(name, price, code, 5);
//		map.put(code, candy);
//		Assert.assertEquals("B1", parts[0]);
//	}

}
