package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Integer x = scan.nextInt();
		Integer y = scan.nextInt();
		
		Integer matriz[][] = new Integer[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matriz[i][j] = scan.nextInt();
			}
		}
		
		System.out.print(matriz);

		scan.close();
	}

}
