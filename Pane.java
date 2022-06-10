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
	JLabel title = new JLabel(new ImageIcon("Nokum4.jpg"));
	JLabel subTitle = new JLabel("===============");
	JLabel subTitle2 = new JLabel("===============");
	JLabel question = new JLabel();
	JLabel answer = new JLabel("Answer: ");
	JLabel gameOver = new JLabel();
	
	JButton playButton = new JButton("PLAY");
	JButton multiplicationButton = new JButton("x");
	JButton additionButton = new JButton("+");
	JButton substractionButton = new JButton("-");
	JButton divisionButton = new JButton("/");
	JButton restartButton = new JButton("RESTART");
	JButton exitButton  = new JButton ("EXIT");
	
	JTextField answerField = new JTextField(10);
	JTextField remarksField = new JTextField(15);
	JTextField rightCounterField = new JTextField(3);
	JTextField wrongCounterField = new JTextField(3);
	
	Font titleFont = new Font("Tahoma", Font.BOLD, 58);
	Font questionFont = new Font("Tahoma", Font.BOLD, 48);
	Font answerFont = new Font("Tahoma", Font.BOLD, 38);
	
	Controller controller = new Controller();
	Random random = new Random();
	int rightCount = 0;
	int wrongCount = 0;
	int Limit = 10;
	public Boolean Load;
	String questionText = "";
	int userAnswer = 0;
	public Pane() {
		
		setLayout(new FlowLayout());
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
	
		
		multiplicationButton.setBackground(Color.black);
		additionButton.setBackground(Color.black);
		substractionButton.setBackground(Color.black);
		divisionButton.setBackground(Color.black);
		playButton.setBackground(Color.orange);
		
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
		
		
		remarksField.setHorizontalAlignment(JTextField.CENTER);
		wrongCounterField.setHorizontalAlignment(JTextField.RIGHT);
		
		playButton.addActionListener(this);
		answerField.addActionListener(this);
		multiplicationButton.addActionListener(this);
		additionButton.addActionListener(this);
		substractionButton.addActionListener(this);
		divisionButton.addActionListener(this);
		restartButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		setTitle("NOKUM");
		setIconImage(new ImageIcon("Title.jpeg").getImage());
		setSize(650,520);
		setLocation(900,100);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public void actionPerformed(ActionEvent Ev) {
		
		if(Ev.getSource() == playButton) {
			getContentPane().setBackground(Color.white);
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
		
		if(Ev.getSource() == multiplicationButton) {
			
			question.setText(controller.setQuestion("x"));
			answerField.setEditable(true);
			question.setForeground(Color.blue);
			
		}
		
		if(Ev.getSource() == additionButton) {
			
			question.setText(controller.setQuestion("+"));
			answerField.setEditable(true);
			question.setForeground(Color.red);
		}
		
		if(Ev.getSource() == substractionButton) {
			question.setText(controller.setQuestion("-"));
			answerField.setEditable(true);
			question.setForeground(Color.green);
		}
		
		if(Ev.getSource() == divisionButton) {
			question.setText(controller.setQuestion("/"));
			answerField.setEditable(true);
			question.setForeground(Color.yellow);
		}
		
		if(Ev.getSource() == restartButton) {
			new Pane();
			wrongCount = 0;
			rightCount = 0;
			this.setVisible(false);
		}
		
		if(Ev.getSource() == exitButton) {
			System.exit(0);
		}
		
		if(Ev.getSource() == answerField) {

			try { 
				userAnswer = Integer.parseInt(answerField.getText());
			}
			catch (Exception Ex) {
				remarksField.setText(getErrorResponse());
			}
				if(userAnswer == controller.getCorrectAnswer()) {
					remarksField.setForeground(Color.blue);
					remarksField.setText(getCorrectResponse());
					answerField.setText("");
					rightCounterField.setText(rightCount + "");
					question.setText(questionText);
				}

				else {
					remarksField.setForeground(Color.red);
					remarksField.setText(getWrongResponse());
					answerField.setText("");
					wrongCounterField.setText(wrongCount + "");
					
					if(wrongCount >= Limit) {
						getContentPane().setBackground(Color.black);
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
		rightCount++;

		switch(random.nextInt(5)) {
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
		wrongCount++;

		
		switch(random.nextInt(5)) {
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
		wrongCount--;

		
		switch(random.nextInt(4)) {
			case 0: response = "Wrong input type!"; break;
			case 1: response = "Number please"; break;
			case 2: response = "Invalid input"; break;
			case 3: response = "I need number"; break;
		}
		return response;
	}

	
}