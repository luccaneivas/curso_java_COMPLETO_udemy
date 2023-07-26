package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many employees? ");
		int noOfEmployees = scan.nextInt();
		
		Employee employees[] = new Employee[noOfEmployees];
		
		for (int i = 1; i <= noOfEmployees; i++) {
			scan.nextLine();
			System.out.printf("\nEmployee #%d:\n", i);
			System.out.print("ID: ");
			Integer id = scan.nextInt();
			for (Employee employee : employees) {
				if (employee.getId().equals(id)) {
					System.out.print("This ID is already in use. Try another one: ");
					id = scan.nextInt();
				}
			}
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Salary: ");
			Double salary = scan.nextDouble();
			
			
			employees[i - 1] = new Employee(id, name, salary);
		}
		
		scan.close();
	}

}
