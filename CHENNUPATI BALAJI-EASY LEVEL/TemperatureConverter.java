import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter the current scale (C/F/K): ");
        char currentScale = sc.next().charAt(0);

        System.out.print("Enter the target scale (C/F/K): ");
        char targetScale = sc.next().charAt(0);

        double convertedTemperature = convertTemperature(temperature, currentScale, targetScale);
        System.out.printf("The converted temperature is: %.2f %c\n", convertedTemperature, targetScale);
    }

    public static double convertTemperature(double temperature, char currentScale, char targetScale) {
        if (currentScale == targetScale) {
            return temperature;
        }

        double tempInCelsius;
        switch (currentScale) {
            case 'F':
                tempInCelsius = (temperature - 32) * 5/9;
                break;
            case 'K':
                tempInCelsius = temperature - 273.15;
                break;
            case 'C':
                tempInCelsius = temperature;
                break;
            default:
                throw new IllegalArgumentException("Invalid current scale: " + currentScale);
        }
        switch (targetScale) {
            case 'F':
                return (tempInCelsius * 9/5) + 32;
            case 'K':
                return tempInCelsius + 273.15;
            case 'C':
                return tempInCelsius;
            default:
                throw new IllegalArgumentException("Invalid target scale: " + targetScale);
        }
    }
}
