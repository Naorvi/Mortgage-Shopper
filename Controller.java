import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;


public class Controller {
    private double[] interestRates= new double[]{6.4,4.2,5.0};
    private double[] months= new double[3];
    private int loanType=0;
    private int length=0;
    private double credit=1.10;
    private GUI g;

    DecimalFormat df = new DecimalFormat("$#,###,##0.00");



    // constructor takes in the GUI object
    // and calls it's initializer method
    Controller(GUI g) throws IOException {
        this.g=g;
        g.createAndShowGUI();
    }

    //~~~~~~~~~~~~~~~~~~~INPUT VALIDATION~~~~~~~~~~~~~~~~
    // tries parsing the principle and down payment
    // if it fails it asks user to enter a valid input
    public boolean isValid(){
        try {
            getPrinciple();
            getDown();
            return true;}
        catch (Exception e) {
            g.getErrorText().setText("Please enter a Valid Principle and Down Payment.");
            return false;
        }
    }

    //checks to see if down payment is greater the principle
    // if it is it displays error message
    public boolean isDownPaymentValid(){
        if (getDown()>getPrinciple()){
            g.getErrorText().setText("Please enter a down payment less then your principle.");
            return false;
        }
        else return true;
    }

    // error checks if a loan type is selected
    // makes loan button pink to signify where the user should click
    // if the length is zero it also displays message to select a length
    public boolean isTermSelected(){
        if (loanType==0){
            g.getErrorText().setText("Please Select a Loan Type.");
            g.getBusinessButton().setForeground(Color.pink);
            g.getAutoButton().setForeground(Color.pink);
            g.getHomeButton().setForeground(Color.pink);
            return false;
        }
        if(length==0){
            g.getErrorText().setText("Please Select a Loan length.");
            return false;
        }
        else return true;
    }

    //~~~~~~~~~~~~~~~~~~~TEXT FIELD RETRIEVAL~~~~~~~~~~~~~~~~
    // get the name of the user from the text field
    // if name is empty then we try to respect their privacy in their search for less then trust worthy source of income
    public String getName(){
        if (g.getName().getText().equals("")){
            return "Anonymous Client";
        }
        else
            return g.getName().getText();
    }

    //tries to parse the input of the principle text field into a double
    public double getPrinciple(){
        return Double.parseDouble(g.getPrinciple().getText());
    }

