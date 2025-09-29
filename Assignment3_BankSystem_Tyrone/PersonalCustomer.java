/*
 * File: PersonalCustomer.java
 * Purpose: Represents a personal customer with home and work phone numbers.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class PersonalCustomer extends Customer {
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(String name, String address, String phone,
                            String homePhone, String workPhone) {
        super(name, address, phone);
        this.homePhone = homePhone;
        this.workPhone = workPhone;
    }

    public String getHomePhone() { return homePhone; }
    public String getWorkPhone() { return workPhone; }


    public String getSummary() {
        return "[Personal] " + getName() + " | Main: " + getPhone()
                + " | Home: " + homePhone + " | Work: " + workPhone;
    }
}
