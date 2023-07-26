package entities;

public class CurrencyConverter {
	public static final int IOF = 6;
	
	public static double converter(double dollarPrice, double dollarsToBought) {
		return (dollarPrice + (dollarPrice * IOF / 100)) * dollarsToBought;
	}
}
