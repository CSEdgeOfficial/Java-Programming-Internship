import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfAttempts = 0;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            numberOfAttempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
        } else {
            System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
