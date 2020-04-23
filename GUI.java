
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;

//imports for sound
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class GUI {
	private JPanel cards;
	
	//path for sound file
	String filepath = "Money.wav";
	
	//declaring and initializing labels for main page of gui
	private ClearJLabel lblName = new ClearJLabel("Name");
	private ClearJLabelCentered lblCredit = new ClearJLabelCentered("Credit Score");
	private ClearJLabel lblPrin = new ClearJLabel("Principle");
	private ClearJLabel lblDown = new ClearJLabel("Down Payment");

	//declaring and initializing text fields for main page of gui
	private ClearJTextField name = new ClearJTextField(20);
	private ClearJTextField principle = new ClearJTextField(20);
	private ClearJTextField downPayment = new ClearJTextField(20);

	//declaring and initializing credit slider for main page of gui
	private JSlider credit = new JSlider();

	//declaring and initializing auto and lengths for main page of gui
	private ClearJButton autoButton = new ClearJButton("Auto");
	private ClearJRadioButton months36 = new ClearJRadioButton("36 Months");
	private ClearJRadioButton months72 = new ClearJRadioButton("72 Months");

	//declaring and initializing mortgage and lengths for main page of gui
	private ClearJButton homeButton = new ClearJButton("Home");
	private ClearJRadioButton year15 = new ClearJRadioButton("15 Years");
	private ClearJRadioButton year30 = new ClearJRadioButton("30 Years");

	//declaring and initializing mortgage and lengths for main page of gui
	private ClearJButton businessButton = new ClearJButton("Business");
	private ClearJRadioButton year3 = new ClearJRadioButton("3 Years");
	private ClearJRadioButton year5 = new ClearJRadioButton("5 Years");

	//declaring and initializing submit button and error messages for main page of gui
	private ClearJButton submitButton = new ClearJButton("Submit");
	private ClearJLabel errorText = new ClearJLabel("");

	//declaring and initializing button groups for each type of loan
	private ButtonGroup autoButtons = new ButtonGroup();
	private ButtonGroup homeButtons = new ButtonGroup();
	private ButtonGroup businessButtons = new ButtonGroup();

	//declaring and initializing the back button for the results page
	private JButton backToMain = new JButton("Back");

	//declaring and initializing the bank logo arrays and monthly payment results for the results page
	private JLabel[] banks = new JLabel[3];
	private JLabel[] monthly = new JLabel[3];
	private JLabel resultsMessage = new JLabel();

	public GUI() {
	}

	public void createAndShowGUI() throws IOException {
		
		// play background music
		playMusic(filepath);
		
		// Create and set up the window.
		JFrame frame = new JFrame("Shark Loans");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* left this in, in case classloader doesn't work
		frame.setIconImage(new ImageIcon("images/SharkIcon.png").getImage());
		JPanelWithBackground pane = new JPanelWithBackground("images/sharkLoadBG.png");
		ImageIcon icon = new ImageIcon("images/sharkLoansLogo.png");
		JPanelWithBackground pane2 = new JPanelWithBackground("images/sharkLoadBG.png");
		 */

		//image imports for creating .jar file
		ClassLoader cl = this.getClass().getClassLoader();
		frame.setIconImage(new ImageIcon(cl.getResource("images/sharkicon.png")).getImage());
		JPanelWithBackground pane = new JPanelWithBackground(cl.getResource("images/sharkLoadBG.png"));
		ImageIcon icon = new ImageIcon(cl.getResource("images/sharkLoansLogo.png"));
		JPanelWithBackground pane2 = new JPanelWithBackground(cl.getResource("images/sharkLoadBG.png"));
		ImageIcon icon2 = new ImageIcon(cl.getResource("images/sharkLoansLogo.png"));

		//***************** pane 1 "MAIN" *******************
		pane.setLayout(new GridBagLayout());

		// create grid bag layout
		GridBagConstraints gb = new GridBagConstraints();

		//create fonts
		Font font1 = new Font("Ariel", Font.BOLD, 20);
		Font font2 = new Font("Ariel", Font.BOLD, 40);

		//reserving logo picture
		JLabel logo = new JLabel();
		logo.setIcon(icon);

		// placing logo letting it take up whole width of top grid x=0
		gb.gridwidth = 3;
		gb.ipady = 20;
		gb.gridx = 0;
		gb.gridy = 0;
		pane.add(logo, gb);
		gb.gridwidth = 1;

		// %%%%%%%%% placing "Name" label %%%%%%%%%
		gb.gridx = 0;
		gb.gridy = 1;
		pane.add(lblName, gb);

		//placing "Principle" label
		gb.gridx = 1;
		gb.gridy = 1;
		pane.add(lblPrin, gb);

		//placing "Down Payment" label
		gb.gridx = 2;
		gb.gridy = 1;
		pane.add(lblDown, gb);

		// _________ placing Name Text field _____________
		gb.gridx = 0;
		gb.gridy = 2;
		pane.add(name, gb);

		// placing Principle Text field
		gb.gridx = 1;
		gb.gridy = 2;
		pane.add(principle, gb);

		// placing Down Payment Text field
		gb.gridx = 2;
		gb.gridy = 2;
		pane.add(downPayment, gb);


		//place "Credit" label
		gb.gridx = 1;
		gb.gridy = 3;
		pane.add(lblCredit, gb);

		//+++++++++++++++++++ place credit slider ++++++++++
		gb.gridx = 1;
		gb.gridy = 4;
		gb.ipady = 10;
		credit.setOpaque(false);
		pane.add(credit, gb);
		gb.ipady = 30;

		// Turn on labels at major tick marks for credit slider.
		credit.setMajorTickSpacing(100);
		credit.setMinorTickSpacing(50);
		credit.setPaintTicks(true);
		credit.setSnapToTicks( true );

		// Set the labels to be painted on the slider
		credit.setPaintLabels(true);

		// Add positions label in the slider
		JLabel lLabel1 = new JLabel( "Average");
		lLabel1.setForeground( Color.WHITE );
		JLabel lLabel2 = new JLabel( "Good");
		lLabel2.setForeground( Color.WHITE );
		JLabel lLabel3 = new JLabel( "Excellent");
		lLabel3.setForeground( Color.WHITE );
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(0, lLabel1);
		position.put(50, lLabel2);
		position.put(100, lLabel3);

		// Set the label to be drawn
		credit.setLabelTable(position);

		// ~~~~~~~~~ place auto loan button ~~~~~~~~~~
		gb.gridx = 0;
		gb.gridy = 5;
		pane.add(autoButton, gb);

		// place 36 month auto loan radio
		gb.gridx = 0;
		gb.gridy = 6;
		pane.add(months36, gb);

		// place 36 month auto loan radio
		gb.gridx = 0;
		gb.gridy = 7;
		pane.add(months72, gb);

		//placed 36 months and 72 months into auto radio group
		autoButtons.add(months36);
		autoButtons.add(months72);

		//place home button
		gb.gridx = 1;
		gb.gridy = 5;
		pane.add(homeButton, gb);

		// place 15 year home loan radio
		gb.gridx = 1;
		gb.gridy = 6;
		pane.add(year15, gb);

		// place 30 year home loan radio
		gb.gridx = 1;
		gb.gridy = 7;
		pane.add(year30, gb);

		//placed 15 year and 30 year into home radio group
		homeButtons.add(year15);
		homeButtons.add(year30);

		//place business button
		gb.gridx = 2;
		gb.gridy = 5;
		pane.add(businessButton, gb);

		//place 3 year business loan button
		gb.gridx = 2;
		gb.gridy = 6;
		pane.add(year3, gb);

		//place 5 year business loan button
		gb.gridx = 2;
		gb.gridy = 7;
		pane.add(year5, gb);

		//placed 5 year and 3 year into business radio group
		businessButtons.add(year5);
		businessButtons.add(year3);

		//~~~~~~~~~~~~~ place submit button ~~~~~~~~~~~~~~
		gb.gridx = 0;
		gb.gridy = 8;
		gb.gridwidth = 3;
		gb.fill = GridBagConstraints.BOTH;
		submitButton.setFont(font2);
		submitButton.setBorderPainted(true);
		pane.add(submitButton, gb);

		//placing error text
		gb.gridx = 0;
		gb.gridy = 10;
		pane.add(errorText, gb);
		errorText.setFont(font2);
		errorText.setForeground(Color.pink);

		//***************** Pane 2 "RESULTS" ****************
		//setting grid bag2 layout
		pane2.setLayout(new GridBagLayout());
		GridBagConstraints gb2 = new GridBagConstraints();

		//adding logo to pane2
		//ImageIcon icon2 = new ImageIcon("images/sharkLoansLogo.png");
		JLabel logo2 = new JLabel();
		logo2.setIcon(icon2);

		//placing logo into grid bag2
		gb2.gridwidth = 2;
		gb2.gridx = 1;
		gb2.gridy = 0;
		gb2.anchor = GridBagConstraints.LINE_START;
		pane2.add(logo2, gb2);

		//placing back button into grid bag2
		gb2.gridwidth = 1;
		gb2.gridx = 0;
		gb2.gridy = 0;
		gb2.anchor = GridBagConstraints.LINE_START;
		pane2.add(backToMain, gb2);

		//**********placing results message into grid bag2************
		gb2.gridwidth = 3;
		gb2.ipady = 100;
		gb2.gridx = 0;
		gb2.gridy = 1;
		resultsMessage.setFont(font1);
		resultsMessage.setForeground(Color.white);
		pane2.add(resultsMessage, gb2);
		gb2.gridwidth = 1;

		//^^^^^^for loop to run though placing logos and monthly prices in the grid bag2 ^^^^
		for (int x = 0; x < 3; x++) {
			// normal image import ImageIcon bank1logo = new ImageIcon("images/bank" + (x + 1) + ".png");
			ImageIcon bank1logo = new ImageIcon(cl.getResource("images/bank" + (x + 1) + ".png"));
			banks[x] = new JLabel();
			banks[x].setIcon(bank1logo);

			// Bank logos location
			gb2.gridx = 0;
			gb2.gridy = x + 3;
			gb2.ipadx = 50;
			gb2.ipady = 10;
			pane2.add(banks[x], gb2);

			// Monthly payment text location
			gb2.gridx = 1;
			gb2.gridy = x + 3;
			monthly[x] = new JLabel();
			monthly[x].setFont(font2);
			monthly[x].setForeground(Color.white);
			pane2.add(monthly[x], gb2);

		}

		// $$$$$$$$$$$$$ create the card layout and nests each grid bag pane into each card $$$$$$$$
		cards = new JPanel(new CardLayout());
		cards.add(pane, "MAIN");
		cards.add(pane2, "RESULTS");

		// Display the window.
		frame.getContentPane().add(cards);
		frame.pack();
		frame.setVisible(true);
		
	}

	
	// method to play background music
	public static void playMusic(String musicLocation) {

		try {
			File musicPath = new File(musicLocation);

			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				System.out.println("Can't find file");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	//these are the getter methods so the controller class can access the GUI elements

	public JSlider getCredit(){return credit;}

	public JLabel getResultsMessage() {
		return resultsMessage;
	}

	public JLabel getMonthly(int x) { return monthly[x]; }

	public JLabel getErrorText() {
		return errorText;
	}

	public JPanel getCards() {
		return cards;
	}

	public JButton getBackToMain() { return backToMain; }

	public JButton getAutoButton() { return autoButton; }

	public ButtonGroup getAutoButtons() {
		return autoButtons;
	}

	public ButtonGroup getHomeButtons() {
		return homeButtons;
	}

	public ButtonGroup getBusinessButtons() {
		return businessButtons;
	}

	public JButton getBusinessButton() {
		return businessButton;
	}

	public JButton getHomeButton() { return homeButton; }

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
