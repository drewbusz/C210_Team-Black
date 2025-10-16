/*
 * File: BankSystemTest.java
 * Purpose: Main driver class for the Simple Banking System.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystemTest {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        System.out.println("=== Welcome Banking System ===");

        while (choice != 0) {
            System.out.println("\n1. Create Checking Account");
            System.out.println("2. Create Gold Account");
            System.out.println("3. Create Regular Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Display Account Information");
            System.out.println("7. Remove Account");
            System.out.println("8. Apply End of Month Updates");
            System.out.println("9. Display Bank Statistics");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1 -> createAccount("Checking");
                    case 2 -> createAccount("Gold");
                    case 3 -> createAccount("Regular");
                    case 4 -> deposit();
                    case 5 -> withdraw();
                    case 6 -> displayAccount();
                    case 7 -> removeAccount();
                    case 8 -> endOfMonthUpdates();
                    case 9 -> displayBankStats();
                    case 0 -> System.out.println("Exiting system...");
                    default -> System.out.println("Invalid option. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear bad input
            }
        }
    }

    private static void createAccount(String type) {
        System.out.println("\nCreating a " + type + " Account");
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();

        // check for duplicates
        if (findAccount(number) != null) {
            System.out.println("An account with that number already exists.");
            return;
        }

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        Customer c = new Customer(id, name, phone);
        Account a = null;

        if (type.equals("Checking")) a = new CheckingAccount(number, c, balance);
        else if (type.equals("Gold")) a = new GoldAccount(number, c, balance);
        else if (type.equals("Regular")) a = new RegularAccount(number, c, balance);

        accounts.add(a);
        System.out.println(type + " account created successfully!");
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        String num = sc.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            a.deposit(amount);
            System.out.println("Deposit successful! New Balance: $" + a.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        String num = sc.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            a.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccount() {
        System.out.print("Enter Account Number: ");
        String num = sc.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            System.out.println(a);
            if (a instanceof CheckingAccount)
                System.out.println("(Checking: 2 free transactions/month, $3 fee after.)");
            else if (a instanceof GoldAccount)
                System.out.println("(Gold: 5% monthly interest, unlimited overdraft.)");
            else if (a instanceof RegularAccount)
                System.out.println("(Regular: 6% interest, $10 monthly fee.)");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void removeAccount() {
        System.out.print("Enter Account Number: ");
        String num = sc.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            accounts.remove(a);
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void endOfMonthUpdates() {
        for (Account a : accounts) a.endOfMonthUpdate();
        System.out.println("End-of-month updates applied to all accounts.");
    }

    private static void displayBankStats() {
        double total = 0;
        int zeroBalanceCount = 0;
        Account highest = null;

        for (Account a : accounts) {
            double bal = a.getBalance();
            total += bal;
            if (bal == 0) zeroBalanceCount++;
            if (highest == null || bal > highest.getBalance()) highest = a;
        }

        double avg = accounts.isEmpty() ? 0 : total / accounts.size();

        System.out.println("\n=== Bank Statistics ===");
        System.out.println("Total Accounts: " + accounts.size());
        System.out.printf("Total Balance: $%.2f%n", total);
        System.out.println("Zero-Balance Accounts: " + zeroBalanceCount);
        System.out.printf("Average Balance: $%.2f%n", avg);

        if (highest != null) {
            System.out.printf("Highest Balance: %s ($%.2f)%n",
                    highest.getAccountNumber(), highest.getBalance());
        } else {
            System.out.println("Highest Balance: N/A");
        }
    }

    private static Account findAccount(String accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                return a;
            }
        }
        return null;
    }
}

