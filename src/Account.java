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
        if(amount > 0) {
            balance += amount;
        } else {
            System.out.println("Error: Deposit amount must be greater than 0.");
        }

    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Error: Withdrawal amount must be greater than 0.");
        }else if(amount > balance){
            System.out.println("Error: Insufficient funds.");
        } else{
            balance -= amount;
        }
    }
}
