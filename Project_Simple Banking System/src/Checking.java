public class Checking extends Account {
    private int transactionCount = 0;
    private static final int FREE_TRANSACTIONS = 2;
    private static final double TRANSACTION_FEE = 3.0;

    public Checking(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        if (amount > balance) amount = balance;

        balance -= amount;
        transactionCount++;

        if (transactionCount > FREE_TRANSACTIONS) {
            balance -= TRANSACTION_FEE;
        }
    }

    @Override
    public void endOfMonthUpdate() {
        transactionCount = 0;
    }
}