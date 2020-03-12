package mortgageShopper;

public abstract class Loan {
	private double monthlyPayment;
	private double principle;
	private double downPayment;
	private int creditScore;
	private double interestRate;
	private String bankName;

	// default constructor
	Loan() {
		monthlyPayment = 0.0;
		principle = 0.0;
		downPayment = 0.0;
		creditScore = 0;
		interestRate = 0.0;
		bankName = "Bank1 ";
	}

	// parameter constructor
	Loan(double mPayment, double prncple, double dPayment, int cScore, String bName) {
		monthlyPayment = mPayment;
		setPrinciple(prncple);
		setDownPayment(dPayment);
		creditScore = cScore;
		bankName = bName;

	}

	// setter methods
	public void setPrinciple(double p) {
		principle = p;
	}

	public void setDownPayment(double d) {
		downPayment = d;
	}

	// getter methods
	public double getPrinciple() {
		return principle;
	}

	public double getDownPayment() {
		return downPayment;
	}

	// abstract methods
	public abstract double calculateMonthy();

	// toString method
	public String toString() {
		return "Monthly Payment: " + monthlyPayment + "\nPriciple: " + principle + "\nDown Payment: " + downPayment
				+ "\nCredit Score: " + creditScore + "\nBank Name: " + bankName;

	}
}