    //tries to parse the input of the down payment text field into a double
    public double getDown(){
        return Double.parseDouble(g.getDownPayment().getText());
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~GUI FUNCTIONS~~~~~~~~~~~~~~~~~~~~
    //disables the radio buttons
    //and clears the selected radios button
    public void disableLengths(){
        g.getMonths36().setEnabled(false);
        g.getMonths72().setEnabled(false);
        g.getAutoButton().setForeground(Color.WHITE);

        g.getAutoButtons().clearSelection();

        g.getYear15().setEnabled(false);
        g.getYear30().setEnabled(false);
        g.getHomeButton().setForeground(Color.WHITE);

        g.getHomeButtons().clearSelection();

        g.getYear3().setEnabled(false);
        g.getYear5().setEnabled(false);
        g.getBusinessButton().setForeground(Color.WHITE);

        g.getBusinessButtons().clearSelection();

    }

    //resets the selected loan type and length to default
    public void resetLoan(){
        length=0;
        loanType=0;
        disableLengths();
        g.getErrorText().setText("");
    }

    // calls the GUI's card layout to switch the pane to the results pane
    public void resultsPane(){
        CardLayout cl = (CardLayout) (g.getCards().getLayout());
        cl.show(g.getCards(), "RESULTS");
    }

    //~~~~~~~~~~~~~~~~~~~~DATA MANIPULATION(should be moved into MODEL)~~~~~~~~~~~~~~~~~~~

    //get interest rates from SQL server only usable from a static method
    public void getInterestRatesFromSQL(){
        for(int x=0;x<3;x++){
            interestRates[x]= BankSQL.getList().get(x).getRate();
        }
    }

    // creates the message on the results page Was thing of using the toString()
    // but wanted to make custom message in case we chanted to change it easier
    public void resultsMessage(){
        g.getResultsMessage().setText("Hi "
                +getName()
                +", With your "
                +df.format(getDown())
                +" Down Payment you qualify for a "
                +df.format(getPrinciple())
                +" loan from these great providers:");
    }


    // uses for loop to create loans of the type selected
    // calculates the monthly payment
    // sets the monthly payments into the array on the results page
    public void autoLoan(int length){
        for (int x=0;x<3;x++) {
            Auto a = new Auto("Auto 36", length, getPrinciple(), getDown(), interestRates[x],credit);
            months[x] = a.calculateMonthly();
            g.getMonthly(x).setText(String.valueOf(df.format(months[x])));
        }
    }

    // uses for loop to create loans of the type selected
    // calculates the monthly payment
    // sets the monthly payments into the array on the results page
    public void homeLoan(int length){
        for (int x=0;x<3;x++) {
            Mortgage m = new Mortgage("Home 15 year", length, getPrinciple(), getDown(), interestRates[x],credit);
            months[x] = m.calculateMonthly();
            g.getMonthly(x).setText(String.valueOf(df.format(months[x])));
        }
    }

    // uses for loop to create loans of the type selected
    // calculates the monthly payment
    // sets the monthly payments into the array on the results page
    public void businessLoan(int length){
        for (int x=0;x<3;x++) {
            Business b = new Business("Home 15 year", length, getPrinciple(), getDown(), interestRates[x],credit);
            months[x] =b.calculateMonthly();
            g.getMonthly(x).setText(String.valueOf(df.format(months[x])));
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~GUI PROCESSING~~~~~~~~~~~~~~~~~~~~~~~~~
    // uses radio button and selected loan type to call the method to construct corresponding loan type
    // eg loan type 1 is auto if length is 36 it will call the autoLoan() which will create an auto loan
    // loan types 1=auto,  2-mortgage, 3=business
    // after it calls the results pane, then changes the results message, and resets the Loan buttons
    public void showResults(){
        if (loanType == 1) {
            if (length == 36) {
                autoLoan(length);
            }
            if (length == 72) {
                autoLoan(length);
            }
        }
        if (loanType == 2) {
            if (length == 180) {
                homeLoan(length);
            }
            if (length == 360) {
                homeLoan(length);
            }
        }
        if (loanType == 3) {
            if (length == 60) {
                businessLoan(length);
            }
            if (length == 36) {
                businessLoan(length);
            }
        }
        resultsPane();
        resultsMessage();
        resetLoan();
    }

    //takes credit slider in, and assign credit multiplier to slider ranges
    public void setCredit(){
        if(g.getCredit().getValue()==0){
            credit=1.25;
        }
        if(g.getCredit().getValue()==50){
            credit=1.10;
        }
        if(g.getCredit().getValue()==100)
            credit=1;
    }


    //initializes all the GUI functions
    public void initialGUI(){
        disableLengths();

        //credit slider
        g.getCredit().addChangeListener(e -> setCredit());

        //back button on results page
        g.getBackToMain().addActionListener(e -> {
            CardLayout cl = (CardLayout)(g.getCards().getLayout());
            cl.show(g.getCards(), "MAIN");
        });

        //auto button
        g.getAutoButton().addActionListener(e->{
            loanType=1;
            disableLengths();
            g.getAutoButton().setForeground(Color.green);
            g.getMonths36().setEnabled(true);
            g.getMonths72().setEnabled(true);
        });

        // 36 month auto loan
        g.getMonths36().addActionListener(e-> length=36);

        //72 month auto loan
        g.getMonths72().addActionListener(e-> length=72);

        //mortgage button
        g.getHomeButton().addActionListener(e->{
            loanType=2;
            disableLengths();
            g.getHomeButton().setForeground(Color.green);
            g.getYear15().setEnabled(true);
            g.getYear30().setEnabled(true);
        });

        //15 year mortgage
        g.getYear15().addActionListener(e->length=180);

        //30 year mortgage
        g.getYear30().addActionListener(e->length=360);

        //business button
        g.getBusinessButton().addActionListener(e->{
            loanType=3;
            disableLengths();
            g.getBusinessButton().setForeground(Color.green);
            g.getYear5().setEnabled(true);
            g.getYear3().setEnabled(true);
        });

        //5 year business loan
        g.getYear5().addActionListener(e->length=60);

        //3 year business loan
        g.getYear3().addActionListener(e->length=36);

        //submit button
        g.getSubmitButton().addActionListener(e-> {
                    if (isValid() && isTermSelected() && isDownPaymentValid())
                        showResults();
                });
    }


}
