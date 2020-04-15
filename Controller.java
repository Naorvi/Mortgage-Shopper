import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;

import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class Controller {
    private int loanType=0;
    private int length=0;
    private GUI g;
    
    Controller(GUI g) throws IOException {
        this.g=g;
        g.createAndShowGUI();
    }

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

    public boolean isDownPaymentValid(){
        if (getDown()>getPrinciple()){
            g.getErrorText().setText("Please enter a down payment less then your principle.");
            return false;
        }
        else return true;
    }

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

    public String getName(){
        return g.getName().getText();
    }

    public double getPrinciple(){
        return Double.parseDouble(g.getPrinciple().getText());
    }

    public double getDown(){
        return Double.parseDouble(g.getDownPayment().getText());
    }

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

    public void resetLoan(){
        length=0;
        loanType=0;
        disableLengths();
    }

    public void resultsPane(){
        CardLayout cl = (CardLayout) (g.getCards().getLayout());
        cl.show(g.getCards(), "RESULTS");
    }

    public void resultsMessage(){
        DecimalFormat df = new DecimalFormat("$#,###,##0.00");
        g.getResultsMessage().setText("Hi "
                +getName()
                +", With your "
                +df.format(getDown())
                +" Down Payment you qualify for a "
                +df.format(getPrinciple())
                +" loan from these great providers:");
    }

    public void showResults(){
        if (loanType == 1) {
            if (length == 36) {
                Auto a = new Auto("Auto 36", 36, getPrinciple(), getDown(), 5.0);
                double month = a.calculateMonthly();
            }
            if (length == 72) {
                Auto a = new Auto("Auto 72", 72, getPrinciple(), getDown(), 5.0);
                double month = a.calculateMonthly();
            }
        }
        if (loanType == 2) {
            if (length == 180) {
                Mortgage m = new Mortgage("Home 15 year", 180, getPrinciple(), getDown(), 5.0);
                double month = m.calculateMonthly();
            }
            if (length == 360) {
                Mortgage m = new Mortgage("Home 30 year", 360, getPrinciple(), getDown(), 5.0);
                double month = m.calculateMonthly();
            }
        }
        if (loanType == 3) {
            if (length == 60) {
                Business b = new Business("Business 5 year", 60, getPrinciple(), getDown(), 5.0);
                double month = b.calculateMonthly();
            }
            if (length == 36) {
                Business b = new Business("Business 3 year", 36, getPrinciple(), getDown(), 5.0);
                double month = b.calculateMonthly();
            }
        }
        resultsPane();
        resultsMessage();
        resetLoan();
    }

    public void initialGUI(){
        disableLengths();
        g.getBackToMain().addActionListener(e -> {
            CardLayout cl = (CardLayout)(g.getCards().getLayout());
            cl.show(g.getCards(), "MAIN");
        });
        g.getAutoButton().addActionListener(e->{
            loanType=1;
            disableLengths();
            g.getAutoButton().setForeground(Color.green);
            g.getMonths36().setEnabled(true);
            g.getMonths72().setEnabled(true);
        });

        g.getMonths36().addActionListener(e-> length=36);

        g.getMonths72().addActionListener(e-> length=72);

        g.getHomeButton().addActionListener(e->{
            loanType=2;
            disableLengths();
            g.getHomeButton().setForeground(Color.green);
            g.getYear15().setEnabled(true);
            g.getYear30().setEnabled(true);
        });

        g.getYear15().addActionListener(e->length=180);

        g.getYear30().addActionListener(e->length=360);

        g.getBusinessButton().addActionListener(e->{
            loanType=3;
            disableLengths();
            g.getBusinessButton().setForeground(Color.green);
            g.getYear5().setEnabled(true);
            g.getYear3().setEnabled(true);
        });

        g.getYear5().addActionListener(e->length=60);

        g.getYear3().addActionListener(e->length=36);

        g.getSubmitButton().addActionListener(e-> {
                    if (isValid() && isTermSelected() && isDownPaymentValid())
                        showResults();
                });
    }


}
