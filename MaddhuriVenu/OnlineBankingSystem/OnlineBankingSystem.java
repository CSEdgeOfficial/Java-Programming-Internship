import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// BankAccount class to represent a bank account
class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;
    private String accountType;

    public BankAccount(int accountNumber, String accountHolderName, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

// Transaction class to represent a bank transaction
class Transaction {
    private int transactionId;
    private int accountNumber;
    private String transactionType;
    private double amount;

    public Transaction(int transactionId, int accountNumber, String transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

// OnlineBankingSystem class to manage the online banking operations
public class OnlineBankingSystem {
    private List<BankAccount> accounts;
    private Map<Integer, List<Transaction>> transactionHistory;
    private int accountNumberCounter;
    private int transactionIdCounter;

    public OnlineBankingSystem() {
        this.accounts = new ArrayList<>();
        this.transactionHistory = new HashMap<>();
        this.accountNumberCounter = 1000;
        this.transactionIdCounter = 1;
    }

    // Method to create a new bank account
    public void createAccount(String accountHolderName, String accountType) {
        BankAccount account = new BankAccount(accountNumberCounter++, accountHolderName, accountType);
        accounts.add(account);
        transactionHistory.put(account.getAccountNumber(), new ArrayList<>());
        System.out.println("Account created successfully with Account Number: " + account.getAccountNumber());
    }

    // Method to deposit funds into a bank account
    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
            Transaction transaction = new Transaction(transactionIdCounter++, accountNumber, "Deposit", amount);
            transactionHistory.get(accountNumber).add(transaction);
            System.out.println("Deposit of ₹" + amount + " successful.");
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
        }
    }

    // Method to withdraw funds from a bank account
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                Transaction transaction = new Transaction(transactionIdCounter++, accountNumber, "Withdrawal", amount);
                transactionHistory.get(accountNumber).add(transaction);
                System.out.println("Withdrawal of ₹" + amount + " successful.");
            }
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
        }
    }

    // Method to transfer funds between bank accounts
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccountByNumber(fromAccountNumber);
        BankAccount toAccount = findAccountByNumber(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                Transaction transaction1 = new Transaction(transactionIdCounter++, fromAccountNumber, "Transfer to " + toAccountNumber, amount);
                Transaction transaction2 = new Transaction(transactionIdCounter++, toAccountNumber, "Transfer from " + fromAccountNumber, amount);
                transactionHistory.get(fromAccountNumber).add(transaction1);
                transactionHistory.get(toAccountNumber).add(transaction2);
                System.out.println("Transfer of ₹" + amount + " from Account " + fromAccountNumber + " to Account " + toAccountNumber + " successful.");
            }
        } else {
            System.out.println("One or both of the accounts are not found.");
        }
    }

    // Method to display transaction history for a bank account
    public void displayTransactionHistory(int accountNumber) {
        List<Transaction> transactions = transactionHistory.get(accountNumber);
        if (transactions != null && !transactions.isEmpty()) {
            System.out.println("Transaction History for Account Number " + accountNumber + ":");
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransactionId() + ", Type: " + transaction.getTransactionType() + ", Amount: ₹" + transaction.getAmount());
            }
        } else {
            System.out.println("No transaction history found for Account Number " + accountNumber);
        }
    }

    // Utility method to find a bank account by account number
    private BankAccount findAccountByNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Method to check balance with account number
    public double checkBalance(int accountNumber) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            System.out.println("Balance for Account Number " + accountNumber + ": ₹" + account.getBalance());
            return account.getBalance();
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
            return -1;
        }
    }

    // Method to delete account with account number
    public void deleteAccount(int accountNumber) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            accounts.remove(account);
            transactionHistory.remove(accountNumber);
            System.out.println("Account with Account Number " + accountNumber + " deleted successfully.");
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("\nOnline Banking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter account type (Checking/Savings): ");
                    String accountType = scanner.nextLine();
                    bankingSystem.createAccount(accountHolderName, accountType);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankingSystem.deposit(depositAccountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankingSystem.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number to transfer from: ");
                    int fromAccountNumber = scanner.nextInt();
                    System.out.print("Enter account number to transfer to: ");
                    int toAccountNumber = scanner.nextInt();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    bankingSystem.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                    break;
                case 5:
                    System.out.print("Enter account number to check balance: ");
                    int checkBalanceAccountNumber = scanner.nextInt();
                    bankingSystem.checkBalance(checkBalanceAccountNumber);
                    break;
                case 6:
                    System.out.print("Enter account number to view transaction history: ");
                    int viewHistoryAccountNumber = scanner.nextInt();
                    bankingSystem.displayTransactionHistory(viewHistoryAccountNumber);
                    break;
                case 7:
                    System.out.print("Enter account number to delete: ");
                    int deleteAccountNumber = scanner.nextInt();
                    bankingSystem.deleteAccount(deleteAccountNumber);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close(); 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        }
    }
    
}
