package com.khasan.atm.dto;

public class TransactionResponse {

    private String message;
    private String accountNumber;
    private double newBalance;

    public TransactionResponse(String message, String accountNumber, double newBalance) {
        this.message = message;
        this.accountNumber = accountNumber;
        this.newBalance = newBalance;
    }

    public String getMessage() {
        return message;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getNewBalance() {
        return newBalance;
    }
}