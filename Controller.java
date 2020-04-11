import com.mysql.cj.util.StringUtils;
import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;

import java.awt.*;
import java.io.IOException;

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
    public boolean isTermSelected(){
        if (loanType==0||length==0){
            g.getErrorText().setText("Please Select a loan type and Lona length.");
            return false;
        }
        else return true;
    }

    public String getName(){
        return String.valueOf(g.getName());
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

        g.getAutoButtons().clearSelection();

        g.getYear15().setEnabled(false);
        g.getYear30().setEnabled(false);

        g.getHomeButtons().clearSelection();

        g.getYear3().setEnabled(false);
        g.getYear5().setEnabled(false);

        g.getBusinessButtons().clearSelection();

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
            g.getMonths36().setEnabled(true);
            g.getMonths72().setEnabled(true);
        });

        g.getMonths36().addActionListener(e-> length=36);

        g.getMonths72().addActionListener(e-> length=72);

        g.getHomeButton().addActionListener(e->{
            loanType=2;
            disableLengths();
            g.getYear15().setEnabled(true);
            g.getYear30().setEnabled(true);
        });

        g.getYear15().addActionListener(e->length=180);

        g.getYear30().addActionListener(e->length=360);

        g.getBusinessButton().addActionListener(e->{
            loanType=3;
            disableLengths();
            g.getYear5().setEnabled(true);
            g.getYear3().setEnabled(true);
        });

        g.getYear5().addActionListener(e->length=60);

        g.getYear3().addActionListener(e->length=36);

        g.getSubmitButton().addActionListener(e-> {
                    if (isValid() && isTermSelected()) {
                        CardLayout cl = (CardLayout) (g.getCards().getLayout());
                        cl.show(g.getCards(), "RESULTS");
                        if (loanType == 1) {
                            if (length == 36) {
                                Auto a = new Auto("Auto 36", 36, getPrinciple(), getDown(), 5.0);
                                double month = a.calculateMonthly();
                                g.getResults().setText(a + "\nthis is the monthly payment " + month + "\n");
                            }
                            if (length == 72) {
                                Auto a = new Auto("Auto 72", 72, getPrinciple(), getDown(), 5.0);
                                double month = a.calculateMonthly();
                                g.getResults().setText(a + "\nthis is the monthly payment " + month + "\n");
                            }
                        }
                        if (loanType == 2) {
                            if (length == 180) {
                                Mortgage m = new Mortgage("Home 15 year", 180, getPrinciple(), getDown(), 5.0);
                                double month = m.calculateMonthly();
                                g.getResults().setText(m + "\nthis is the monthly payment " + month + "\n");
                            }
                            if (length == 360) {
                                Mortgage m = new Mortgage("Home 30 year", 360, getPrinciple(), getDown(), 5.0);
                                double month = m.calculateMonthly();
                                g.getResults().setText(m + "\nthis is the monthly payment " + month + "\n");
                            }
                        }
                        if (loanType == 3) {
                            if (length == 60) {
                                Business b = new Business("Business 5 year", 60, getPrinciple(), getDown(), 5.0);
                                double month = b.calculateMonthly();
                                g.getResults().setText(b + "\nthis is the monthly payment " + month + "\n");
                            }
                            if (length == 36) {
                                Business b = new Business("Business 3 year", 36, getPrinciple(), getDown(), 5.0);
                                double month = b.calculateMonthly();
                                g.getResults().setText(b + "\nthis is the monthly payment " + month + "\n");
                            }
                        }
                    }
                }

        );
    }


}
