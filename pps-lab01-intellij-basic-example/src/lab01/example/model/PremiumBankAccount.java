package lab01.example.model;

public class PremiumBankAccount extends AbstractBankAccount{

    public PremiumBankAccount(AccountHolder holder,double balance ,final FeeCalculator feeCalculator) {
        super(balance, holder, feeCalculator);
    }
    //withdraw is always allowed
    @Override
    protected boolean isWithdrawAllowed(double amount) {
        return true;
    }
}
