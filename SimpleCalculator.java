import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Displaying the menu
        System.out.println("Simple Calculator");
        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        // Reading the user's choice
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        // Reading the two numbers
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        boolean validChoice = true;

        // Performing the chosen operation
        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validChoice = false;
                }
                break;
            default:
                System.out.println("Invalid choice! Please select a valid operation (1-4).");
                validChoice = false;
        }

        // Displaying the result
        if (validChoice) {
            System.out.println("The result is: " + result);
        }

        scanner.close();
    }
}
