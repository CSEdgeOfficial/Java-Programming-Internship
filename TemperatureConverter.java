import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("----------------------");
        System.out.println("Select the input temperature scale:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your choice (1-3): ");
        int inputChoice = scanner.nextInt();
        
        System.out.print("Enter the temperature to convert: ");
        double inputTemperature = scanner.nextDouble();
        
        System.out.println("Select the output temperature scale:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your choice (1-3): ");
        int outputChoice = scanner.nextInt();
        
        double convertedTemperature = 0;
        switch (inputChoice) {
            case 1: // Celsius
                convertedTemperature = convertFromCelsius(inputTemperature, outputChoice);
                break;
            case 2: // Fahrenheit
                convertedTemperature = convertFromFahrenheit(inputTemperature, outputChoice);
                break;
            case 3: // Kelvin
                convertedTemperature = convertFromKelvin(inputTemperature, outputChoice);
                break;
            default:
                System.out.println("Invalid input scale choice.");
                return;
        }
        
        String inputScale = getScaleName(inputChoice);
        String outputScale = getScaleName(outputChoice);
        System.out.printf("The temperature %.2f %s is equal to %.2f %s.\n", inputTemperature, inputScale, convertedTemperature, outputScale);
    }

    private static double convertFromCelsius(double temp, int outputChoice) {
        switch (outputChoice) {
            case 1: // Celsius
                return temp;
            case 2: // Fahrenheit
                return (temp * 9/5) + 32;
            case 3: // Kelvin
                return temp + 273.15;
            default:
                throw new IllegalArgumentException("Invalid output scale choice.");
        }
    }

    private static double convertFromFahrenheit(double temp, int outputChoice) {
        switch (outputChoice) {
            case 1: // Celsius
                return (temp - 32) * 5/9;
            case 2: // Fahrenheit
                return temp;
            case 3: // Kelvin
                return (temp - 32) * 5/9 + 273.15;
            default:
                throw new IllegalArgumentException("Invalid output scale choice.");
        }
    }

    private static double convertFromKelvin(double temp, int outputChoice) {
        switch (outputChoice) {
            case 1: // Celsius
                return temp - 273.15;
            case 2: // Fahrenheit
                return (temp - 273.15) * 9/5 + 32;
            case 3: // Kelvin
                return temp;
            default:
                throw new IllegalArgumentException("Invalid output scale choice.");
        }
    }

    private static String getScaleName(int choice) {
        switch (choice) {
            case 1:
                return "Celsius";
            case 2:
                return "Fahrenheit";
            case 3:
                return "Kelvin";
            default:
                return "";
        }
    }
}
