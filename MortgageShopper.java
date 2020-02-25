import java.awt.*;
import java.io.IOException;
import javax.swing.*;

class MortgageShopper {

        private static void createAndShowGUI() throws IOException {
                //Create and set up the window.
                JFrame frame = new JFrame("Shark Loans");
                frame.setIconImage(new ImageIcon("SharkIcon.png").getImage());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setBounds(0,0,800,600);

                JPanelWithBackground pane = new JPanelWithBackground("sharkLoadBG.png");
                pane.setLayout(new GridBagLayout());

                GridBagConstraints gridbag = new GridBagConstraints();
                pane.setSize(800,600);
                Font font1 = new Font("Ariel", Font.BOLD, 20);
                Font font2 = new Font("Ariel", Font.BOLD, 40);

                JTextField name = new JTextField(20);
                gridbag.gridx=0;
                gridbag.gridy=0;
                pane.add(name,gridbag);
                name.setText("Name");
                name.setFont(font1);
                name.setForeground(Color.white);
                name.setOpaque(false);

                JTextField principle = new JTextField(20);
                gridbag.gridx=1;
                gridbag.gridy=0;
                pane.add(principle,gridbag);
                principle.setText("Principle");
                principle.setFont(font1);
                principle.setForeground(Color.white);
                principle.setOpaque(false);


                JTextField downPayment = new JTextField(20);
                gridbag.gridx=2;
                gridbag.gridy=0;
                pane.add(downPayment,gridbag);
                downPayment.setText("Down Payment");
                downPayment.setFont(font1);
                downPayment.setForeground(Color.white);
                downPayment.setOpaque(false);


                JButton autoButton = new JButton("Auto");
                gridbag.gridx=0;
                gridbag.gridy=2;
                pane.add(autoButton,gridbag);
                autoButton.setFont(font1);
                autoButton.setForeground(Color.white);
                autoButton.setOpaque(false);
                autoButton.setContentAreaFilled(false);
                autoButton.setBorderPainted(false);

                JRadioButton months36= new JRadioButton("36 Months");
                gridbag.gridx=0;
                gridbag.gridy=3;
                pane.add(months36,gridbag);
                months36.setFont(font1);
                months36.setForeground(Color.white);
                months36.setOpaque(false);
                months36.setContentAreaFilled(false);
                months36.setBorderPainted(false);

                JRadioButton months72= new JRadioButton("72 Months");
                gridbag.gridx=0;
                gridbag.gridy=4;
                pane.add(months72,gridbag);
                months72.setFont(font1);
                months72.setForeground(Color.white);
                months72.setOpaque(false);
                months72.setContentAreaFilled(false);
                months72.setBorderPainted(false);


                JButton homeButton = new JButton("Home");
                gridbag.gridx=1;
                gridbag.gridy=2;
                pane.add(homeButton,gridbag);
                homeButton.setFont(font1);
                homeButton.setForeground(Color.white);
                homeButton.setOpaque(false);
                homeButton.setContentAreaFilled(false);
                homeButton.setBorderPainted(false);

                JRadioButton year15= new JRadioButton("15 Years");
                gridbag.gridx=1;
                gridbag.gridy=3;
                pane.add(year15,gridbag);
                year15.setFont(font1);
                year15.setForeground(Color.white);
                year15.setOpaque(false);
                year15.setContentAreaFilled(false);
                year15.setBorderPainted(false);

                JRadioButton year30= new JRadioButton("30 Years");
                gridbag.gridx=1;
                gridbag.gridy=4;
                pane.add(year30,gridbag);
                year30.setFont(font1);
                year30.setForeground(Color.white);
                year30.setOpaque(false);
                year30.setContentAreaFilled(false);
                year30.setBorderPainted(false);

                JButton businessButton = new JButton("Business");
                gridbag.gridx=2;
                gridbag.gridy=2;
                pane.add(businessButton,gridbag);
                businessButton.setFont(font1);
                businessButton.setForeground(Color.white);
                businessButton.setOpaque(false);
                businessButton.setContentAreaFilled(false);
                businessButton.setBorderPainted(false);


                JRadioButton year3= new JRadioButton("3 Years");
                gridbag.gridx=2;
                gridbag.gridy=3;
                pane.add(year3,gridbag);
                year3.setFont(font1);
                year3.setForeground(Color.white);
                year3.setOpaque(false);
                year3.setContentAreaFilled(false);
                year3.setBorderPainted(false);

                JRadioButton year5= new JRadioButton("5 Years");
                gridbag.gridx=2;
                gridbag.gridy=4;
                pane.add(year5,gridbag);
                year5.setFont(font1);
                year5.setForeground(Color.white);
                year5.setOpaque(false);
                year5.setContentAreaFilled(false);
                year5.setBorderPainted(false);

                gridbag.gridx=0;
                gridbag.gridy=5;
                gridbag.gridheight=10;
                gridbag.fill = GridBagConstraints.VERTICAL;
                gridbag.gridwidth=8;
                gridbag.fill = GridBagConstraints.HORIZONTAL;
                JButton submitButton = new JButton("Submit");
                submitButton.setFont(font2);
                submitButton.setForeground(Color.white);
                submitButton.setOpaque(false);
                submitButton.setContentAreaFilled(false);
                //submitButton.setBorderPainted(false);
                pane.add(submitButton,gridbag);

                //Display the window.
                frame.getContentPane().add(pane);
                frame.pack();
                frame.setVisible(true);
        }

        public static void main(String[] args) throws IOException {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        createAndShowGUI();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }
}
