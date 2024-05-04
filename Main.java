import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;
    private Map<String, Double> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new HashMap<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.put("Deposit", amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.put("Withdrawal", -amount);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Double> getTransactionHistory() {
        return transactionHistory;
    }
}

class OnlineBankingSystem {
    private Map<String, BankAccount> accounts;
    private Scanner scanner;

    public OnlineBankingSystem() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
    }

    public void deposit() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Enter deposit amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Enter withdrawal amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayBalance() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Transaction History:");
            Map<String, Double> history = account.getTransactionHistory();
            for (Map.Entry<String, Double> entry : history.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display Balance\n5. Display Transaction History\n6. Exit\n");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    bankingSystem.createAccount();
                    break;
                case 2:
                    bankingSystem.deposit();
                    break;
                case 3:
                    bankingSystem.withdraw();
                    break;
                case 4:
                    bankingSystem.displayBalance();
                    break;
                case 5:
                    bankingSystem.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }
}
