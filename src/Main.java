public class Main {

    public static void main(String[] args){
        // Create a new account object with account number 1001 and starting balance of $500
        Account myAccount = new Account("1001", 500.00);

        // Print the starting balance
        System.out.println("Starting balance: $" + myAccount.getBalance());

        // Deposit $100 into the account
        myAccount.deposit(100.00);
        // Print the balance after the valid deposit
        System.out.println("After deposit: $ " + myAccount.getBalance());

        // Try to deposit a negative amount.
        // This should NOT be allowed because deposits must be greater than 0.
        myAccount.deposit(-100.00);

        // Print the balance again to confirm the invalid deposit did not change it
        System.out.println("After invalid deposit: $" + myAccount.getBalance());

        // Withdraw $50 from the account
        myAccount.withdraw(50.00);

        // Print the balance after withdrawal
        System.out.println("After withdrawal: $" + myAccount.getBalance());
    }
}
