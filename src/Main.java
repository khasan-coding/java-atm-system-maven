import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create a new account object with account number 1001 and starting balance of $500
        Account myAccount = new Account("1001", 500.00);

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
    }
}