/*
 * File: CarOwner.java
 * Purpose: Defines the CarOwner class, which represents a car owner with name
 * and address attributes, along with constructors, accessors, mutators, and a
 * method to display the owner’s information.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/14/2025
 * @version: 1.0
 */

public class CarOwner {
    private String name;
    private String address;

    // Default constructor
    public CarOwner() {
        name = "Unknown";
        address = "Unknown";
    }

    // Constructor with parameters
    public CarOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString method
    public String toString() {
        return "Owner: " + name + ", Address: " + address;
    }
}