/*
 * File: GoldAccount.java
 * Purpose: Represents a gold account that earns 5 percent interest and allows unlimited overdrafts with no transaction fees.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

public class GoldAccount extends Account {
    private static final double INTEREST = 0.05; // 5%

    public GoldAccount(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        // overdraft allowed
        balance -= amount;
        System.out.printf("Withdrawn $%.2f. New balance: $%.2f%n", amount, balance);
    }

    @Override
    public void endOfMonthUpdate() {
        balance += balance * INTEREST;
    }

    @Override
    public String toString() {
        return "Gold\n" + super.toString();
    }
}
