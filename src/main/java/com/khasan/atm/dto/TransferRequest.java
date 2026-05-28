package com.khasan.atm.dto;

public class TransferRequest {

    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }
}