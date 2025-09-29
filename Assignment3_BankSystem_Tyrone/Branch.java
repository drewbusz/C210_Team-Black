/*
 * File: Branch.java
 * Purpose: Represents a bank branch with a name and location.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class Branch {
    private String code;
    private String city;

    public Branch(String code, String city) {
        this.code = code;
        this.city = city;
    }

    public String getCode() { return code; }
    public String getCity() { return city; }


    public String toString() {
        return city + " (" + code + ")";
    }
}

