/*
 * File: Account.java
 * Purpose: Base class for all types of bank accounts.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer owner;

    public Account(String accountNumber, Customer owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Customer getOwner() { return owner; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount.");
    }

    public abstract void withdraw(double amount);
    public abstract void endOfMonthUpdate();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                "\nOwner: " + owner.getName() +
                "\nBalance: $" + String.format("%.2f", balance);
    }
}

