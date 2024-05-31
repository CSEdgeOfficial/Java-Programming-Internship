import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature value:");
        double temperature = scanner.nextDouble();

        System.out.println("Enter the scale to convert from (C, F, K):");
        char fromScale = scanner.next().charAt(0);

        System.out.println("Enter the scale to convert to (C, F, K):");
        char toScale = scanner.next().charAt(0);

        double convertedTemperature = 0.0;

        switch (fromScale) {
            case 'C':
                convertedTemperature = convertFromCelsius(temperature, toScale);
                break;
            case 'F':
                convertedTemperature = convertFromFahrenheit(temperature, toScale);
                break;
            case 'K':
                convertedTemperature = convertFromKelvin(temperature, toScale);
                break;
            default:
                System.out.println("Error! Invalid scale.");
                return;
        }

        System.out.printf("The converted temperature is: %.2f %c%n", convertedTemperature, toScale);
        scanner.close();
    }

    private static double convertFromCelsius(double temperature, char toScale) {
        switch (toScale) {
            case 'F':
                return temperature * 9 / 5 + 32;
            case 'K':
                return temperature + 273.15;
            case 'C':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid scale: " + toScale);
        }
    }

    private static double convertFromFahrenheit(double temperature, char toScale) {
        switch (toScale) {
            case 'C':
                return (temperature - 32) * 5 / 9;
            case 'K':
                return (temperature - 32) * 5 / 9 + 273.15;
            case 'F':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid scale: " + toScale);
        }
    }

    private static double convertFromKelvin(double temperature, char toScale) {
        switch (toScale) {
            case 'C':
                return temperature - 273.15;
            case 'F':
                return (temperature - 273.15) * 9 / 5 + 32;
            case 'K':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid scale: " + toScale);
        }
    }
}
