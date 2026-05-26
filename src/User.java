public class User {

    private String name;
    private String cardNumber;
    private String pin;
    private Account account;

    public User(String name, String cardNumber, String pin, Account account) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    // Returns the user's name
    public String getName() {
        return name;
    }

    // Returns the account connected to this user
    public Account getAccount() {
        return account;
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