/*
 * File: CheckingAccount.java
 * Purpose: Represents a checking account with check style and minimum balance requirements.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */

public class CheckingAccount extends Account {
    private String checkStyle;
    private double minimumBalance;

    public CheckingAccount(String accountNo, double openingBalance,
                           Customer customer, Branch branch,
                           String checkStyle, double minimumBalance) {
        super(accountNo, openingBalance, customer, branch);
        this.checkStyle = checkStyle;
        this.minimumBalance = minimumBalance;
    }

    public String getCheckStyle() { return checkStyle; }
    public double getMinimumBalance() { return minimumBalance; }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && (balance - amount) >= minimumBalance) {
            balance -= amount;
        }
    }

    public String summaryLine() {
        return super.summaryLine()
                + " | CheckStyle: " + checkStyle
                + " | Min: $" + String.format("%.2f", minimumBalance);
    }
}
