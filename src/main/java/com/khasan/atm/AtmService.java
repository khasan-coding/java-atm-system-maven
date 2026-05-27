package com.khasan.atm;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AtmService {

    private ArrayList<User> users;

    public AtmService() {
        users = new ArrayList<>();

        Account khasanChecking = new Account("1001", 500.00);
        Account khasanSavings = new Account("1002", 1000.00);

        Account alexChecking = new Account("2001", 1000.00);

        Account mariaSavings = new Account("3001", 750.00);

        User khasan = new User("Khasan", "123456", "1111", khasanChecking, khasanSavings);
        User alex = new User("Alex", "222222", "2222", alexChecking, null);
        User maria = new User("Maria", "333333", "3333", null, mariaSavings);

        users.add(khasan);
        users.add(alex);
        users.add(maria);
    }

    public User login(String cardNumber, String pin) {
        for (User user : users) {
            if (user.isCardNumberCorrect(cardNumber) && user.isPinCorrect(pin)) {
                return user;
            }
        }

        return null;
    }

    public User findUserByCardNumber(String cardNumber) {
        for (User user : users) {
            if (user.isCardNumberCorrect(cardNumber)) {
                return user;
            }
        }

        return null;
    }

    public Account findAccountByAccountNumber(String accountNumber) {
        for (User user : users) {
            if (user.getCheckingAccount() != null &&
                    user.getCheckingAccount().getAccountNumber().equals(accountNumber)) {
                return user.getCheckingAccount();
            }

            if (user.getSavingsAccount() != null &&
                    user.getSavingsAccount().getAccountNumber().equals(accountNumber)) {
                return user.getSavingsAccount();
            }
        }

        return null;
    }
}