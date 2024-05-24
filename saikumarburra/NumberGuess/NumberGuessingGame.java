import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                break;
            }

            if (attempts < maxAttempts) {
                int remainingAttempts = maxAttempts - attempts;
                if (remainingAttempts > 1) {
                    System.out.println("You have " + remainingAttempts + " attempts left.");
                } else {
                    System.out.println("You have 1 attempt left.");
                }
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've run out of attempts! The correct number was " + randomNumber + ".");
        }
    }
}
