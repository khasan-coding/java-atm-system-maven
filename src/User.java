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

    // Returns the account connected to this user
    public Account getAccount() {
        return account;
    }
}
