package bankAccountApp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Account implements IBaseRate {

	// List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	private static int uniqueId = 10000; 
	protected String accountNumber;
	protected double rate;
	
	NumberFormat df = new DecimalFormat("#.00");
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		uniqueId++;		
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	// set account number
	private String setAccountNumber() {
		accountNumber = "" + sSN.substring(sSN.length()-2);
		accountNumber+= uniqueId;
		accountNumber+= (int) (Math.random() * Math.pow(10, 3));
		return accountNumber;
	}
	
	public void compoundInterest() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: €" + df.format(accruedInterest));
		printBalance();		
	}
	
	// List common methods - transactions
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing: €" + df.format(amount));
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing: €" + df.format(amount));
		printBalance();
	}
	
	public void transfer(String transferTo, double amount) {
		balance -= amount;
		System.out.println("Transfering €" + df.format(amount) + " to " + transferTo);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now €" +df.format(balance));
	}
	
	public String showInfo() {
		return "Name: " + name +
				"\nAccount Number: " + accountNumber +
				"\nBalance: €" + df.format(balance) +
				"\nRate: " + rate + "%";
	}
}
