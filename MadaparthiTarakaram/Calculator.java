import java.util.Scanner;
public class Calculator{
    public static void main(String[] args) {
        System.out.println("\n*****  SIMPLE CALCULATOR *****\n");
        System.out.println("Enter number 1");
        Scanner sc = new Scanner(System.in);
        double x,y,z;
        x = sc.nextDouble();
        System.out.println("Enter operation ('+','-','*','/' )");
        char ch=sc.next().charAt(0);
        System.out.println("Enter number 2");
        y =sc.nextDouble();
        switch (ch){
            case '+' -> {
                z=x+y;
                System.out.println(x +"+"+ y+"=\n"+z);
            }
            case '-' -> {
                z=x-y;
                System.out.println(x +"-"+ y+"=\n"+z);
            }
            case '*' -> {
                z=x*y;
                System.out.println(x +"*"+ y+"=\n"+z);
            }
            case '/' -> {
                z=x/y;
                System.out.println(x +"%"+ y+"=\n"+z);
            }
            default -> System.out.println("error");
            }

        }
    }