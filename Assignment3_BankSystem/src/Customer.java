/*
 * File: Customer.java
 * Purpose: Defines a generic customer superclass with common attributes for all customers.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public abstract class Customer {
    private String name;
    private String address;
    private String phone;

    protected Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone  = phone;
    }

    public String getName()    { return name; }
    public String getAddress() { return address; }
    public String getPhone()   { return phone; }

    @Override
    public abstract String toString();
}
