package bankAccountApp;

import java.util.Random;

public class CurrentAccount extends Account {

	
	// List the properties specific to a current account
	private long debitCardNumber;
	private int debitCardPin;
	
	
	// Constructor to initialize current account properties
	public CurrentAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = (getBaseRate() * 15 / 100);
	}
	 
	
	// List any methods specific to the current account
	private void setDebitCard() {
		debitCardNumber += (long) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public String showInfo() {
		return super.showInfo() +
				"\nCurrent Account Features: " + 
				"\n  Debit Card Number: " + debitCardNumber +
				"\n  Debit Card Pin: " + debitCardPin;
	}
	
}
