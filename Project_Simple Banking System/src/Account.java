public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer owner;

    public Account(String accountNumber, Customer owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

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