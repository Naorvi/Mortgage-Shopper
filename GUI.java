import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI {
    private JPanel cards;
    private ClearJLabel lblName=new ClearJLabel("Name");
    private ClearJLabel lblPrin= new ClearJLabel("Principle");
    private ClearJLabel lblDown= new ClearJLabel("Down Payment");
    private JTextField name = new JTextField(20);
    private JTextField principle = new JTextField(20);
    private JTextField downPayment = new JTextField(20);
    private ClearJButton autoButton = new ClearJButton("Auto");
    private ClearJRadioButton months36= new ClearJRadioButton("36 Months");
    private ClearJRadioButton months72= new ClearJRadioButton("72 Months");
    private ClearJButton homeButton = new ClearJButton("Home");
    private ClearJRadioButton year15= new ClearJRadioButton("15 Years");
    private ClearJRadioButton year30= new ClearJRadioButton("30 Years");
    private ClearJButton businessButton = new ClearJButton("Business");
    private ClearJRadioButton year3= new ClearJRadioButton("3 Years");
    private ClearJRadioButton year5= new ClearJRadioButton("5 Years");
    private JButton submitButton = new JButton("Submit");
    private ButtonGroup autoButtons=new ButtonGroup();
    private ButtonGroup homeButtons=new ButtonGroup();
    private ButtonGroup businessButtons=new ButtonGroup();
    private JButton backToMain =new JButton("Back");
    private JLabel results=new JLabel("results");
    private JLabel errorText=new JLabel();
    private JLabel bank1, bank2, bank3;
    private JLabel monthly1, monthly2,monthly3;
    private JLabel resultsMessage=new JLabel();
    private JSlider credit;


    public void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("Shark Loans");
        frame.setIconImage(new ImageIcon("images/SharkIcon.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanelWithBackground pane = new JPanelWithBackground("images/sharkLoadBG.png");
        pane.setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();
        Font font1 = new Font("Ariel", Font.BOLD, 20);
        Font font2 = new Font("Ariel", Font.BOLD, 40);
        Font font3 = new Font("Ariel",Font.BOLD,20);

        ImageIcon icon = new ImageIcon("images/sharkLoansLogo.png");
        JLabel logo=new JLabel();
        logo.setIcon(icon);

        gb.gridwidth=3;
        gb.ipady=20;
        gb.gridx=0;
        gb.gridy=0;
        pane.add(logo,gb);
        gb.gridwidth=1;

        gb.gridx=0;
        gb.gridy=1;
        pane.add(lblName, gb);

        gb.gridx=1;
        gb.gridy=1;
        pane.add(lblPrin,gb);

        gb.gridx=2;
        gb.gridy=1;
        pane.add(lblDown,gb);


        gb.gridx=0;
        gb.gridy=2;
        pane.add(name,gb);
        name.setFont(font1);
        name.setForeground(Color.white);
        name.setOpaque(false);
        name.setMinimumSize(new Dimension(200, 10));

        gb.gridx=1;
        gb.gridy=2;
        pane.add(principle,gb);
        principle.setFont(font1);
        principle.setForeground(Color.white);
        principle.setOpaque(false);
        principle.setMinimumSize(new Dimension(200, 10));

        gb.gridx=2;
        gb.gridy=2;
        pane.add(downPayment,gb);
        downPayment.setFont(font1);
        downPayment.setForeground(Color.white);
        downPayment.setOpaque(false);
        downPayment.setMinimumSize(new Dimension(200, 10));

        gb.gridx=0;
        gb.gridy=3;
        pane.add(autoButton,gb);
        autoButton.setFont(font1);

        gb.gridx=0;
        gb.gridy=4;
        pane.add(months36,gb);

        gb.gridx=0;
        gb.gridy=5;
        pane.add(months72,gb);

        autoButtons.add(months36);
        autoButtons.add(months72);

        gb.gridx=1;
        gb.gridy=3;
        pane.add(homeButton,gb);
        homeButton.setFont(font1);

        gb.gridx=1;
        gb.gridy=4;
        pane.add(year15,gb);

        gb.gridx=1;
        gb.gridy=5;
        pane.add(year30,gb);

        homeButtons.add(year15);
        homeButtons.add(year30);

        gb.gridx=2;
        gb.gridy=3;
        pane.add(businessButton,gb);
        businessButton.setFont(font1);

        gb.gridx=2;
        gb.gridy=4;
        pane.add(year3,gb);

        gb.gridx=2;
        gb.gridy=5;
        pane.add(year5,gb);

        businessButtons.add(year5);
        businessButtons.add(year3);

        gb.gridx=0;
        gb.gridy=6;
        gb.gridwidth=8;
        gb.fill = GridBagConstraints.BOTH;

        submitButton.setFont(font2);
        submitButton.setForeground(Color.white);
        submitButton.setOpaque(false);
        submitButton.setContentAreaFilled(false);
        pane.add(submitButton,gb);

        gb.gridx=0;
        gb.gridy=10;
        pane.add(errorText,gb);
        errorText.setFont(font3);
        errorText.setForeground(Color.pink);

        //Pane 2
        JPanelWithBackground pane2 = new JPanelWithBackground("images/sharkLoadBG.png");
        pane2.setLayout(new GridBagLayout());
        GridBagConstraints gb2 = new GridBagConstraints();

        ImageIcon icon2 = new ImageIcon("images/sharkLoansLogo.png");
        JLabel logo2=new JLabel();
        logo2.setIcon(icon2);


        gb2.gridwidth=2;
        gb2.gridx=1;
        gb2.gridy=0;
        pane2.add(logo2,gb2);

        gb2.gridwidth=1;
        gb2.gridx=0;
        gb2.gridy=0;
        pane2.add(backToMain,gb2);

        gb2.gridwidth=3;
        gb2.ipady=100;
        gb2.gridx=0;
        gb2.gridy=1;
        resultsMessage.setFont(font1);
        resultsMessage.setForeground(Color.white);
        pane2.add(resultsMessage,gb2);



        cards =new JPanel(new CardLayout());
        cards.add(pane,"MAIN");
        cards.add(pane2,"RESULTS");


        //Display the window.
        frame.getContentPane().add(cards);
        frame.pack();
        frame.setVisible(true);
    }

    public JLabel getResultsMessage(){return resultsMessage;}

    public JLabel getErrorText(){return errorText;}

    public JLabel getResults(){ return results; }

    public JPanel getCards() { return cards; }

    public JButton getBackToMain(){ return backToMain; }

    public JButton getAutoButton() { return autoButton; }

    public ButtonGroup getAutoButtons(){return autoButtons;}

    public ButtonGroup getHomeButtons(){return homeButtons;}

    public ButtonGroup getBusinessButtons(){return businessButtons;}

    public JButton getBusinessButton() {
        return businessButton;
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JRadioButton getMonths36() {
        return months36;
    }

    public JRadioButton getMonths72() {
        return months72;
    }

    public JRadioButton getYear3() {
        return year3;
    }

    public JRadioButton getYear5() {
        return year5;
    }

    public JRadioButton getYear15() {
        return year15;
    }

    public JRadioButton getYear30() {
        return year30;
    }

    public JTextField getDownPayment() {
        return downPayment;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getPrinciple() {
        return principle;
    }
}
