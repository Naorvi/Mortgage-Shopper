import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class MortgageShopperv1 {

    public static void main(String[] args) throws IOException {
                /*Scanner in=new Scanner(System.in);
                Mortgage m2=new Mortgage();

                System.out.println("Please enter the name of the bank:");
                String userBank=in.nextLine();
                m2.setBankName(userBank);

                System.out.println("Please enter a length in months:");
                int userLength=Integer.parseInt(in.nextLine());
                m2.setLength(userLength);

                System.out.println("Please enter an interest rate:");
                double userRate=Double.parseDouble(in.nextLine());
                m2.setInterestRate(userRate);

                System.out.println("Please enter the principle amount:");
                double userPrinciple=Double.parseDouble(in.nextLine());
                m2.setPrinciple(userPrinciple);

                System.out.println("Please enter the down payment:");
                double userDown=Double.parseDouble(in.nextLine());
                m2.setDownPayment(userDown);

                double monthm2=m2.calculateMonthly();
                System.out.println(m2+"\nthis is the monthly payment "+monthm2+"\n");


                Mortgage m=new Mortgage("Feez",500,500000,20000,5.0);
                double monthm=m.calculateMonthly();
                System.out.println(m+"\nthis is the monthly payment "+monthm+"\n");

                Business b=new Business("Debt",52,500000,20000,5.0);
                double monthb=b.calculateMonthly();
                System.out.println(b+"\nthis is the monthly payment "+monthb+"\n");

                Auto a=new Auto("Lo Yield",3,100,10,4.4);
                double month=a.calculateMonthly();
                System.out.println(a+"\nthis is the monthly payment "+month+"\n");*/

        GUI.createAndShowGUI();
        Controller c=new Controller();
        c.initialGUI();
    }
}

