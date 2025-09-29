/*
 * File: BankTest.java
 * Purpose: Driver program to create customers, manage accounts, and show account operations.
 *
 * (a) create Checking for commercial customer in Chicago branch
 * (b) display info via a method
 * (c) deposit $100 and display
 * (d) create Savings for personal customer with $100 and 10%
 * (e) display savings info
 * (f) deposit $100, calculate interest, display
 * (g) other small operations
 *
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */

import java.util.ArrayList;

public class BankTest {

    public static void displayAccountInfo(Account acc) {
        System.out.println(" Account Info ");
        System.out.println(acc.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();

// Branches
        Branch chicago = new Branch("CHI-001", "Chicago");
        Branch indy = new Branch("IND-010", "Indianapolis");


        CommercialCustomer teamblack = new CommercialCustomer(
                "Team Black LLC",
                "123 Wacker Dr, Chicago, IL",
                "312-555-0100",
                "A-",
                "Dana Fields",
                "312-555-0199"
        );
        CheckingAccount teamblackChecking = new CheckingAccount(
                "CHK-10001",
                5000.0,
                teamblack,
                chicago,
                "Modern",
                1000.0
        );
        accounts.add(teamblackChecking);

// (b) Display the customer information and account balance
        displayAccountInfo(teamblackChecking);

// (c) Deposit $100 and display
        teamblackChecking.deposit(100.0);
        System.out.println("Deposited $100 to Team Black checking.");
        displayAccountInfo(teamblackChecking);

// (d) Create savings account for a personal customer
        PersonalCustomer john = new PersonalCustomer(
                "John Smith",
                "101 Main St, Indianapolis, IN",
                "317-555-0200",
                "317-555-0201",
                "317-555-0202"
        );
        SavingsAccount johnSavings = new SavingsAccount(
                "SAV-20001",
                100.0,
                john,
                indy,
                10.0
        );
        accounts.add(johnSavings);

// (e) Display savings account info
        displayAccountInfo(johnSavings);

// (f) Deposit $100, calculate interest, then display
        johnSavings.deposit(100.0);
        System.out.println("Deposited $100 to John's savings.");
        johnSavings.calculateInterest();
        System.out.println("Applied interest at " + johnSavings.getInterestRatePercent() + "%.");
        displayAccountInfo(johnSavings);


        System.out.println(" Checking withdrawal with minimum balance...");
        teamblackChecking.withdraw(3800.0);
        displayAccountInfo(teamblackChecking);


        System.out.println("All Accounts in Bank ");
        for (Account a : accounts) {
            System.out.println(a.summaryLine());
        }
    }
}