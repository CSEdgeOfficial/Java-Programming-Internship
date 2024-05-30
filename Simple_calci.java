import java.util.Scanner;

public class Simple_calci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    performOperation(scanner, "add");
                    break;
                case 2:
                    performOperation(scanner, "subtract");
                    break;
                case 3:
                    performOperation(scanner, "multiply");
                    break;
                case 4:
                    performOperation(scanner, "divide");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- Basic Calculator ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performOperation(Scanner scanner, String operation) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        switch (operation) {
            case "add":
                System.out.printf("Result: %.2f + %.2f = %.2f\n", num1, num2, num1 + num2);
                break;
            case "subtract":
                System.out.printf("Result: %.2f - %.2f = %.2f\n", num1, num2, num1 - num2);
                break;
            case "multiply":
                System.out.printf("Result: %.2f * %.2f = %.2f\n", num1, num2, num1 * num2);
                break;
            case "divide":
                if (num2 != 0) {
                    System.out.printf("Result: %.2f / %.2f = %.2f\n", num1, num2, num1 / num2);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
        }
    }
}
