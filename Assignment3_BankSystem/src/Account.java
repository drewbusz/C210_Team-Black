/*
 * File: Account.java
 * Purpose: Defines a generic bank account superclass with shared attributes and methods.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public abstract class Account {
    private int accountNumber;
    private double balance;
    private Branch branch;   // each account belongs to one branch

    public Account(int accountNumber, double balance, Branch branch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Branch getBranch() { return branch; }

    public void makeDeposit(double amount) {
        balance += amount;
    }

    public void makeWithdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // allow subclasses to update balance
    protected void setBalance(double newBalance) { balance = newBalance; }

    @Override
    public abstract String toString();
}
