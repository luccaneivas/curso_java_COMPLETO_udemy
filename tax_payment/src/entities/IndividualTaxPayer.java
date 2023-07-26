package entities;

public class IndividualTaxPayer extends TaxPayer {

	private Double healthExpenditures;
	
	public IndividualTaxPayer() {
		super();
	}
	
	public IndividualTaxPayer(String name, Double anualIncome, Double healthExpeditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpeditures;
	}

	public Double getHealthExpeditures() {
		return healthExpenditures;
	}

	public void setHealthExpeditures(Double healthExpeditures) {
		this.healthExpenditures = healthExpeditures;
	}

	@Override
	public Double TaxPaid() {
		Double tax;
		
		if (super.getAnualIncome() < 20000.00) {
			tax = 0.15;
		} else {
			tax = 0.25;
		}
		
		return (super.getAnualIncome() * tax) - (healthExpenditures * 0.5);
	}

}
