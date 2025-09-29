/*
 * File: CommercialCustomer.java
 * Purpose: Represents a commercial customer with credit rating and contact details.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class CommercialCustomer extends Customer {
    private String creditRating;
    private String contactPerson;
    private String contactPhone;

    public CommercialCustomer(String name, String address, String phone,
                              String creditRating, String contactPerson, String contactPhone) {
        super(name, address, phone);
        this.creditRating = creditRating;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public String getCreditRating() { return creditRating; }
    public String getContactPerson() { return contactPerson; }
    public String getContactPhone() { return contactPhone; }


    public String getSummary() {
        return "[Commercial] " + getName() + " | Credit: " + creditRating
                + " | Contact: " + contactPerson + " (" + contactPhone + ")";
    }
}