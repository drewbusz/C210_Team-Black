public class Gold extends Account {
    private static final double INTEREST_RATE = 0.05;

    public Gold(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) balance -= amount;
    }

    @Override
    public void endOfMonthUpdate() {
        balance += balance * INTEREST_RATE;
    }
}