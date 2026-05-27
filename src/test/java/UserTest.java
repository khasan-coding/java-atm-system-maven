import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void correctPinShouldReturnTrue() {
        Account account = new Account("1001", 500.00);
        User user = new User("Khasan", "123456", "1111", account);

        assertTrue(user.isPinCorrect("1111"));
    }

    @Test
    void wrongPinShouldReturnFalse() {
        Account account = new Account("1001", 500.00);
        User user = new User("Khasan", "123456", "1111", account);

        assertFalse(user.isPinCorrect("9999"));
    }

    @Test
    void correctCardNumberShouldReturnTrue() {
        Account account = new Account("1001", 500.00);
        User user = new User("Khasan", "123456", "1111", account);

        assertTrue(user.isCardNumberCorrect("123456"));
    }

    @Test
    void wrongCardNumberShouldReturnFalse() {
        Account account = new Account("1001", 500.00);
        User user = new User("Khasan", "123456", "1111", account);

        assertFalse(user.isCardNumberCorrect("000000"));
    }

    @Test
    void userShouldHaveConnectedAccount() {
        Account account = new Account("1001", 500.00);
        User user = new User("Khasan", "123456", "1111", account);

        assertTrue(user.getAccount() == account);
    }
}