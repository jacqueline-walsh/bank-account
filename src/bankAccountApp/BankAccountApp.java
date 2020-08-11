package bankAccountApp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import static utilities.CSV.*;

public class BankAccountApp {
	
	public static void main(String[] args) {
		
		// Read a CSV file then create new accounts on that data
		NumberFormat df = new DecimalFormat("#.00");
		List<Account> accounts = new LinkedList<>();

		
		String file = "./src/bankAccountApp/NewBankAccounts.csv";
		List<String[]> newAccountHolders = read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equals("Savings")) {
				accounts.add(new SavingsAccount(name, sSN, initDeposit));
				
			} else if (accountType.equals("Checking")) {
				accounts.add(new CurrentAccount(name, sSN, initDeposit));
			} else {
				System.out.println("Error reading account type");
			}
		}

		for (Account acc : accounts) {
			System.out.println(acc.showInfo());
			System.out.println("\t*******");
		}
	}
	

}
