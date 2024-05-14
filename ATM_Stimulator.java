//Task-5 Medium Level
import java.util.*;
class Account{
     String user_Name;
     String password;
     String Accno;
     float balance=0.0f;
   public Account(String u,String p,String a){
        user_Name=u;
        password=p;
        Accno=a;
        System.out.println("Account Created Sucessfully\n");
     }
     //sign in
   public boolean Signin(){
    boolean login=false;
    Scanner cs=new Scanner(System.in);
    System.out.println("Enter user name - ");
    String Username=cs.nextLine();
    if(Username.equals(user_Name)){
        System.out.print("Enter your password - ");
        String Password=cs.nextLine();
        if(Password.equals(password)){
            System.out.println("Login Sucessfully\n");
            login=true;
        }
        else{
            System.out.println("Incorrect Password!!");
        }
    }
    else{
        System.out.println("Username not Found!!");
    }
    
    return login;
   } 
   //Deposit
  public void deposit(){
    Scanner cs=new Scanner(System.in);
    System.out.println("Enter amount to deposit:\n");
    float amount=cs.nextFloat();
    if(amount<=0.0){
        System.out.print("Enter valid amount\n");
    }
    else{
        balance=balance+amount;
        System.out.println(amount+"deposited sucessfully\n");
    }
   }
  //Balance Enquiry
  public void Check_balance(){
    System.out.println("Your Account Balance is "+balance+" rupees only.\n");
  } 
  //transfering money
  public void fund_Transfer(){
    Scanner cs=new Scanner(System.in);
    System.out.print("Enter Recepient Name :");
    String recepient_Name=cs.nextLine();
    System.out.println("Enter amount to transfer\n");
    float amt_transfer=cs.nextFloat();
    if(amt_transfer > 0.0 && balance > amt_transfer){
        System.out.println("Enter account Number of recepeint :");
        String recepient_Acno=cs.next();
        balance=balance-amt_transfer;
        System.out.println("Amount "+amt_transfer+" Transferred Sucessfully into "+recepient_Name+"[XXXXXXX"+recepient_Acno.substring(9)+"] Account.\n");
    } 
    else{
        System.out.println("Invalid Account Balance\n");
    }
    
  }
  //Withdrawl money
  public void withdrawl(){
    Scanner cs=new Scanner(System.in);
    System.out.println("Enter amount to Withdrawl\n");
    float withdrawl_amount=cs.nextFloat();
    if(withdrawl_amount >= balance){
        System.out.println("Account Balance is Low\n");
    }
    else{
        System.out.println(withdrawl_amount+" withdrawn Sucessfully\n");
        balance=balance-withdrawl_amount;
    }
    
  }
}
 
public class ATM_Stimulator {
    public static void main(String args[]){
        Scanner cs=new Scanner(System.in);
        System.out.println("Welcome to XXXX Bank\n");
        System.out.print("Enter your User name : ");
        String username=cs.next();
        System.out.print("Enter your Password : ");
        String password=cs.next();
        System.out.print("Enter your Account Number : ");
        String acno=cs.next();
        Account a=new Account(username,password,acno);
        System.out.println("Do you want to Login: yes/no \n");
        String res=cs.next();
        if(res.equalsIgnoreCase("Yes")){
            if(a.Signin()){
                boolean finish=false;
                while(!finish){
                    System.out.println("\n1.Balance Enquiry \n2.Cash Withdrawl \n3.Cash Deposit \n4.Fund Transfer\n");
                    System.out.println("Please select any banking option\n");
                    int option=cs.nextInt();
                    switch(option){
                        case 1:
                        a.Check_balance();
                        break;
                        case 2:
                        a.withdrawl();
                        break;
                        case 3:
                        a.deposit();
                        break;
                        case 4:
                        a.fund_Transfer();
                        break;
                        default:
                        finish=true;
                        break;
                    }
                }
            }
           
        }
        else{
            System.out.println("Thank you,Have a nice day\n");
        }
        
    }
}
