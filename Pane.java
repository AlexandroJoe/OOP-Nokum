import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Pane extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaring JLabel 
	JLabel title = new JLabel(new ImageIcon("Nokum4.jpg"));
	JLabel subTitle = new JLabel("===============");
	JLabel subTitle2 = new JLabel("===============");
	JLabel question = new JLabel();
	JLabel answer = new JLabel("Answer: ");
	JLabel gameOver = new JLabel();
	
	//Declaring JButton
	JButton playButton = new JButton("PLAY");
	JButton multiplicationButton = new JButton("x");
	JButton additionButton = new JButton("+");
	JButton substractionButton = new JButton("-");
	JButton divisionButton = new JButton("/");
	JButton restartButton = new JButton("RESTART");
	JButton exitButton  = new JButton ("EXIT");
	
	//Declaring JTextField
	JTextField answerField = new JTextField(10);
	JTextField remarksField = new JTextField(15);
	JTextField rightCounterField = new JTextField(3);
	JTextField wrongCounterField = new JTextField(3);
	
	//Declaring Fonts
	Font titleFont = new Font("Tahoma", Font.BOLD, 58);
	Font questionFont = new Font("Tahoma", Font.BOLD, 48);
	Font answerFont = new Font("Tahoma", Font.BOLD, 38);
	
	
	Controller controller = new Controller();
	Random random = new Random();
	int rightCount = 0;
	int wrongCount = 0;
	int Limit = 10;
	String questionText = "";
	int userAnswer = 0;
	
	public Pane() {
		
		setLayout(new FlowLayout()); //Use the FlowLayout to manage elements inside the frame
		add(title);
		add(subTitle);
		add(question);
		add(subTitle2);
		add(answer);
		add(answerField);
		add(rightCounterField);
		add(multiplicationButton);
		add(additionButton);
		add(substractionButton);
		add(divisionButton);
		add(wrongCounterField);
		add(remarksField);
		add(playButton);
		add(gameOver);
		add(restartButton);
		add(exitButton);
		
		//Set the elements to false, so play button is visible
		rightCounterField.setVisible(false); 
		wrongCounterField.setVisible(false);
		question.setVisible(false);
		subTitle2.setVisible(false);
		answer.setVisible(false);
		answerField.setVisible(false);
		multiplicationButton.setVisible(false);
		additionButton.setVisible(false);
		substractionButton.setVisible(false);
		divisionButton.setVisible(false);
		remarksField.setVisible(false);
		restartButton.setVisible(false);
		exitButton.setVisible(false);
		gameOver.setVisible(false);
		
		//Set the foreground color of each element
		getContentPane().setBackground(Color.white);
		rightCounterField.setForeground(Color.blue);
		wrongCounterField.setForeground(Color.red);
		question.setForeground(Color.red);
		answerField.setForeground(Color.blue);
		additionButton.setForeground(Color.red);
		substractionButton.setForeground(Color.green);
		multiplicationButton.setForeground(Color.blue);
		divisionButton.setForeground(Color.yellow);
		gameOver.setForeground(Color.orange);
	
		//Set the background color of each element 
		multiplicationButton.setBackground(Color.black);
		additionButton.setBackground(Color.black);
		substractionButton.setBackground(Color.black);
		divisionButton.setBackground(Color.black);
		playButton.setBackground(Color.orange);
		
		//Set the font of each element 
		title.setFont(titleFont);
		subTitle.setFont(questionFont);
		subTitle2.setFont(questionFont);
		question.setFont(questionFont);
		answer.setFont(answerFont);
		answerField.setFont(answerFont);
		remarksField.setFont(answerFont);
		rightCounterField.setFont(answerFont);
		wrongCounterField.setFont(answerFont);
		multiplicationButton.setFont(titleFont);
		additionButton.setFont(titleFont);
		substractionButton.setFont(titleFont);
		divisionButton.setFont(titleFont);
		playButton.setFont(new Font("Tahoma", Font.BOLD, 100));
		restartButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		gameOver.setFont(new Font("Tahoma", Font.BOLD, 100));
		
		//Set the alignment for the remarksField and wronCounterField
		remarksField.setHorizontalAlignment(JTextField.CENTER);
		wrongCounterField.setHorizontalAlignment(JTextField.RIGHT);
		
		//Add action listener to the button
		playButton.addActionListener(this);
		answerField.addActionListener(this);
		multiplicationButton.addActionListener(this);
		additionButton.addActionListener(this);
		substractionButton.addActionListener(this);
		divisionButton.addActionListener(this);
		restartButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		//Setting up the frame 
		setTitle("NOKUM");
		setIconImage(new ImageIcon("Title.jpeg").getImage());
		setSize(650,520);
		setLocation(900,100);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	//Setting up function if the button is pressed
	public void actionPerformed(ActionEvent Ev) {
		
		//Set the button and the field if the playButton is pressed
		if(Ev.getSource() == playButton) {
			getContentPane().setBackground(Color.white);
			//Set all elements to be visible except the playButton 
			playButton.setVisible(false);
			rightCounterField.setVisible(true);
			wrongCounterField.setVisible(true);
			question.setVisible(true);
			subTitle2.setVisible(true);
			answer.setVisible(true);
			multiplicationButton.setVisible(true);
			additionButton.setVisible(true);
			substractionButton.setVisible(true);
			divisionButton.setVisible(true);
			remarksField.setVisible(true);
			answerField.setVisible(true);
			answerField.setEditable(false);
		}
		
		//Set the panels if multiplactionButton is pressed
		if(Ev.getSource() == multiplicationButton) {
			
			question.setText(controller.setQuestion("x")); //Function to generate the question 
			answerField.setEditable(true); //Set the answerField to be editable so user can edit
			question.setForeground(Color.blue); //Set the foreground color
			
		}
		
		//Set the panels if additionButton is pressed
		if(Ev.getSource() == additionButton) {
			
			question.setText(controller.setQuestion("+")); //Function to generate the question
			answerField.setEditable(true); //Set the answerField to be editable so user can edit
			question.setForeground(Color.red); //Set the foreground color
		}
		
		//Set the panels if substractionButton is pressed
		if(Ev.getSource() == substractionButton) {
			
			question.setText(controller.setQuestion("-")); //Function to generate the question 
			answerField.setEditable(true); //Set the answerField to be editable so user can edit
			question.setForeground(Color.green); //Set the foreground color
			
		}
		
		//Set the panels if divisionButton is pressed
		if(Ev.getSource() == divisionButton) {
			
			question.setText(controller.setQuestion("/")); //Function to generate the question
			answerField.setEditable(true); //Set the answerField to be editable so user can edit
			question.setForeground(Color.yellow); //Set the foreground color
			
		}
		
		//Set the panels if restartButton is pressed
		if(Ev.getSource() == restartButton) {
			new Pane(); 
			wrongCount = 0; //set the wrong count to 0
			rightCount = 0; //set the right count to 0
			this.setVisible(false);
		}
		
		//Set the exit button
		if(Ev.getSource() == exitButton) {
			System.exit(0);
		}
		
		//Function to check the user input
		if(Ev.getSource() == answerField) {

			//Try catch to avoid errors if user input an invalid type
			try { 
				userAnswer = Integer.parseInt(answerField.getText());
			}
			catch (Exception Ex) {
				remarksField.setText(getErrorResponse());
			} 
				//if else statement if the user input is correct
				if(userAnswer == controller.getCorrectAnswer()) {
					remarksField.setForeground(Color.blue);
					remarksField.setText(getCorrectResponse()); //generate random correct response
					answerField.setText("");
					rightCounterField.setText(rightCount + ""); //display the right count
					question.setText(questionText);
					answerField.setEditable(false);
				}
				
				//statement to check if the user input is wrong
				else {
					remarksField.setForeground(Color.red);
					remarksField.setText(getWrongResponse()); //generate random wrong response
					answerField.setText("");
					wrongCounterField.setText(wrongCount + ""); // display the wrong count 
					
					//Statement if the wrongCount reached the limit
					if(wrongCount >= Limit) {
						getContentPane().setBackground(Color.black);
						
						//Set all elements to be false except restartButton and exitButton
						gameOver.setText("GAME OVER");
						gameOver.setVisible(true);
						restartButton.setVisible(true);
						exitButton.setVisible(true);
						rightCounterField.setVisible(false);
						wrongCounterField.setVisible(false);
						question.setVisible(false);
						subTitle2.setVisible(false);
						answer.setVisible(false);
						answerField.setVisible(false);
						answerField.setEditable(false);
						multiplicationButton.setVisible(false);
						additionButton.setVisible(false);
						substractionButton.setVisible(false);
						divisionButton.setVisible(false);
						remarksField.setVisible(false);
						answerField.setVisible(false);
						answerField.setEditable(false);
					}
				}			
		}
	}
	
	public String getCorrectResponse() {
		String response ="";
		rightCount++; //increment the rightCount

		switch(random.nextInt(5)) { //randomize the response
			case 0: response = "Excellent"; break;
			case 1: response = "Very Good!"; break;
			case 2: response = "Correct!"; break;
			case 3: response = "That's Right!"; break;
			case 4: response = "Awesome!"; break;
		}
		return response;
	}
	
	public String getWrongResponse() {
		String response ="";
		wrongCount++; //increment the wrongCount

		
		switch(random.nextInt(5)) { //randomize the response
			case 0: response = "Wrong!"; break;
			case 1: response = "Sorry, Please Try Again"; break;
			case 2: response = "Dont Give Up!"; break;
			case 3: response = "Try Once More!"; break;
			case 4: response = "Sorry, Incorrect!"; break;
		}
		return response;
	}
	
	public String getErrorResponse() {
		String response ="";
		wrongCount--; //decrement the wrongCount to reduce double increment

		
		switch(random.nextInt(4)) { //randomize the response
		case 0: response = "Wrong!"; break;
		case 1: response = "Sorry, Please Try Again"; break;
		case 2: response = "Dont Give Up!"; break;
		case 3: response = "Try Once More!"; break;
		}
		return response;
	}

	
}