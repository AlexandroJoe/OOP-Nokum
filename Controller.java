import java.util.Random;


public class Controller {
	
	Random random = new Random();
	FirstNumber firstNumber = new FirstNumber(0);
	SecondNumber secondNumber = new SecondNumber(0);
	CorrectAnswer correctAnswer = new CorrectAnswer(0);
	Boolean Error;
	
	public int getRandomNumber() {
		return random.nextInt(15 + 10)-10;
	}
	
	public int getCorrectAnswer() {
		return correctAnswer.getData();
	} 
		
	public String setQuestion(String operator) {
		firstNumber.setData(getRandomNumber()); 
		secondNumber.setData(getRandomNumber());
		
		
		switch(operator) {
			case "x": correctAnswer.setData(firstNumber.getData() * secondNumber.getData()); break;
			case "+": correctAnswer.setData(firstNumber.getData() + secondNumber.getData()); break;
			case "-": correctAnswer.setData(firstNumber.getData() - secondNumber.getData()); break;
			case "/": 
				if(firstNumber.getData() == 0) {
					firstNumber.increment();
					if(secondNumber.getData() == 0)
						secondNumber.getData();
				}
				else if (secondNumber.getData() == 0)
					secondNumber.increment();
				correctAnswer.setData(firstNumber.getData() /secondNumber.getData());
				break;
		}
		return "How Much is (" + firstNumber.getData() +") " + operator  + "(" + secondNumber.getData() + ") ? ";
	}
}
