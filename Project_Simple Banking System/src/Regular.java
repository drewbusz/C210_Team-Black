public class Regular extends Account {
    private static final double INTEREST_RATE = 0.06;
    private static final double MONTHLY_FEE = 10.0;

    public Regular(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        if (amount > balance) amount = balance;
        balance -= amount;
    }

    @Override
    public void endOfMonthUpdate() {
        balance += balance * INTEREST_RATE;
        balance -= MONTHLY_FEE;
    }
}