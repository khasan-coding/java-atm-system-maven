public class Main {

    public static void main(String[] args){

        Account myAccount = new Account("12345", 500.00);

        myAccount.deposit(100.00);
        System.out.println("After deposit: $ " + myAccount.getBalance());

        myAccount.withdraw(50.00);
        System.out.println("After withdrawal: $" + myAccount.getBalance());
    }
}
