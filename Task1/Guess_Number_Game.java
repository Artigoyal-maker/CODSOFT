package NumberGuessingGame;
import java.util.Scanner;
import java.util.Random;

public class Guess_Number_Game {
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		int score = 0;
		String plyAgn = "Yes";
		
		while(plyAgn.equalsIgnoreCase("Yes")) {
			int attempt = 0;
			int maxAttempts = 5;
			int randomNo = r.nextInt(100)+1;
			boolean guessRight = false;
			System.out.println("Guess a number between 1 to 100");
			System.out.println("You have " +maxAttempts+ " attempts");
			
			while(attempt < maxAttempts) {
				System.out.println("Enter your guess:");
				int guess = s.nextInt();
				attempt++;
				
				if(guess == randomNo) {
					System.out.println("Correct! You guessed right number.");
					score += (maxAttempts - attempt +1);
					guessRight = true;
					break;
				}else if(guess <  randomNo) {
					System.out.println("Too low! Try again.");
				}else {
					System.out.println("Too high! Try again.");
				}
			}
			if(!guessRight) {
				System.out.println("Sorry! you used all attempts.");
				System.out.println("The correct number was " +randomNo);
			}
			System.out.println("Your Score :"+score);
			System.out.println("Do you want to play again? (Yes/No): ");
			plyAgn = s.next();
		}
		System.out.println("Game over! Final score: "+score);
		s.close();
	}
}
