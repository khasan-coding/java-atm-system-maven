import com.khasan.atm.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        Account account = new Account("1001", 500.00);

        account.deposit(100.00);

        assertEquals(600.00, account.getBalance());
    }

    @Test
    void negativeDepositShouldNotChangeBalance() {
        Account account = new Account("1001", 500.00);

        account.deposit(-100.00);

        assertEquals(500.00, account.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        Account account = new Account("1001", 500.00);

        account.withdraw(100.00);

        assertEquals(400.00, account.getBalance());
    }

    @Test
    void overdraftWithdrawalShouldNotChangeBalance() {
        Account account = new Account("1001", 500.00);

        account.withdraw(1000.00);

        assertEquals(500.00, account.getBalance());
    }

    @Test
    void negativeWithdrawalShouldNotChangeBalance() {
        Account account = new Account("1001", 500.00);

        account.withdraw(-50.00);

        assertEquals(500.00, account.getBalance());
    }
}