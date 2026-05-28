package com.khasan.atm.model;

import java.util.Scanner;
import java.util.ArrayList;

public class ATM {

    private ArrayList<User> users;
    private User currentUser;
    private Scanner scanner;

    public ATM(ArrayList<User> users) {
        this.users = users;
        this.scanner = new Scanner(System.in);
    }

    // Handles user login by searching for a matching card number and checking the PIN
    private boolean login() {
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            System.out.print("Enter card number: ");
            String enteredCardNumber = scanner.next();

            User foundUser = null;

            // Search through all users to find a matching card number
            for (User user : users) {
                if (user.isCardNumberCorrect(enteredCardNumber)) {
                    foundUser = user;
                    break;
                }
            }

            System.out.print("Enter PIN: ");
            String enteredPin = scanner.next();

            if (foundUser != null && foundUser.isPinCorrect(enteredPin)) {
                currentUser = foundUser;
                System.out.println("Login successful.");
                return true;
            } else {
                attempts++;
                System.out.println("Error: Invalid card number or PIN.");
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
        }

        System.out.println("Too many failed attempts. Access denied.");
        return false;
    }

    // Allows the user to select which account to use
    private Account selectAccount() {
        Account checking = currentUser.getCheckingAccount();
        Account savings = currentUser.getSavingsAccount();

        if (checking != null && savings != null) {
            System.out.println("Select account:");
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.print("Choose an option: ");

            int accountChoice = scanner.nextInt();

            if (accountChoice == 1) {
                return checking;
            } else if (accountChoice == 2) {
                return savings;
            } else {
                System.out.println("Error: Invalid account option.");
                return null;
            }
        } else if (checking != null) {
            System.out.println("Checking account selected.");
            return checking;
        } else if (savings != null) {
            System.out.println("Savings account selected.");
            return savings;
        } else {
            System.out.println("No accounts found for this user.");
            return null;
        }
    }

    // Transfers money between the current user's checking and savings accounts
    private void transferBetweenAccounts() {
        if (!currentUser.hasBothAccounts()) {
            System.out.println("Transfer is only available when you have both checking and savings accounts.");
            return;
        }

        Account checking = currentUser.getCheckingAccount();
        Account savings = currentUser.getSavingsAccount();

        System.out.println("Transfer options:");
        System.out.println("1. Checking to Savings");
        System.out.println("2. Savings to Checking");
        System.out.print("Choose transfer option: ");

        int transferChoice = scanner.nextInt();

        System.out.print("Enter transfer amount: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be greater than 0.");
            return;
        }

        if (transferChoice == 1) {
            if (amount > checking.getBalance()) {
                System.out.println("Error: Insufficient funds in checking account.");
            } else {
                checking.decreaseBalance(amount);
                checking.addTransaction("Transfer Out", amount);

                savings.increaseBalance(amount);
                savings.addTransaction("Transfer In", amount);

                System.out.println("Transfer successful.");
                System.out.println("Checking balance: $" + checking.getBalance());
                System.out.println("Savings balance: $" + savings.getBalance());
            }
        } else if (transferChoice == 2) {
            if (amount > savings.getBalance()) {
                System.out.println("Error: Insufficient funds in savings account.");
            } else {
                savings.decreaseBalance(amount);
                savings.addTransaction("Transfer Out", amount);

                checking.increaseBalance(amount);
                checking.addTransaction("Transfer In", amount);

                System.out.println("Transfer successful.");
                System.out.println("Checking balance: $" + checking.getBalance());
                System.out.println("Savings balance: $" + savings.getBalance());
            }
        } else {
            System.out.println("Error: Invalid transfer option.");
        }
    }

    public void start() {

        if (!login()) {
            return;
        }

        System.out.println("Welcome, " + currentUser.getName() + "!");

        Account account = selectAccount();

        if (account == null) {
            return;
        }

        boolean isRunning = true;

        while (isRunning) {

            // Display the com.khasan.atm.model.ATM menu
            System.out.println("===== com.khasan.atm.model.ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View com.khasan.atm.model.Transaction History");
            System.out.println("5. Transfer Between Accounts");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");

            // Read the user's menu choice from the console
            int choice = scanner.nextInt();

            // If the user chooses option 1, display the current account balance
            if (choice == 1) {
                System.out.println("Your balance is: $" + account.getBalance());
            }

            // If the user chooses option 2, ask for a deposit amount and add it to the balance
            else if (choice == 2) {
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();

                account.deposit(depositAmount);

                System.out.println("New balance: $" + account.getBalance());
            }

            // If the user chooses option 3, ask for a withdrawal amount and subtract it from the balance if valid
            else if (choice == 3) {
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();

                account.withdraw(withdrawalAmount);

                System.out.println("New balance: $" + account.getBalance());
            }

            // If the user chooses option 4, display the transaction history
            else if (choice == 4) {
                account.displayTransactionHistory();
            }

            // If the user chooses option 5, transfer money between checking and savings
            else if (choice == 5) {
                transferBetweenAccounts();
            }

            // If the user chooses option 6, exit the com.khasan.atm.model.ATM
            else if (choice == 6) {
                System.out.println("Thank you for using the com.khasan.atm.model.ATM. Goodbye!");
                isRunning = false;
            }

            // If the user enters a number that is not on the menu, show an error message
            else {
                System.out.println("Error: Invalid option. Please choose 1, 2, 3, 4, 5, or 6.");
            }
        }
    }
}