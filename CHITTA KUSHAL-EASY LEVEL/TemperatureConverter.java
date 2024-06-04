import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Enter your choice (1-6): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                celsiusToFahrenheit(scanner);
                break;
            case 2:
                fahrenheitToCelsius(scanner);
                break;
            case 3:
                celsiusToKelvin(scanner);
                break;
            case 4:
                kelvinToCelsius(scanner);
                break;
            case 5:
                fahrenheitToKelvin(scanner);
                break;
            case 6:
                kelvinToFahrenheit(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    private static void celsiusToFahrenheit(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }

    private static void fahrenheitToCelsius(Scanner scanner) {
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Temperature in Celsius: " + celsius);
    }

    private static void celsiusToKelvin(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double kelvin = celsius + 273.15;
        System.out.println("Temperature in Kelvin: " + kelvin);
    }

    private static void kelvinToCelsius(Scanner scanner) {
        System.out.print("Enter temperature in Kelvin: ");
        double kelvin = scanner.nextDouble();
        double celsius = kelvin - 273.15;
        System.out.println("Temperature in Celsius: " + celsius);
    }

    private static void fahrenheitToKelvin(Scanner scanner) {
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double kelvin = (fahrenheit + 459.67) * 5 / 9;
        System.out.println("Temperature in Kelvin: " + kelvin);
    }

    private static void kelvinToFahrenheit(Scanner scanner) {
        System.out.print("Enter temperature in Kelvin: ");
        double kelvin = scanner.nextDouble();
        double fahrenheit = kelvin * 9 / 5 - 459.67;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}
