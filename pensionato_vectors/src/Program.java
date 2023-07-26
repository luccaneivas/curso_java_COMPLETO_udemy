import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Student rooms[] = new Student[10];
		
		System.out.print("How many rooms will be rented? ");
		int quantity = scan.nextInt();
		
		for (int i = 1; i <= quantity; i++) {
			scan.nextLine();
			System.out.printf("\nRent #%d:\n", i);
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Email: ");
			String email = scan.next();
			System.out.print("Room: ");
			int roomNo = scan.nextInt();
			
			rooms[roomNo] = new Student(name, email);
		}
		
		System.out.println("\nBusy rooms:");
		
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				System.out.printf("%d: %s\n", i, rooms[i].toString());
			}
		}
		
		scan.close();
	}

}
