import mortgageShopper.Auto;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

class MortgageShopper {

        public static void main(String[] args) {
                Auto a=new Auto(3,100,10,4.4);
                double month=a.calculateMonthly();
                System.out.println(a+"\nthis is the monthly payment "+month);

        }
}
