import java.util.*;
import java.util.Random;
public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");
        int maxAttempts = 10;
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (between 1 and 100): ");
            int guess = scanner.nextInt();
            attempts++;
            if (guess == secretNumber) {
                guessedCorrectly = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
        } else {
            System.out.println("Sorry, you've exceeded the maximum number of attempts. The correct number was: " + secretNumber);
        }

        scanner.close();
    }
}
