import com.khasan.atm.Account;
import com.khasan.atm.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void correctPinShouldReturnTrue() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertTrue(user.isPinCorrect("1111"));
    }

    @Test
    void wrongPinShouldReturnFalse() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertFalse(user.isPinCorrect("9999"));
    }

    @Test
    void correctCardNumberShouldReturnTrue() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertTrue(user.isCardNumberCorrect("123456"));
    }

    @Test
    void wrongCardNumberShouldReturnFalse() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertFalse(user.isCardNumberCorrect("000000"));
    }

    @Test
    void userShouldHaveConnectedCheckingAccount() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertTrue(user.getCheckingAccount() == checkingAccount);
    }

    @Test
    void userShouldHaveConnectedSavingsAccount() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertTrue(user.getSavingsAccount() == savingsAccount);
    }

    @Test
    void userWithCheckingAndSavingsShouldHaveBothAccounts() {
        Account checkingAccount = new Account("1001", 500.00);
        Account savingsAccount = new Account("1002", 1000.00);
        User user = new User("Khasan", "123456", "1111", checkingAccount, savingsAccount);

        assertTrue(user.hasBothAccounts());
    }

    @Test
    void userWithOnlyCheckingShouldNotHaveBothAccounts() {
        Account checkingAccount = new Account("2001", 1000.00);
        User user = new User("Alex", "222222", "2222", checkingAccount, null);

        assertFalse(user.hasBothAccounts());
    }

    @Test
    void userWithOnlySavingsShouldNotHaveBothAccounts() {
        Account savingsAccount = new Account("3001", 750.00);
        User user = new User("Maria", "333333", "3333", null, savingsAccount);

        assertFalse(user.hasBothAccounts());
    }
}