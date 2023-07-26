package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String depto = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double salary = sc.nextDouble();
		
		// instancia o usuario
		Department newDepto = new Department(depto);
		Worker newWorker = new Worker(name, WorkerLevel.valueOf(level), salary, newDepto);
		
		System.out.print("How many contracts to this worker? ");
		Integer noContracts = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < noContracts; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.nextLine();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer duration = sc.nextInt();
			sc.nextLine();
			
			// instancia o contrato e salva nos contratos
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date dateFormatted = fmt.parse(date);
			HourContract newContract = new HourContract(dateFormatted, valuePerHour, duration);
			
			newWorker.addContract(newContract);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String date = sc.nextLine();
		SimpleDateFormat fmt = new SimpleDateFormat("MM/yyyy");
		Date dateFormatted = fmt.parse(date);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormatted);
		
		int contractYear = cal.get(Calendar.YEAR);
		int contractMonth = 1 + cal.get(Calendar.MONTH);
		
		// imprime o toString do worker
		System.out.println(newWorker.toString());
		System.out.println("Income for " + date + ": " + newWorker.income(contractYear, contractMonth)); // imprime o totalvalue do contract
		
		sc.close();
	}

}
