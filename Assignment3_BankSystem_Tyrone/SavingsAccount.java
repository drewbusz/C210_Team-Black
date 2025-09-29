/*
 * File: SavingsAccount.java
 * Purpose: Represents a savings account with an interest rate and interest calculation method.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class SavingsAccount extends Account {
    private double interestRatePercent; // e.g., 10.0 means 10%

    public SavingsAccount(String accountNo, double openingBalance,
                          Customer customer, Branch branch,
                          double interestRatePercent) {
        super(accountNo, openingBalance, customer, branch);
        this.interestRatePercent = interestRatePercent;
    }

    public double getInterestRatePercent() { return interestRatePercent; }
    public void setInterestRatePercent(double p) { if (p >= 0) interestRatePercent = p; }

    public void calculateInterest() {
        balance += balance * (interestRatePercent / 100.0);
    }

    public String summaryLine() {
        return super.summaryLine() + " | APR: " + String.format("%.2f", interestRatePercent) + "%";
    }
}
