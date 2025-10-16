/*
 * File: Customer.java
 * Purpose: Stores customer information such as ID, name, and phone.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/17/2025
 * @version: 1.0
 */

public class Customer {
    private String id;
    private String name;
    private String phone;

    
    public Customer(String id, String name, String phone) {
        this.id = (id == null ? "" : id.trim());
        this.name = (name == null ? "" : name.trim());
        this.phone = (phone == null ? "" : phone.trim());
    }

    
    public Customer(String id, String name) {
        this(id, name, "");
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public String getPhone() { return phone; }

    public void setName(String name)   { this.name = (name == null ? "" : name.trim()); }
    public void setPhone(String phone) { this.phone = (phone == null ? "" : phone.trim()); }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "', phone='" + phone + "'}";
    }
}
