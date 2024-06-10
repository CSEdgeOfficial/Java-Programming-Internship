import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

public class onlinebankingsystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    displayAccountDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("=======================================");
        System.out.println("|           Banking System            |");
        System.out.println("=======================================");
        System.out.println("| 1. Create Account                   |");
        System.out.println("| 2. Deposit                          |");
        System.out.println("| 3. Withdraw                         |");
        System.out.println("| 4. Display Account Details          |");
        System.out.println("| 5. Exit                             |");
        System.out.println("=======================================");
    }

    private static void createAccount() {
        System.out.println("---------- Create Account ----------");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter holder name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline character

        Account account = new Account(accountNumber, holderName, balance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
        System.out.println("-------------------------------------");
    }

    private static void deposit() {
        System.out.println("---------- Deposit ----------");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
        System.out.println("-----------------------------");
    }

    private static void withdraw() {
        System.out.println("---------- Withdraw ----------");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
        System.out.println("-------------------------------");
    }

    private static void displayAccountDetails() {
        System.out.println("---------- Display Account Details ----------");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
        System.out.println("---------------------------------------------");
    }
}
