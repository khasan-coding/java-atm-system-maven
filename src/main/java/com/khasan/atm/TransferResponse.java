package com.khasan.atm;

public class TransferResponse {

    private String message;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double fromAccountBalance;
    private double toAccountBalance;

    public TransferResponse(String message, String fromAccountNumber, String toAccountNumber,
                            double fromAccountBalance, double toAccountBalance) {
        this.message = message;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.fromAccountBalance = fromAccountBalance;
        this.toAccountBalance = toAccountBalance;
    }

    public String getMessage() {
        return message;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getFromAccountBalance() {
        return fromAccountBalance;
    }

    public double getToAccountBalance() {
        return toAccountBalance;
    }
}