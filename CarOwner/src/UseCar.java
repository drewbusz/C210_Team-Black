/*
 * File: UseCar.java
 * Purpose: Shows how the Car and CarOwner classes work by making a few car objects,
 * putting them in an ArrayList, and printing their details with owner info.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/14/2025
 * @version: 1.0
 */
import java.util.ArrayList;

public class UseCar {
    public static void main(String[] args) {
        // Create owners
        CarOwner owner1 = new CarOwner("Stacy McDavid", "123 Main St");
        CarOwner owner2 = new CarOwner("Bob Stephan", "456 Oak Ave");
        CarOwner owner3 = new CarOwner("Jerry Smith", "789 Pine Rd");

        // Create cars
        Car car1 = new Car("Subaru", "Outback", 2020, 24000, owner1);
        Car car2 = new Car("Honda", "Civic", 2021, 22000, owner2);
        Car car3 = new Car("Ford", "Mustang", 2019, 28000, owner3);

        // Store in ArrayList
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Display
        System.out.println("Car Inventory:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}