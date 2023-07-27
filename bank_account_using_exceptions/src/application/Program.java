package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holderName = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			
			Account account = new Account(number, holderName, initialBalance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withdrawAmount = sc.nextDouble();
			sc.nextLine();
			
			account.withdraw(withdrawAmount);
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
