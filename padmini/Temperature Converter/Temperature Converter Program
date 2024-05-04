import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Temperature Converter!");
        System.out.println("Enter the temperature scale you want to convert from:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");

        System.out.print("Enter your choice (1/2/3): ");
        int choiceFrom = scanner.nextInt();

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        double convertedTemperature = 0;

        switch (choiceFrom) {
            case 1:
                System.out.println("Convert Celsius to:");
                System.out.println("1. Fahrenheit");
                System.out.println("2. Kelvin");
                System.out.print("Enter your choice (1/2): ");
                int choiceToCelsius = scanner.nextInt();
                if (choiceToCelsius == 1) {
                    convertedTemperature = celsiusToFahrenheit(temperature);
                    System.out.println(temperature + " Celsius = " + convertedTemperature + " Fahrenheit");
                } else if (choiceToCelsius == 2) {
                    convertedTemperature = celsiusToKelvin(temperature);
                    System.out.println(temperature + " Celsius = " + convertedTemperature + " Kelvin");
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            case 2:
                System.out.println("Convert Fahrenheit to:");
                System.out.println("1. Celsius");
                System.out.println("2. Kelvin");
                System.out.print("Enter your choice (1/2): ");
                int choiceToFahrenheit = scanner.nextInt();
                if (choiceToFahrenheit == 1) {
                    convertedTemperature = fahrenheitToCelsius(temperature);
                    System.out.println(temperature + " Fahrenheit = " + convertedTemperature + " Celsius");
                } else if (choiceToFahrenheit == 2) {
                    convertedTemperature = fahrenheitToKelvin(temperature);
                    System.out.println(temperature + " Fahrenheit = " + convertedTemperature + " Kelvin");
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            case 3:
                System.out.println("Convert Kelvin to:");
                System.out.println("1. Celsius");
                System.out.println("2. Fahrenheit");
                System.out.print("Enter your choice (1/2): ");
                int choiceToKelvin = scanner.nextInt();
                if (choiceToKelvin == 1) {
                    convertedTemperature = kelvinToCelsius(temperature);
                    System.out.println(temperature + " Kelvin = " + convertedTemperature + " Celsius");
                } else if (choiceToKelvin == 2) {
                    convertedTemperature = kelvinToFahrenheit(temperature);
                    System.out.println(temperature + " Kelvin = " + convertedTemperature + " Fahrenheit");
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }
}
