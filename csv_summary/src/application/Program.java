package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the csv file path: ");
		String strPath = sc.nextLine();

		while (!strPath.endsWith(".csv")) {
			System.out.print("The path must end with .csv. Try again: ");
			strPath = sc.nextLine();
		}

		List<String> input = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			String line = br.readLine();

			while (line != null) {
				input.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		List<String> output = new ArrayList<>();

		for (String line : input) {
			String[] data = line.split(",");

			String name = data[0];
			Double price = Double.parseDouble(data[1]);
			int quantity = Integer.parseInt(data[2]);

			output.add(new Products(name, price, quantity).toString());
		}

		String dirPath = new File(strPath).getParent() + "/out";

		boolean result = new File(dirPath).mkdir();
		System.out.println(result);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dirPath + "/summary.csv"))) {
			for (String line : output) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
