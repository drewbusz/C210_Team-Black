/*
 * File: Account.java
 * Purpose: Defines a generic bank account superclass with shared attributes and methods.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public abstract class Account {
    private String accountNo;
    protected double balance;
    private Customer customer;
    private Branch branch;

    public Account(String accountNo, double openingBalance, Customer customer, Branch branch) {
        this.accountNo = accountNo;
        this.balance = openingBalance;
        this.customer = customer;
        this.branch = branch;
    }

    public String getAccountNo() { return accountNo; }
    public double getBalance() { return balance; }
    public Customer getCustomer() { return customer; }
    public Branch getBranch() { return branch; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public String summaryLine() {
        return getClass().getSimpleName() + " | " + accountNo
                + " | Branch: " + branch + " | Balance: $" + String.format("%.2f", balance);
    }


    public String toString() {
        return summaryLine() + "\nOwner: " + customer.getSummary();
    }
}

