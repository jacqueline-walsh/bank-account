package bankAccountApp;

public class SavingsAccount extends Account {

	
	// List the properties specific to a savings account
	private int safetyDepositBoxId;
	private int safetyDepositBoxKey;
	
	
	// Constructor to initialize savings account properties
	public SavingsAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	// List any methods specific to the savings account
	public String showInfo() {
		return super.showInfo() + 
				"\nSavings Account Features:" + 
				"\n  Safety Deposit Box ID: " + safetyDepositBoxId +
				"\n  Safety Deposit Box Key: " + safetyDepositBoxKey;
	}	
	
	private void setSafetyDepositBox() {
		safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}

	@Override
	public void setRate() {
		rate = (getBaseRate() - .25);
		
	}
	
}
