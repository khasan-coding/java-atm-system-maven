import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Create account objects for different users
        Account khasanAccount = new Account("1001", 500.00);
        Account alexAccount = new Account("2001", 1000.00);
        Account mariaAccount = new Account("3001", 750.00);

        // Create user objects and connect each user to an account
        User khasan = new User("Khasan", "123456", "1111", khasanAccount);
        User alex = new User("Alex", "222222", "2222", alexAccount);
        User maria = new User("Maria", "333333", "3333", mariaAccount);

        // Create a list to store all users
        ArrayList<User> users = new ArrayList<>();

        // Add users to the list
        users.add(khasan);
        users.add(alex);
        users.add(maria);

        // Create an ATM object and give it the list of users
        ATM atm = new ATM(users);

        // Start the ATM menu
        atm.start();
    }
}