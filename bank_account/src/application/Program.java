package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;
		
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		
		System.out.print("Is there an initial deposit? (y/n) ");
		char option = sc.next().toLowerCase().charAt(0);
				
		if (option == 'y') {
			System.out.print("Enter initial deposit value: ");
			double deposit = sc.nextDouble();
			
			account = new Account(number, holder, deposit);
		} else {
			account = new Account(number, holder);
		}
		
		System.out.println("\nAccount data:");
		System.out.println(account + "\n");
		
		sc.nextLine();
		
		System.out.print("Enter a deposit value: ");
		double newDeposit = sc.nextDouble();
		account.deposit(newDeposit);
		
		System.out.println("Updated account data:");
		System.out.println(account + "\n");
		
		System.out.print("\nEnter a withdraw value: ");
		double newWithdraw = sc.nextDouble();
		account.withdraw(newWithdraw);
		
		System.out.println("Updated account data:");
		System.out.println(account + "\n");
		
		sc.close();
	}

}
