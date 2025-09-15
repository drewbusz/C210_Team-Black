/*
 * File: UserAccounts.java
 * Purpose: Handles a group of accounts and gives users a menu to check balances,
 * deposit, or withdraw money.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/14/2025
 * @version: 1.0
 */
import java.util.Scanner;

public class UserAccounts {
    private Account[] accounts = new Account[8];

    // Default constructor
    public UserAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 50);
        }
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an id: ");
            int id = input.nextInt();

            if (id < 0 || id >= accounts.length) {
                System.out.println("Invalid ID. Try again.");
                continue;
            }

            while (true) {
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("The balance is " + accounts[id].getBalance());
                }
                else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    double amt = input.nextDouble();
                    accounts[id].withdraw(amt);
                }
                else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    double amt = input.nextDouble();
                    accounts[id].deposit(amt);
                }
                else if (choice == 4) {
                    break; // go back to ask for new ID
                }
                else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}