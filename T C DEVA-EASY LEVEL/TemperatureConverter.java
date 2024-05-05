/*
This code below show an application that converts temperatures between Celsius, Fahrenheit, and Kelvin scales,
Name: Deva,
Task4: Temperature Converter,
Java Internship Programming.
 */
import java.util.Scanner;

public class TemperatureConverter {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Choose conversion (1-6): ");

        int choice = scanner.nextInt();

        double inputTemp, resultTemp;

        switch(choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                inputTemp = scanner.nextDouble();
                resultTemp = celsiusToFahrenheit(inputTemp);
                System.out.println("Temperature in Fahrenheit: " + resultTemp);
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                inputTemp = scanner.nextDouble();
                resultTemp = fahrenheitToCelsius(inputTemp);
                System.out.println("Temperature in Celsius: " + resultTemp);
                break;
            case 3:
                System.out.print("Enter temperature in Celsius: ");
                inputTemp = scanner.nextDouble();
                resultTemp = celsiusToKelvin(inputTemp);
                System.out.println("Temperature in Kelvin: " + resultTemp);
                break;
            case 4:
                System.out.print("Enter temperature in Kelvin: ");
                inputTemp = scanner.nextDouble();
                resultTemp = kelvinToCelsius(inputTemp);
                System.out.println("Temperature in Celsius: " + resultTemp);
                break;
            case 5:
                System.out.print("Enter temperature in Fahrenheit: ");
                inputTemp = scanner.nextDouble();
                resultTemp = fahrenheitToKelvin(inputTemp);
                System.out.println("Temperature in Kelvin: " + resultTemp);
                break;
            case 6:
                System.out.print("Enter temperature in Kelvin: ");
                inputTemp = scanner.nextDouble();
                resultTemp = kelvinToFahrenheit(inputTemp);
                System.out.println("Temperature in Fahrenheit: " + resultTemp);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
