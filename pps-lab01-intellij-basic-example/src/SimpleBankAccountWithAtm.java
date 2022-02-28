import lab01.example.model.*;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder, double balance, final FeeCalculator feeCalculator) {
        //tax may be not 0
        super(balance,accountHolder, feeCalculator);
    }
}
