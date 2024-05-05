/*
This code below show the simple calculator Application
Name: deva
Task1: Simple basic Calculator Application,
        Java Internship Programming.
*/
import java.util.Scanner;

        public class Calculator {

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = calculate(num1, operator, num2);

        if (Double.isNaN(result)) {
            System.out.println("Error: Invalid operator or division by zero.");
        } else {
            System.out.println("The result is: " + result);
        }
    }

    public static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    return Double.NaN; // Not a number
                } else {
                    return num1 / num2;
                }
            default:
                return Double.NaN;
        }
    }
}
