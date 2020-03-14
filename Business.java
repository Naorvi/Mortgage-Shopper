package mortgageShopper;

public class Business extends mortgageShopper.Loan {
	private double length;
	private String bankName;

	// default constructor
	Business() {
		length = 0.0;
		bankName = "Bank1 ";
	}

	// parameter constructor
	public Business(String nam, double lngth, double prin, double down, double intrest) {
		bankName=nam;
		length = lngth;
		super.setPrinciple(prin);
		super.setDownPayment(down);
		super.setInterestRate(intrest);
	}

	// setter methods
	public void setLength(double l) {
		length = l;
	}

	public void setInterestRate(double i) {
		super.setInterestRate(i);
	}

	public void setBankName(String n) {
		bankName = n;
	}

	// getter methods
	public double getlength() {
		return length;
	}

	public double getInterestRate() {
		return super.getInterestRate();
	}

	public String getBankName() {
		return bankName;
	}

	// override calculateMonthy method
	public double calculateMonthly() {

		return (((super.getPrinciple()-super.getDownPayment())*(super.getInterestRate()/100))+(super.getPrinciple()-super.getDownPayment()))/length;

	}

	// override toString() method
	public String toString() {
		return "Bank Name: " + bankName + "\nLoan Length: " + length + "\nInterest Rate: " + super.getInterestRate();

	}
}
