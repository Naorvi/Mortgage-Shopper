package mortgageShopper;

public class Auto extends Loan {
	private double length;
	private String bankName;
	private double interestRate;

	// default constructor
	Auto() {
		length = 0.0;
		bankName = "Bank1 ";
	}

	// parameter constructor
	Auto(double lngth) {
		length = lngth;

	}

	// setter methods
	public void setLength(double l) {
		length = l;
	}

	public void setInterestRate(double i) {
		interestRate = i;
	}

	public void setBankName(String n) {
		bankName = n;
	}

	// getter methods
	public double getlength() {
		return length;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public String getBankName() {
		return bankName;
	}

	// override calculateMonthy method
	public double calculateMonthly() {

		return ((getPrinciple() - getDownPayment()) / (length)) * (1 + getInterestRate());

	}

	// override toString() method
	public String toString() {
		return "Bank Name: " + bankName + "\nLoan Length: " + length + "\nInterest Rate: " + interestRate;

	}
}
