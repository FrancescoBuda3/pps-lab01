import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int INITIAL_BALANCE = 0;
    public static final int BASE_DEPOSIT = 100;
    public static final int TEST_WITHDRAW = 70;
    public static final int WRONG_USER_ID = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        int userId = 1;
        accountHolder = new AccountHolder("Mario", "Rossi", userId);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), BASE_DEPOSIT);
        assertEquals(BASE_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongDeposit = 50;
        bankAccount.deposit(accountHolder.getId(), BASE_DEPOSIT);
        bankAccount.deposit(WRONG_USER_ID, wrongDeposit);
        assertEquals(BASE_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int expectedWithdraw = BASE_DEPOSIT - TEST_WITHDRAW - AccountHolder.FEE;
        bankAccount.deposit(accountHolder.getId(), BASE_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), TEST_WITHDRAW);
        assertEquals(expectedWithdraw, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), BASE_DEPOSIT);
        bankAccount.withdraw(WRONG_USER_ID, TEST_WITHDRAW);
        assertEquals(BASE_DEPOSIT, bankAccount.getBalance());
    }
}
