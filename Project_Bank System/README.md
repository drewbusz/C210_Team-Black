README – Simple Banking System

Course: INFO-C 210
Project: Simple Bank Management System
Team Black : Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe



UML Diagram

The UML diagram included in the project shows how all the classes in the system are related. The Account class is an abstract superclass that contains shared fields and methods for all account types. Three subclasses, CheckingAccount, GoldAccount, and RegularAccount, extend this class and each one handles withdrawals, fees, and monthly updates in its own way. The Customer class is linked to Account through aggregation, which shows that a customer can own one or more accounts. The BankSystemTest class provides the user interface and is responsible for interacting with all the other classes to simulate basic bank operations.

Design and Implementation

This system is designed for a single bank operator who interacts with it using a simple text-based menu. Account numbers and customer IDs are not required to be unique, following the simplifying assumptions from the assignment. The program uses the double data type for money and does not save data once the program is closed. All account information exists only while the program is running. Basic error handling is included to prevent the program from crashing when a user enters invalid data.

Overview

The Customer class holds the customer’s ID, name, and phone number and represents the account owner. The abstract Account class defines common properties like account number, balance, and owner, as well as shared methods for deposits and displaying information. The subclasses each add their own specific rules. The CheckingAccount allows two free transactions per month and then charges a $3 fee for each additional transaction. The GoldAccount applies a fixed 5 percent interest and allows withdrawals even if the balance goes negative. The RegularAccount applies a 6 percent interest and subtracts a $10 maintenance fee each month. The BankSystemTest class contains the main menu that lets the operator create accounts, deposit and withdraw funds, view balances, apply monthly updates, and display bank statistics.

Running the System

To run the program, compile all Java files by using the command javac *.java and then start the application with java BankSystemTest. The program will display a menu with numbered options. From there, the operator can create new accounts, deposit or withdraw money, apply monthly updates, and see account and bank statistics. All interactions happen directly in the console.