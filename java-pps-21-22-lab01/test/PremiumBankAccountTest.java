import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.FeeCalculator;
import lab01.example.model.PremiumBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class PremiumBankAccountTest extends AbstractBankAccountTest {

    @BeforeEach
    protected void setAccount(){
        AccountHolder accountHolder=new AccountHolder("Mario","Rossi",0);
        FeeCalculator feeCalculator = ()->1;
        BankAccount bankAccount = new PremiumBankAccount(accountHolder,0, feeCalculator);
        super.setAccount(bankAccount,accountHolder,feeCalculator);
    }
    @Test
    void testPremiumAccount(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 200);
        assertEquals(-100 - (2 * feeCalculator.getFee()), bankAccount.getBalance());
    }
}

