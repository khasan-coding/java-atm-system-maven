public class User {

    private String name;
    private String cardNumber;
    private String pin;
    private Account checkingAccount;
    private Account savingsAccount;

    public User(String name, String cardNumber, String pin, Account checkingAccount, Account savingsAccount) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }

    // Returns the user's name
    public String getName() {
        return name;
    }

    // Returns the user's checking account
    public Account getCheckingAccount() {
        return checkingAccount;
    }

    // Returns the user's savings account
    public Account getSavingsAccount() {
        return savingsAccount;
    }

    // Checks if the user has both checking and savings accounts
    public boolean hasBothAccounts() {
        return checkingAccount != null && savingsAccount != null;
    }

    // Checks if the entered card number matches this user's card number
    public boolean isCardNumberCorrect(String enteredCardNumber) {
        return cardNumber.equals(enteredCardNumber);
    }

    // Checks if the entered PIN matches this user's PIN
    public boolean isPinCorrect(String enteredPin) {
        return pin.equals(enteredPin);
    }
}