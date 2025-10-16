/*
 * File: CheckingAccount.java
 * Purpose: Implements a checking account with transaction limits and fees.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

public class CheckingAccount extends Account {
    private static final int FREE_TXN_PER_MONTH = 2;
    private static final double EXTRA_TXN_FEE = 3.0;
    private int monthlyTxnCount = 0;

    public CheckingAccount(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (amount > 0) monthlyTxnCount++;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        double toWithdraw = Math.min(amount, balance); // partial withdrawal allowed
        balance -= toWithdraw;
        monthlyTxnCount++;
        if (toWithdraw < amount) {
            System.out.printf("Partial withdrawal: requested $%.2f, withdrawn $%.2f.%n", amount, toWithdraw);
        } else {
            System.out.printf("Withdrawn $%.2f.%n", toWithdraw);
        }
        System.out.printf("New balance: $%.2f%n", balance);
    }

    @Override
    public void endOfMonthUpdate() {
        int extra = Math.max(0, monthlyTxnCount - FREE_TXN_PER_MONTH);
        double fees = extra * EXTRA_TXN_FEE;
        balance -= fees;                // may go negative per spec
        monthlyTxnCount = 0;            // reset
    }

    @Override
    public String toString() {
        return "Checking\n" + super.toString();
    }
}
