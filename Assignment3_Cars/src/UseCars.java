/*
 * File: UseCars.java
 * Purpose: Test program to create owners, assign cars, and demonstrate car operations.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

public class UseCars {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        // Create owners
        Owner o1 = new Owner("Jerry Smith", "612 Wharf Ave");
        Owner o2 = new Owner("Hank Venture", "332 Broadway Blvd");

        // Create cars
        cars.add(new SportsCar("Ferrari", "488", 2020, "VIN431", o1, 660));
        cars.add(new SedanCar("Toyota", "Camry", 2018, "VIN555", o2, 4, 15));
        cars.add(new SportsCar("Porsche", "911", 2021, "VIN789", o2, 443));

        // Search by VIN
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a VIN to search: ");
        String vinSearch = input.nextLine();

        Car found = null;
        for (Car car : cars) {
            if (car.getVin().equalsIgnoreCase(vinSearch)) {
                found = car;
                break;
            }
        }

        if (found != null) {
            System.out.println("Car found: " + found);
        } else {
            System.out.println("No car found with VIN " + vinSearch);
        }

        // Display all cars
        System.out.println("\nAll cars in the system:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
