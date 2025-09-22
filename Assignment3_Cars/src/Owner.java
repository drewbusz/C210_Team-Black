/*
 * File: Owner.java
 * Purpose: Represents a car owner with personal details and a list of owned cars.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class Owner {
    private String name;
    private String address;

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName()    { return name; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return name + " (" + address + ")";
    }
}
