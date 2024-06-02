import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        
      
        Scanner input = new Scanner(System.in);
        
      
        System.out.print("Enter temperature value: ");
        double temp = input.nextDouble();       
      
        System.out.print("Enter temperature scale (C, F, or K): ");
        String scale = input.next();
      
        double celsius;
        switch(scale.toUpperCase()) {
            case "C":
                celsius = temp;
                break;
            case "F":
                celsius = (temp - 32) * 5 / 9;
                break;
            case "K":
                celsius = temp - 273.15;
                break;
            default:
                System.out.println("Invalid temperature scale.");
                return;
        }
      
        double fahrenheit = celsius * 9 / 5 + 32;
      
        double kelvin = celsius + 273.15;
      
        System.out.println("Celsius: " + celsius + " C");
        System.out.println("Fahrenheit: " + fahrenheit + " F");
        System.out.println("Kelvin: " + kelvin + " K");
    }

}