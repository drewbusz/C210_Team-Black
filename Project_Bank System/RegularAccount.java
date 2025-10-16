/*
 * File: RegularAccount.java
 * Purpose: Defines a regular account with monthly interest and maintenance fees.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

public class RegularAccount extends Account {
    private static final double INTEREST = 0.06;  // 6%
    private static final double MAINT_FEE = 10.0; // monthly maintenance fee

    public RegularAccount(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        double toWithdraw = Math.min(amount, balance); // no overdraft; partial allowed
        balance -= toWithdraw;
        if (toWithdraw < amount) {
            System.out.printf("Partial withdrawal: requested $%.2f, withdrawn $%.2f.%n", amount, toWithdraw);
        } else {
            System.out.printf("Withdrawn $%.2f.%n", toWithdraw);
        }
        System.out.printf("New balance: $%.2f%n", balance);
    }

    @Override
    public void endOfMonthUpdate() {
        balance += balance * INTEREST;
        balance -= MAINT_FEE;
    }

    @Override
    public String toString() {
        return "Regular\n" + super.toString();
    }
}

