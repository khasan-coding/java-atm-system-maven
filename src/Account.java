public class Account {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double startingBalance){
        this.accountNumber = accountNumber;
        this.balance = startingBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
