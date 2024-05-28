import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature to convert: ");
        double temperature = scanner.nextDouble();

        System.out.println("Enter the scale to convert from (C, F, or K): ");
        String scaleFrom = scanner.next();

        System.out.println("Enter the scale to convert to (C, F, or K): ");
        String scaleTo = scanner.next();

        double convertedTemperature = convertTemperature(temperature, scaleFrom, scaleTo);

        System.out.println("The converted temperature is: " + convertedTemperature);
    }

    public static double convertTemperature(double temperature, String scaleFrom, String scaleTo) {
        double convertedTemperature = 0;

        if (scaleFrom.equals("C") && scaleTo.equals("F")) {
            convertedTemperature = (temperature * 9/5) + 32;
        } else if (scaleFrom.equals("C") && scaleTo.equals("K")) {
            convertedTemperature = temperature + 273.15;
        } else if (scaleFrom.equals("F") && scaleTo.equals("C")) {
            convertedTemperature = (temperature - 32) * 5/9;
        } else if (scaleFrom.equals("F") && scaleTo.equals("K")) {
            convertedTemperature = (temperature - 32) * 5/9 + 273.15;
        } else if (scaleFrom.equals("K") && scaleTo.equals("C")) {
            convertedTemperature = temperature - 273.15;
        } else if (scaleFrom.equals("K") && scaleTo.equals("F")) {
            convertedTemperature = (temperature - 273.15) * 9/5 + 32;
        }

        return convertedTemperature;
    }
}