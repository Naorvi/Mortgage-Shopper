package mortgageShopper;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mortgageShopper {

private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Shark Loans");
        frame.setIconImage(new ImageIcon("SharkIcon.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(0,0,800,600);

        JPanel pane = new JPanel(new GridBagLayout());

        GridBagConstraints gridbag = new GridBagConstraints();

        JTextField name = new JTextField(20);
        gridbag.gridx=0;
        gridbag.gridy=0;
        pane.add(name,gridbag);
        name.setText("Name");

        JTextField principle = new JTextField(20);
        gridbag.gridx=1;
        gridbag.gridy=0;
        pane.add(principle,gridbag);
        principle.setText("Principle");

        JTextField downPayment = new JTextField(20);
        gridbag.gridx=2;
        gridbag.gridy=0;
        pane.add(downPayment,gridbag);
        downPayment.setText("Down Payment");

        JButton autoButton = new JButton("Auto");
        gridbag.gridx=0;
        gridbag.gridy=2;
        pane.add(autoButton,gridbag);

        JRadioButton months36= new JRadioButton("36 Months");
        gridbag.gridx=0;
        gridbag.gridy=3;
        pane.add(months36,gridbag);

        JRadioButton months72= new JRadioButton("72 Months");
        gridbag.gridx=0;
        gridbag.gridy=4;
        pane.add(months72,gridbag);


        JButton homeButton = new JButton("Home");
        gridbag.gridx=1;
        gridbag.gridy=2;
        pane.add(homeButton,gridbag);

        JRadioButton year15= new JRadioButton("15 Years");
        gridbag.gridx=1;
        gridbag.gridy=3;
        pane.add(year15,gridbag);

        JRadioButton year30= new JRadioButton("30 Years");
        gridbag.gridx=1;
        gridbag.gridy=4;
        pane.add(year30,gridbag);

        JButton businessButton = new JButton("Business");
        gridbag.gridx=2;
        gridbag.gridy=2;
        pane.add(businessButton,gridbag);

        JRadioButton year3= new JRadioButton("3 Years");
        gridbag.gridx=2;
        gridbag.gridy=3;
        pane.add(year3,gridbag);

        JRadioButton year5= new JRadioButton("5 Years");
        gridbag.gridx=2;
        gridbag.gridy=4;
        pane.add(year5,gridbag);

        gridbag.gridx=0;
        gridbag.gridy=5;
        gridbag.gridheight=10;
        gridbag.fill = GridBagConstraints.VERTICAL;
        gridbag.gridwidth=8;
        gridbag.fill = GridBagConstraints.HORIZONTAL;
        JButton submitButton = new JButton("submit");
        pane.add(submitButton,gridbag);

        //Display the window.
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
