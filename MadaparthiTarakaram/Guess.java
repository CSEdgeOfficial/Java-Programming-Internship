import java.util.Random;
import java.util.Scanner;
public class Guess{
    public static void main(String[] args) {
        int random,count=0,guess;
        Random rand =new Random();
           random =rand.nextInt(10);
          int max=5;
      System.out.println("no of chances="+max);
      System.out.println("Enter the guessed number");
      Scanner sc =new Scanner(System.in);
      for(max=5;count<max;max--){
            guess=sc.nextInt();
                  if(guess==random){
            System.out.println("You Won The Game");
            break;
        }
        else{
         System.out.println("Try Again\n");
         System.out.println(max-1+" chances remaining\n");
      }

      }
          System.out.println("GAME OVER");
        
    }
}