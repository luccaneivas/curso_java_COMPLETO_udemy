package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String clientBirthDate = sc.nextLine();
		
		Client client = new Client(clientName, clientEmail, fmt.parse(clientBirthDate));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		System.out.print("How many items to this order? ");
		Integer itemsQuantity = sc.nextInt();
		sc.nextLine();

		Order order = new Order(OrderStatus.valueOf(orderStatus), client);
		
		for (int i = 0; i < itemsQuantity; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String itemName = sc.nextLine();
			System.out.print("Product price: ");
			Double itemPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity: ");
			Integer itemQuantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem newItem = new OrderItem(itemQuantity, itemPrice, new Product(itemName, itemPrice));
			order.addItem(newItem);
		}
		
		System.out.println(order.toString());
		
		sc.close();
	}

}
