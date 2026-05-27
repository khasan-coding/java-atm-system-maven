package com.khasan.atm;

public class Transaction {

    // Stores the type of transaction, such as Deposit, Withdrawal, Transfer In, or Transfer Out
    private String type;

    // Stores the amount involved in the transaction
    private double amount;

    // Stores the account balance after the transaction is completed
    private double balanceAfterTransaction;

    // Constructor used to create a new transaction record
    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    // Returns the transaction type
    public String getType() {
        return type;
    }

    // Returns the transaction amount
    public double getAmount() {
        return amount;
    }

    // Returns the balance after the transaction was completed
    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    // Displays the transaction details in a readable format
    public void displayTransaction() {
        System.out.println(type + ": $" + amount + " | Balance after: $" + balanceAfterTransaction);
    }
}