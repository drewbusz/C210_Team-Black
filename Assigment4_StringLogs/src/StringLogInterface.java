/*
 * File: StringLogInterface.java
 * Purpose: Interface for a class that implements a log of Strings.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/15/2025
 * @version: 1.0
 */
//----------------------------------------------------------------------
// StringLogInterface.java     by Dale/Joyce/Weems
//
// Interface for a class that implements a log of Strings.
// A log "remembers" the elements placed into it.
//
// A log must have a "name".
//----------------------------------------------------------------------

public interface StringLogInterface
{
    void insert(String element);
    // Precondition:   This StringLog is not full.
    //
    // Places element into this StringLog.

    boolean uniqInsert(String element);
    // Inserts element unless an identical string already exists.
    // Uses case-insensitive comparison. Returns true if inserted, otherwise false.

    boolean delete(String element);
    // Delete one instance of element from the String Log
    // Returns true if the element is deleted, otherwise, returns false.

    int deleteAll(String element);
    // Delete all occurrences of element from the String Log.
    // Returns the number of deletions.

    boolean isFull();
    // Returns true if this StringLog is full, otherwise returns false.

    boolean isEmpty();
    // Returns true if this StringLog has no elements, otherwise returns false.

    int size();
    // Returns the number of Strings in this StringLog.

    boolean contains(String element);
    // Returns true if element is in this StringLog,
    // otherwise returns false.
    // Ignores case differences when doing string comparison.

    int howMany(String element);
    // Returns the number of times element occurs in this StringLog.

    void clear();
    // Makes this StringLog empty.

    String getName();
    // Returns the name of this StringLog.

    String toString();
    // Returns a nicely formatted string representing this StringLog.
}
