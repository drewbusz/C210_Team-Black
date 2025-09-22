/*
 * File: SportsCar.java
 * Purpose: Represents a sports car with additional field for horsepower.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class SportsCar extends Car {
    private int horsepower;

    public SportsCar(String make, String model, int year, String vin, Owner owner,
                     int horsepower) {
        super(make, model, year, vin, owner);
        this.horsepower = horsepower;
    }

    public int getHorsepower() { return horsepower; }

    @Override
    public String toString() {
        return "SportsCar: " + getYear() + " " + getMake() + " " + getModel()
                + " | VIN: " + getVin()
                + " | Horsepower: " + horsepower
                + " | Owner: " + getOwner();
    }
}
