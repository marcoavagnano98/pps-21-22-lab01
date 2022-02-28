import lab01.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected  AccountHolder accountHolder;
    protected  BankAccount bankAccount;
    protected  FeeCalculator feeCalculator;

  /*  public AbstractBankAccountTest(final BankAccount bankAccount, final AccountHolder accountHolder, final FeeCalculator feeCalculator){
        this.bankAccount = bankAccount;
        this.accountHolder = accountHolder;
        this.feeCalculator = feeCalculator;
    }*/
    protected void setAccount(final BankAccount bankAccount, final AccountHolder accountHolder, final FeeCalculator feeCalculator){
        this.bankAccount=bankAccount;
        this.accountHolder = accountHolder;
        this.feeCalculator=feeCalculator;
    }

   /* @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }*/

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - feeCalculator.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - feeCalculator.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - (2 * feeCalculator.getFee()), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - feeCalculator.getFee(), bankAccount.getBalance());
    }

}
