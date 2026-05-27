package com.khasan.atm;

public class BalanceResponse {

    private String accountNumber;
    private double balance;

    public BalanceResponse(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}