/*
 * File: CheckingAccount.java
 * Purpose: Represents a checking account with check style and minimum balance requirements.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class CheckingAccount extends Account {
    private String checkStyle;
    private double minBalance;

    public CheckingAccount(int accountNumber, double balance, Branch branch,
                           String checkStyle, double minBalance) {
        super(accountNumber, balance, branch);
        this.checkStyle = checkStyle;
        this.minBalance = minBalance;
    }

    public String getCheckStyle() { return checkStyle; }
    public double getMinBalance() { return minBalance; }

    @Override
    public String toString() {
        return "Checking Account #" + getAccountNumber()
                + " | Balance: $" + String.format("%.2f", getBalance())
                + " | Branch: " + getBranch()
                + " | Check Style: " + checkStyle
                + " | Min Balance: $" + String.format("%.2f", minBalance);
    }
}
