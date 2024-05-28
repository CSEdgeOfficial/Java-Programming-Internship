import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Create a Scanner object for reading input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Create a Random object for generating random numbers
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        
        // Set the maximum number of attempts
        int maxAttempts = 10;
        
        // Initialize the number of attempts used
        int attempts = 0;
        
        // Variable to track if the user has guessed the number
        boolean hasGuessedCorrectly = false;
        
        // Game introduction
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        
        // Game loop
        while (attempts < maxAttempts) {
            // Increment the number of attempts
            attempts++;
            
            // Prompt the user for a guess
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            // Check if the user's guess is correct
            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }
        }
        
        // Check if the user guessed the number correctly
        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
        }
        
        // Close the scanner
        scanner.close();
    }
}
