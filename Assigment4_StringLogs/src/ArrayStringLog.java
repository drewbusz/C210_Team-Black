/*
 * File: ArrayStringLog.java
 * Purpose: Implements StringLogInterface using an array to hold the strings
 *          Added additional methods isEmpty, howMany, uniqInsert, and deleteAll per instructions.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/15/2025
 * @version: 1.0
 */
//----------------------------------------------------------------------
// ArrayStringLog.java        by Dale/Joyce/Weems
//
// Implements StringLogInterface using an array to hold the strings.
//----------------------------------------------------------------------

public class ArrayStringLog implements StringLogInterface
{
    protected String name;              // name of this StringLog
    protected String[] log;             // array that holds strings
    protected int lastIndex = -1;       // index of last string in array

    public ArrayStringLog(String name, int maxSize)
    // Precondition:   maxSize > 0
    //
    // Instantiates and returns a reference to an empty ArrayStringLog
    // object with name "name" and room for maxSize strings.
    {
        log = new String[maxSize];
        this.name = name;
    }

    public ArrayStringLog(String name)
    // Instantiates and returns a reference to an empty ArrayStringLog
    // object with name "name" and room for 100 strings.
    {
        log = new String[100];
        this.name = name;
    }

    public void insert(String element)
    // Precondition:   This StringLog is not full.
    //
    // Places element into this StringLog.
    {
        lastIndex++;
        log[lastIndex] = element;
    }

    public boolean uniqInsert(String element)
    // Inserts element unless an identical string already exists.
    // Returns true if inserted, otherwise false.
    {
        boolean duplicate;
        boolean success;

        duplicate = this.contains(element);
        if (duplicate)
            success = false;
        else if (this.isFull())
            success = false;
        else
        {
            this.insert(element);
            success = true;
        }

        return success;
    }

    public boolean delete(String element){
        boolean moreToSearch;
        int location = 0;
        boolean found = false;
        moreToSearch = (location <= lastIndex);

        while (moreToSearch && !found) {
            if (element.equalsIgnoreCase(log[location]))
                found = true;
            else {
                location++;
                moreToSearch = (location <= lastIndex);
            }
        }
        if  (found == true){
            log[location] = log[lastIndex];
            log[lastIndex] = null;
            lastIndex--;
        }
        return found;
    }

    public int deleteAll(String element) {
        int deletions = 0;
        boolean moreToDelete;
        boolean removed;

        removed = delete(element);
        moreToDelete = removed;

        while (moreToDelete) {
            deletions++;
            removed = delete(element);
            moreToDelete = removed;
        }

        return deletions;
    }

    public boolean isFull()
    // Returns true if this StringLog is full, otherwise returns false.
    {
        if (lastIndex == (log.length - 1))
            return true;
        else
            return false;
    }

    public boolean isEmpty()
    // Returns true if this StringLog is empty, otherwise returns false.
    {
        if (lastIndex == -1)
            return true;
        else
            return false;
    }

    public int size()
    // Returns the number of Strings in this StringLog.
    {
        return (lastIndex + 1);
    }

    public boolean contains(String element)
    // Returns true if element is in this StringLog,
    // otherwise returns false.
    // Ignores case differences when doing string comparison.
    {
        int location = 0;
        while (location <= lastIndex)
        {
            if (element.equalsIgnoreCase(log[location]))  // if they match
                return true;
            else
                location++;
        }
        return false;
    }

    public int howMany(String element)
    // Returns an integer value indicating how many times element occurs in this StringLog.
    {
        int count = 0;
        int location = 0;
        boolean moreToSearch;

        moreToSearch = (location <= lastIndex);

        while (moreToSearch)
        {
            if (element.equalsIgnoreCase(log[location]))
                count++;
            location++;
            moreToSearch = (location <= lastIndex);
        }
        return count;
    }

    public void clear()
    // Makes this StringLog empty.
    {
        for (int i = 0; i <= lastIndex; i++)
            log[i] = null;
        lastIndex = -1;
    }

    public String getName()
    // Returns the name of this StringLog.
    {
        return name;
    }

    public String toString()
    // Returns a nicely formatted string representing this StringLog.
    {
        String logString = "Log: " + name + "\n\n";

        for (int i = 0; i <= lastIndex; i++)
            logString = logString + (i+1) + ". " + log[i] + "\n";

        return logString;
    }
}