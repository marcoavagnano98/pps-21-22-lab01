import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.FeeCalculator;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {
    @BeforeEach

    protected void setAccount(){
        AccountHolder accountHolder=new AccountHolder("Mario","Rossi",0);
        BankAccount bankAccount = new SimpleBankAccount(accountHolder,0);
        super.setAccount(bankAccount,accountHolder,()->0);
    }



}
