package entities;

public class CompanyTaxPayer extends TaxPayer {

	private Integer noOfEmployees;
	
	public CompanyTaxPayer() {
		super();
	}
	
	public CompanyTaxPayer(String name, Double anualIncome, Integer noOfEmployees) {
		super(name, anualIncome);
		this.noOfEmployees = noOfEmployees;
	}

	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public Double TaxPaid() {
		Double tax;
		
		if (noOfEmployees > 10) {
			tax = 0.14;
		} else {
			tax = 0.16;
		}
		
		return super.getAnualIncome() * tax;
	}

}
