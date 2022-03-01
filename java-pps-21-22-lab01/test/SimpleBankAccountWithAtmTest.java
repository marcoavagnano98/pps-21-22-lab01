import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.FeeCalculator;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest{

    @BeforeEach

    protected void setAccount(){
        AccountHolder accountHolder=new AccountHolder("Mario","Rossi",0);
        FeeCalculator feeCalculator = ()->1;
        BankAccount bankAccount = new SimpleBankAccountWithAtm(accountHolder,0, feeCalculator);
        super.setAccount(bankAccount,accountHolder,feeCalculator);
    }
}
