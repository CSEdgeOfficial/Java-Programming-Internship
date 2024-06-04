import java.util.Scanner;
import java.util.InputMismatchException;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator!");
        while(true) {
            try {
                System.out.println("Enter the operation you want to perform: ");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                if(choice == 0 || choice > 5) {
                    System.out.println("Invalid choice. Please select again.");
                    break;
                }

                if(choice == 5) {
                    System.out.println("Thank you for using Simple Calculator. Goodbye!");
                    break;
                }

                System.out.println("Enter the first number: ");
                double num1 = sc.nextDouble();
                System.out.println("Enter the Second number: ");
                double num2 = sc.nextDouble();


                switch(choice) {
                    case 1 -> System.out.println("Result: "+(num1 + num2));
                    case 2 -> System.out.println("Result: "+(num1 - num2));
                    case 3 -> System.out.println("Result: "+(num1 * num2));
                    case 4 -> {
                        if(num2 == 0) {
                            System.out.println("Error: Division by zero");
                        } else {
                            System.out.println("Result: "+(num1 / num2));
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}