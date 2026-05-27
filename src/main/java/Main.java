import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Create checking and savings accounts for Khasan
        Account khasanChecking = new Account("1001", 500.00);
        Account khasanSavings = new Account("1002", 1000.00);

        // Create only a checking account for Alex
        Account alexChecking = new Account("2001", 1000.00);

        // Create only a savings account for Maria
        Account mariaSavings = new Account("3001", 750.00);

        // Create user objects and connect each user to their accounts
        User khasan = new User("Khasan", "123456", "1111", khasanChecking, khasanSavings);
        User alex = new User("Alex", "222222", "2222", alexChecking, null);
        User maria = new User("Maria", "333333", "3333", null, mariaSavings);

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