package com.techelevator;

public class Purchase {

	public double balance;
	

	public String getChange(double balance){
		
		double nickels = 0;
		double dimes = 0;
		double quarters = 0;
				
		while (balance >= .25) {
			quarters ++;
			balance -= .25;
		}
		while (balance >= .10) {
			dimes ++;
			balance -= .10;
		}
		while (balance >= .05) {
			nickels ++;
			balance -= .05;
		}
		return "Quarters " + quarters + " Dimes " + dimes + " Nickels " + nickels;
		}
}
