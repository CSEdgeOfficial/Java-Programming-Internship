import java.util.Scanner;

public class Temp_converter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("=====================");
        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Celsius to Kelvin");
        System.out.println("3. Fahrenheit to Celsius");
        System.out.println("4. Fahrenheit to Kelvin");
        System.out.println("5. Kelvin to Celsius");
        System.out.println("6. Kelvin to Fahrenheit");

        int choice = scanner.nextInt();

        System.out.print("Enter the temperature value: ");
        double tempValue = scanner.nextDouble();

        double convertedValue = 0;

        switch (choice) {
            case 1:
                convertedValue = celsiusToFahrenheit(tempValue);
                System.out.println(tempValue + " Celsius is equal to " + convertedValue + " Fahrenheit.");
                break;
            case 2:
                convertedValue = celsiusToKelvin(tempValue);
                System.out.println(tempValue + " Celsius is equal to " + convertedValue + " Kelvin.");
                break;
            case 3:
                convertedValue = fahrenheitToCelsius(tempValue);
                System.out.println(tempValue + " Fahrenheit is equal to " + convertedValue + " Celsius.");
                break;
            case 4:
                convertedValue = fahrenheitToKelvin(tempValue);
                System.out.println(tempValue + " Fahrenheit is equal to " + convertedValue + " Kelvin.");
                break;
            case 5:
                convertedValue = kelvinToCelsius(tempValue);
                System.out.println(tempValue + " Kelvin is equal to " + convertedValue + " Celsius.");
                break;
            case 6:
                convertedValue = kelvinToFahrenheit(tempValue);
                System.out.println(tempValue + " Kelvin is equal to " + convertedValue + " Fahrenheit.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
