package mortgageShopper;

import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Mortgage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class MortgageShopper {

        public static void main(String[] args) throws IOException {
                Scanner in=new Scanner(System.in);
                Mortgage m2=new Mortgage();

                System.out.println("Please enter the name of the bank:");
                String userBank=in.nextLine();
                m2.setBankName(userBank);

                System.out.println("Please enter the loan length in months:");
                int userLength=Integer.parseInt(in.nextLine());
                m2.setLength(userLength);

                System.out.println("Please enter an interest rate:");
                double userRate=Double.parseDouble(in.nextLine());
                m2.setInterestRate(userRate);

                System.out.println("Please enter the principle amount:");
                double userPrinciple=Double.parseDouble(in.nextLine());
                m2.setPrinciple(userPrinciple);

                System.out.println("Please enter the down payment amount:");
                double userDown=Double.parseDouble(in.nextLine());
                m2.setDownPayment(userDown);

                double monthm2=m2.calculateMonthly();
                System.out.println("\n");
                System.out.println("Mortgage terms:");
                System.out.println(m2);
                System.out.printf("This is the monthly payment: $%,.2f", (monthm2));
                System.out.println("\n");

                Mortgage m=new Mortgage("BB&T",userLength,userPrinciple,userDown,5.8);
                double monthm=m.calculateMonthly();
                System.out.println("Additional Mortgage offer:");
                System.out.println(m);
                System.out.printf("This is the monthly payment: $%,.2f", (monthm));
                System.out.println("\n");

                Business b=new Business("Chase",userLength,userPrinciple,userDown,7.8);
                double monthb=b.calculateMonthly();
                System.out.println("Business loan terms:");
                System.out.println(b);
                System.out.printf("This is the monthly payment: $%,.2f", (monthb));
                System.out.println("\n");

                Auto a=new Auto("US Bank",userLength,userPrinciple,userDown,5.0);
                double month=a.calculateMonthly();
                System.out.println("Auto loan terms:");
                System.out.println(a);
                System.out.printf("This is the monthly payment: $%,.2f", (month));
                System.out.println("\n");

                /*GUI.createAndShowGUI();
                Controller c=new Controller();
                c.initialGUI();*/
        }
}
