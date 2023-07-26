package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int noOfProducts = sc.nextInt();
		sc.nextLine();
		
		List<Product> products = new ArrayList<>();
		
		for (int i = 0; i < noOfProducts; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char option = sc.nextLine().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			sc.nextLine();
			
			if (option == 'u') {
				System.out.print("Manufactured date (DD/MM/YYYY): ");
				Date manufacturedDate = fmt.parse(sc.nextLine());
				
				products.add(new UsedProduct(name, price, manufacturedDate));
			} else if (option == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				sc.nextLine();
				
				products.add(new ImportedProduct(name, price, customsFee));
			} else {
				products.add(new Product(name, price));
			}
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
