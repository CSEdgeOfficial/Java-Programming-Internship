import java.util.Scanner;
public class Temp{
    public static void main(String[] args) {
        double temp,tc=0,tf=0,tk=0;
         System.out.println("Enter the Temperature");
     Scanner sc =new Scanner(System.in);
     temp =sc.nextDouble();
       System.out.println("Specify the mode (c(centigrade) or f(farenheit) or k(kelvin))");
      char t =sc.next().charAt(0);
      
      switch (t){
        case 'c'->{
            tc=temp;
            tf = ((9.0/5.0)*tc+32);
            tk =tc+273.15;
            }
        case 'f'->{
            tf = temp;
            tc = (tf-32)*(5.0/9.0);
            tk = tc +273.15;
            }
        case 'k'->{
            tk = temp;
            tc = tk-273.15;
            tf = ((9.0/5.0)*tc+32);
            }
        default ->System.out.println("error");
            }
            System.out.println("Temperature in centrigade="+tc);
            System.out.println("Temperature in farenhiet="+tf);
            System.out.println("Temperature in kelin="+tk);

    }
}