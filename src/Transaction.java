public class Transaction {

    private String type;
    private double amount;
    private double balanceAfterTransaction;

    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    // Displays the transaction details in a readable format
    public void displayTransaction() {
        System.out.println(type + ": $" + amount + " | Balance after: $" + balanceAfterTransaction);
    }
}