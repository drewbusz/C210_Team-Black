/*
 * File: Car.java
 * Purpose: Defines the Car class, which represents a car with make, model, year, and price
 * attributes. Each car is associated with a CarOwner. Includes constructors, accessors,
 * mutators, and a method to display the car’s details along with its owner information.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/14/2025
 * @version: 1.0
 */
public class Car {
    private String make;
    private String model;
    private int year;
    private double price;
    private CarOwner owner; // composition: each car has one owner

    // Default constructor
    public Car() {
        make = "Unknown";
        model = "Unknown";
        year = 0;
        price = 0.0;
        owner = new CarOwner();
    }

    // Constructor with parameters
    public Car(String make, String model, int year, double price, CarOwner owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    // toString method
    public String toString() {
        return year + " " + make + " " + model +
                ", Price: $" + price +
                ", " + owner.toString();
    }
}