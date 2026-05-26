import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create a new account object with account number 1001 and starting balance of $500
        Account myAccount = new Account("1001", 500.00);

        boolean isRunning = true;

        while (isRunning) {

            // Display the ATM menu
            System.out.println("===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            // Read the user's menu choice from the console
            int choice = scanner.nextInt();

            // If the user chooses option 1, display the current account balance
            if (choice == 1) {
                System.out.println("Your balance is: $" + myAccount.getBalance());
            }

            // If the user chooses option 2, ask for a deposit amount and add it to the balance
            else if (choice == 2) {
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();

                myAccount.deposit(depositAmount);

                System.out.println("New balance: $" + myAccount.getBalance());
            }

            // If the user chooses option 3, ask for a withdrawal amount and subtract it from the balance if valid
            else if (choice == 3) {
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();

                myAccount.withdraw(withdrawalAmount);

                System.out.println("New balance: $" + myAccount.getBalance());
            }

            // If the user chooses option 4, exit the ATM
            else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                isRunning = false;
            }

            // If the user enters a number that is not on the menu, show an error message
            else {
                System.out.println("Error: Invalid option. Please choose 1, 2, 3, or 4.");
            }

        }
    }
}