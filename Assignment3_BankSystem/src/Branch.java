/*
 * File: Branch.java
 * Purpose: Represents a bank branch with a name and location.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 07/28/2025
 * @version: 1.0
 */
public class Branch {
    private String branchName;
    private String location;

    public Branch(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
    }

    public String getBranchName() { return branchName; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return branchName + " Branch (" + location + ")";
    }
}
