import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
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
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n=== Simple Banking System ===");
        System.out.println("1. Create Checking Account");
        System.out.println("2. Create Gold Account");
        System.out.println("3. Create Regular Account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Display Account Information");
        System.out.println("7. Remove Account");
        System.out.println("8. Apply End-of-Month Updates");
        System.out.println("9. Display Bank Statistics");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void createAccount(String type) {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Customer c = new Customer(id, name);
        Account a = switch (type) {
            case "Checking" -> new Checking(number, c, balance);
            case "Gold" -> new Gold(number, c, balance);
            case "Regular" -> new Regular(number, c, balance);
            default -> null;
        };

        accounts.add(a);
        System.out.println(type + " account created successfully!");
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String num = scanner.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            a.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String num = scanner.nextLine();
        Account a = findAccount(num);
        if (a != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            a.withdraw(amount);
            System.out.println("Withdrawal complete.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccount() {
        System.out.print("Enter account number: ");
        String num = scanner.nextLine();
        Account a = findAccount(num);
        if (a != null) System.out.println(a);
        else System.out.println("Account not found.");
    }

    private static void removeAccount() {
        System.out.print("Enter account number: ");
        String num = scanner.nextLine();
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
        System.out.println("End-of-month updates applied.");
    }

    private static void displayBankStats() {
        double total = 0, largest = 0;
        int zeroCount = 0;
        for (Account a : accounts) {
            total += a.getBalance();
            if (a.getBalance() == 0) zeroCount++;
            if (a.getBalance() > largest) largest = a.getBalance();
        }
        double avg = accounts.isEmpty() ? 0 : total / accounts.size();
        System.out.println("=== Bank Statistics ===");
        System.out.println("Total accounts: " + accounts.size());
        System.out.println("Total balance: $" + String.format("%.2f", total));
        System.out.println("Zero-balance accounts: " + zeroCount);
        System.out.println("Average balance: $" + String.format("%.2f", avg));
        System.out.println("Largest balance: $" + String.format("%.2f", largest));
    }

    private static Account findAccount(String accountNumber) {
        for (Account a : accounts)
            if (a.getAccountNumber().equals(accountNumber))
                return a;
        return null;
    }
}