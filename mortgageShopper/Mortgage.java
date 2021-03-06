package mortgageShopper;

public class Mortgage extends mortgageShopper.Loan {
	private int length;
	private String bankName;
	private double credit;

	// default constructor
    public Mortgage() {
		length = 0;
		bankName = "Bank1 ";
	}

	// parameter constructor
	public Mortgage(String nam, int lngth, double prin, double down, double intrest, double credit) {
    	this.credit=credit;
		bankName=nam;
		length = lngth;
		super.setPrinciple(prin);
		super.setDownPayment(down);
		super.setInterestRate(intrest);
	}

	// setter methods
	public void setLength(int l) {
		length = l;
	}

	public void setInterestRate(double i) {
		super.setInterestRate(i);
	}

	public void setBankName(String n) {
		bankName = n;
	}

	// getter methods
	public int getlength() {
		return length;
	}

	public double getInterestRate() {
		return super.getInterestRate();
	}

	public String getBankName() {
		return bankName;
	}

	// override calculateMonthy method
	// (princ-down)*(interest)
	// 			+princ-down
	// 				/length
	//					*credit multiplier
	public double calculateMonthly() {

		return ((((super.getPrinciple()-super.getDownPayment())*(super.getInterestRate()/100))
							+(super.getPrinciple()-super.getDownPayment()))
										/length)
											*credit;

	}

	// override toString() method
	public String toString() {
		return "Bank Name: "
				+ bankName
				+"\nPrinciple: $"
				+ super.getPrinciple()
				+"\nDown Payment: $"
				+ super.getDownPayment()
				+ "\nLoan Length: "
				+ length + " Months"
				+ "\nInterest Rate: "
				+ super.getInterestRate() + "%"; 

	}
}
