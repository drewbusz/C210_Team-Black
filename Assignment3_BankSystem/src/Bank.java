/*
 * File: Bank.java
 * Purpose: Driver program to create customers, manage accounts, and show account operations.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
import java.util.ArrayList;

public class Bank {

    // Separate method to display customer info and account balance
    private static void displayCustomerAndAccount(Customer customer, Account account) {
        System.out.println(customer);
        System.out.println(account);
    }

    public static void main(String[] args) {
        // Each account is serviced by one branch
        Branch chicago = new Branch("Chicago", "6110 Money St");

        // Declare an ArrayList to hold all kinds of accounts
        ArrayList<Account> accounts = new ArrayList<>();

        // Create a Checking account for a commercial customer in Chicago’s branch and add it to the list
        CommercialCustomer cc = new CommercialCustomer(
                "Paper Time", "123 Business Ave", "555-1234",
                "A+", "Michael Scott", "555-5678"
        );
        CheckingAccount chk = new CheckingAccount(1001, 500.00, chicago, "Standard", 100.00);
        accounts.add(chk);

        // Display the customer information and account balance
        System.out.println("=== Commercial Customer / Checking ===");
        displayCustomerAndAccount(cc, chk);

        // Deposit $100 into the checking account and display the new info
        chk.makeDeposit(100.00);
        System.out.println("After $100 deposit:");
        System.out.println(chk);

        // Create a Savings account for a personal customer with initial balance $100 and interest 10%
        PersonalCustomer pc = new PersonalCustomer(
                "Jerry Smith", "612 Wharf Ave", "555-2222",
                "555-3333", "555-4444"
        );
        SavingsAccount sav = new SavingsAccount(2001, 100.00, chicago, 0.10);
        accounts.add(sav);

        // Display the savings account information
        System.out.println("\n=== Personal Customer / Savings ===");
        displayCustomerAndAccount(pc, sav);

        // $100 deposit to the savings account, calculate interest, then display the information
        sav.makeDeposit(100.00);
        double interest = sav.calculateInterest();
        System.out.println("After $100 deposit & interest (" + String.format("%.2f", interest) + "):");
        System.out.println(sav);

    }
}
