package com.khasan.atm.dto;

public class LoginRequest {

    private String cardNumber;
    private String pin;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }
}