import java.util.Scanner;

public class BasicCalculator {
    
    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method for division
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("Basic Calculator");

        while (continueCalculation) {
            // Input for first number
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            // Input for second number
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            // Input for operation
            System.out.print("Enter operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            double result;

            // Switch case to handle different operations
            switch (operation) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    try {
                        result = divide(num1, num2);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
                    continue;
            }

            // Output the result
            System.out.println("The result is: " + result);

            // Ask if the user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("yes")) {
                continueCalculation = false;
            }
        }

        // Close the scanner
        scanner.close();
        System.out.println("Calculator closed.");
    }
}
