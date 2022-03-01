package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;
    private final FeeCalculator feeCalculator;

    public AbstractBankAccount(final double balance, final AccountHolder holder, final FeeCalculator feeCalculator) {
        this.balance = balance;
        this.holder = holder;
        this.feeCalculator = feeCalculator;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount - this.getFEE();
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + this.getFEE();
        }
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
    protected int getFEE(){
        return feeCalculator.getFee();
    }

}
