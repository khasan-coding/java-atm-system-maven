import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private double balance;

    // Stores the account's transaction history
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, double startingBalance) {
        this.accountNumber = accountNumber;
        this.balance = startingBalance;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    // Returns the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Adds money to the account only if the amount is greater than 0
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            transactions.add(new Transaction("Deposit", amount, balance));
        } else {
            System.out.println("Error: Deposit amount must be greater than 0.");
        }
    }

    // Removes money from the account only if the amount is valid and enough balance exists
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount, balance));
        }
    }

    // Displays all successful transactions for this account
    public void displayTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("===== Transaction History =====");

            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }
}