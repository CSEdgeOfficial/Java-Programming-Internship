import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            double temperature;
            double convertedTemperature;

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = celsiusToFahrenheit(temperature);
                    System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = fahrenheitToCelsius(temperature);
                    System.out.println("Temperature in Celsius: " + convertedTemperature);
                    break;
                case 3:
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = celsiusToKelvin(temperature);
                    System.out.println("Temperature in Kelvin: " + convertedTemperature);
                    break;
                case 4:
                    System.out.print("Enter temperature in Kelvin: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = kelvinToCelsius(temperature);
                    System.out.println("Temperature in Celsius: " + convertedTemperature);
                    break;
                case 5:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = fahrenheitToKelvin(temperature);
                    System.out.println("Temperature in Kelvin: " + convertedTemperature);
                    break;
                case 6:
                    System.out.print("Enter temperature in Kelvin: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = kelvinToFahrenheit(temperature);
                    System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return kelvin * 9 / 5 - 459.67;
    }
}
