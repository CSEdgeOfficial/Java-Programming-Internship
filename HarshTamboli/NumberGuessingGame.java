package HarshTamboli.NumberGuessingGame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String args[]) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int chances = 5;
        int randomNumber = random.nextInt(100);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + chances + " chances to guess the number.");

        for (int i = 0; i < chances; i++) {
            System.out.println("Enter your guess (between 0 and 99):");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed it right!");
                break;
            } else {
                System.out.println("Incorrect guess. You have " + (chances - i - 1) + " chances left.");
            }
        }       
        scanner.close();
    }
}