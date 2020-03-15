import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;

public class Controller {
    private int loanType=0;
    private int length=0;
    GUI g=new GUI();

    Controller(){

    }

    public String getName(){
        return String.valueOf(GUI.getName());
    }
    public double getPrinciple(){
        return Double.parseDouble(GUI.getPrinciple().getText());
    }

    public double getDown(){
        return Double.parseDouble(GUI.getDownPayment().getText());
    }

    public void disableLengths(){
        GUI.getMonths36().setEnabled(false);
        GUI.getMonths72().setEnabled(false);

        GUI.getAutoButtons().clearSelection();

        GUI.getYear15().setEnabled(false);
        GUI.getYear30().setEnabled(false);

        GUI.getHomeButtons().clearSelection();

        GUI.getYear3().setEnabled(false);
        GUI.getYear5().setEnabled(false);

        GUI.getBusinessButtons().clearSelection();

    }

    public void initialGUI(){
        disableLengths();
        GUI.getAutoButton().addActionListener(e->{
            loanType=1;
            disableLengths();
            GUI.getMonths36().setEnabled(true);
            GUI.getMonths72().setEnabled(true);
        });

        GUI.getMonths36().addActionListener(e-> length=36);

        GUI.getMonths72().addActionListener(e-> length=72);

        GUI.getHomeButton().addActionListener(e->{
            loanType=2;
            disableLengths();
            GUI.getYear15().setEnabled(true);
            GUI.getYear30().setEnabled(true);
        });

        GUI.getYear15().addActionListener(e->length=180);

        GUI.getYear30().addActionListener(e->length=360);

        GUI.getBusinessButton().addActionListener(e->{
            loanType=3;
            disableLengths();
            GUI.getYear5().setEnabled(true);
            GUI.getYear3().setEnabled(true);
        });

        GUI.getYear5().addActionListener(e->length=60);

        GUI.getYear3().addActionListener(e->length=36);

        GUI.getSubmitButton().addActionListener(e->{
           if(loanType==1){
               if (length==36) {
                   Auto a = new Auto("Auto 36", 36, getPrinciple(), getDown(), 5.0);
                   System.out.println(a);
               }
               if(length==72){
                   Auto a = new Auto("Auto 72", 72, getPrinciple(), getDown(), 5.0);
                   System.out.println(a);
               }
           }
            if(loanType == 2){
                if (length==180) {
                    Mortgage m = new Mortgage("Home 15 year", 180, getPrinciple(), getDown(), 5.0);
                    System.out.println(m);
                }
                if(length==360){
                    Mortgage m = new Mortgage("Home 30 year", 360, getPrinciple(), getDown(), 5.0);
                    System.out.println(m);
                }
            }
            if(loanType == 3){
                if (length==60) {
                    Business b = new Business("Business 3 year", 60, getPrinciple(), getDown(), 5.0);
                    System.out.println(b);
                }
                if(length==36){
                    Business b = new Business("Business 5 year", 36, getPrinciple(), getDown(), 5.0);
                    System.out.println(b);
                }
            }
        });
    }


}
