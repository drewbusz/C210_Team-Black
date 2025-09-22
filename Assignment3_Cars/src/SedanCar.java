/*
 * File: SedanCar.java
 * Purpose: Represents a sedan car with number of doors and trunk size attributes.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class SedanCar extends Car {
    private int doors;
    private int trunkSize; // cubic feet

    public SedanCar(String make, String model, int year, String vin, Owner owner,
                    int doors, int trunkSize) {
        super(make, model, year, vin, owner);
        this.doors = doors;
        this.trunkSize = trunkSize;
    }

    public int getDoors() { return doors; }
    public int getTrunkSize() { return trunkSize; }

    @Override
    public String toString() {
        return "SedanCar: " + getYear() + " " + getMake() + " " + getModel()
                + " | VIN: " + getVin()
                + " | Doors: " + doors
                + " | Trunk: " + trunkSize + " cu ft"
                + " | Owner: " + getOwner();
    }
}
