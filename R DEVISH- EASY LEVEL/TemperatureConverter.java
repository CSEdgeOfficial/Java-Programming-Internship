import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("Choose the original temperature scale:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        int originalScale = scanner.nextInt();

        System.out.println("Enter the temperature:");
        double temperature = scanner.nextDouble();

        System.out.println("Choose the target temperature scale:");
        System.out.println("1.Celsius");
        System.out.println("2.Fahrenheit");
        System.out.println("3.Kelvin");
        int targetScale = scanner.nextInt();

        double convertedTemperature = convertTemperature(temperature, originalScale, targetScale);

        System.out.println("Converted temperature:" + convertedTemperature);

        scanner.close();
    }

    public static double convertTemperature(double temperature, int originalScale, int targetScale) {
        switch (originalScale) {
            case 1:
                switch (targetScale) {
                    case 1:
                        return temperature;
                    case 2:
                        return celsiusToFahrenheit(temperature);
                    case 3: // Celsius to Kelvin
                        return celsiusToKelvin(temperature);
                }
            case 2: 
                switch (targetScale) {
                    case 1:
                        return fahrenheitToCelsius(temperature);
                    case 2:
                        return temperature;
                    case 3: 
                        return fahrenheitToKelvin(temperature);
                }
            case 3: // Kelvin
                switch (targetScale) {
                    case 1: 
                        return kelvinToCelsius(temperature);
                    case 2:
                        return kelvinToFahrenheit(temperature);
                    case 3:
                        return temperature;
                }
            default:
                return 0.0;
        }
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