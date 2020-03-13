import mortgageShopper.Auto;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

class MortgageShopper {

        public static void main(String[] args) throws IOException {
                Auto a=new Auto("Lo Yield",3,100,10,4.4);
                double month=a.calculateMonthly();
                System.out.println(a+"\nthis is the monthly payment "+month);
                GUI.createAndShowGUI();
        }
}
