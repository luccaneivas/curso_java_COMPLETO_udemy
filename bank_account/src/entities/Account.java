package entities;

public class Account {
	private static final int TAX = 5;
	
	private int accountNumber;
	private String holder;
	private double balance;
	
	public Account() {
	}
	
	public Account(int accountNumber, String holder, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.holder = holder;
		deposit(initialDeposit);
	}
	
	public Account(int accountNumber, String holder) {
		this.accountNumber = accountNumber;
		this.holder = holder;
		balance = 0;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String clientName) {
		this.holder = clientName;
	}
	
	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount + TAX;
	}
	
	public String toString() {
		return "Account " + accountNumber
				+ ", Holder: " + holder
				+ ", Balance: $ " + String.format("%.2f", balance);
	}
}
