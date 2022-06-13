import java.util.Random;


public class Controller {
	
	Random random = new Random();
	FirstNumber firstNumber = new FirstNumber(0);
	SecondNumber secondNumber = new SecondNumber(0);
	CorrectAnswer correctAnswer = new CorrectAnswer(0);
	Boolean Error;
	
	public int getRandomNumber() {
		return random.nextInt(15 + 10)-10; //set the random number generated to be -10 < x < 15
	}
	
	public int getCorrectAnswer() {
		return correctAnswer.getData(); //return the correct answer from the setQuestion function
	} 
		
	public String setQuestion(String operator) {
		firstNumber.setData(getRandomNumber()); //generate random first number
		secondNumber.setData(getRandomNumber()); //generate random second number
		
		
		switch(operator) { //accept the operator from the button 
			case "x": correctAnswer.setData(firstNumber.getData() * secondNumber.getData()); break; //set the correct answer of multiplication question
			case "+": correctAnswer.setData(firstNumber.getData() + secondNumber.getData()); break; //set the correct answer of addition question
			case "-": correctAnswer.setData(firstNumber.getData() - secondNumber.getData()); break; //set the correct answer of subtraction question
			case "/": 
				if(firstNumber.getData() == 0) { 
					firstNumber.increment(); // increment the first number to avoid dividing 0
					if(secondNumber.getData() == 0)
						secondNumber.getData(); 
				}
				else if (secondNumber.getData() == 0)
					secondNumber.increment(); // increment the second number to avoid by 0 division
				correctAnswer.setData(firstNumber.getData() / secondNumber.getData()); //set the correct answer of division question
				break;
		}
		return "How Much is (" + firstNumber.getData() +") " + operator  + "(" + secondNumber.getData() + ") ? "; // return the question based on the button pressed
	}
}
