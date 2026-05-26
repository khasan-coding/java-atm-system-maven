public class Main {
    public static void main(String[] args) {

        // Create a new account object with account number 1001 and starting balance of $500
        Account myAccount = new Account("1001", 500.00);

        // Create a user and connect the account to that user
        User user = new User("Khasan", "123456", "1111", myAccount);

        // Create an ATM object and give it the user to work with
        ATM atm = new ATM(user);

        // Start the ATM menu
        atm.start();
    }
}