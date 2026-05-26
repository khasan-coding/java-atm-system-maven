import java.util.Scanner;

public class ATM {

    private User user;
    private Scanner scanner;

    public ATM(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    // Handles user login by allowing up to 3 attempts to enter the correct card number and PIN
    private boolean login() {
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            System.out.print("Enter card number: ");
            String enteredCardNumber = scanner.next();

            System.out.print("Enter PIN: ");
            String enteredPin = scanner.next();

            if (user.isCardNumberCorrect(enteredCardNumber) && user.isPinCorrect(enteredPin)) {
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

    public void start() {

        if (!login()) {
            return;
        }

        System.out.println("Welcome, " + user.getName() + "!");

        Account account = user.getAccount();

        boolean isRunning = true;

        while (isRunning) {

            // Display the ATM menu
            System.out.println("===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");

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

            // If the user chooses option 5, exit the ATM
            else if (choice == 5) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                isRunning = false;
            }

            // If the user enters a number that is not on the menu, show an error message
            else {
                System.out.println("Error: Invalid option. Please choose 1, 2, 3, 4, or 5.");
            }
        }
    }
}