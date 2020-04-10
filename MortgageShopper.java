import mortgageShopper.Auto;
import mortgageShopper.Business;
import mortgageShopper.Loan;
import mortgageShopper.Mortgage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class MortgageShopper {

        public static void main(String[] args) throws IOException {
                GUI g=new GUI();
                Controller c=new Controller(g);
                c.initialGUI();
        }
}
