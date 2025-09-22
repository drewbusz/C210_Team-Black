/*
 * File: Car.java
 * Purpose: Defines a generic car superclass with common attributes and owner association.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public abstract class Car {
    private String make;
    private String model;
    private int year;
    private String vin;
    private Owner owner;

    public Car(String make, String model, int year, String vin, Owner owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.owner = owner;
    }

    public String getMake()  { return make; }
    public String getModel() { return model; }
    public int getYear()     { return year; }
    public String getVin()   { return vin; }
    public Owner getOwner()  { return owner; }

    @Override
    public abstract String toString();
}