import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalWins = 0;
        String playAgain;
       
        do {
            totalRounds++;
            int numberToGuess = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean isGuessedCorrectly = false;
           
            System.out.println("Round " + totalRounds + ":");
            System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX);
           
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int userGuess = scanner.nextInt();
               
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number.");
                    isGuessedCorrectly = true;
                    totalWins++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
               
                attemptsLeft--;
            }
           
            if (!isGuessedCorrectly) {
                System.out.println("You've used all attempts. The number was: " + numberToGuess);
            }
           
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));
       
        System.out.println("Game over! Total rounds: " + totalRounds + ", Rounds won: " + totalWins);
        scanner.close();
    }
}