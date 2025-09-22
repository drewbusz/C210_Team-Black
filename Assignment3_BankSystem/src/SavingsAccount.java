/*
 * File: SavingsAccount.java
 * Purpose: Represents a savings account with an interest rate and interest calculation method.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class SavingsAccount extends Account {
    private double interestRate; // e.g., 0.10 for 10%

    public SavingsAccount(int accountNumber, double balance, Branch branch, double interestRate) {
        super(accountNumber, balance, branch);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    // Calculates interest, adds it to balance, and returns the interest amount
    public double calculateInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        return interest;
    }

    @Override
    public String toString() {
        return "Savings Account #" + getAccountNumber()
                + " | Balance: $" + String.format("%.2f", getBalance())
                + " | Branch: " + getBranch()
                + " | Interest Rate: " + String.format("%.0f", interestRate * 100) + "%";
    }
}
