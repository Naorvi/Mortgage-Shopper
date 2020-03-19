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
                GUI.createAndShowGUI();
                Controller c=new Controller();
                c.initialGUI();
        }
}
