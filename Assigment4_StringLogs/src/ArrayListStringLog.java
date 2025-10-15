/*
 * File: ArrayListStringLog.java
 * Purpose: BONUS: Implements StringLogInterface using an array list.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/15/2025
 * @version: 1.0
 */
import java.util.ArrayList;

public class ArrayListStringLog implements StringLogInterface
{
    protected String name;                 // name of this StringLog
    protected ArrayList<String> log;       // dynamic list that holds strings

    public ArrayListStringLog(String name)
    // Instantiates and returns a reference to an empty ArrayListStringLog
    // object with name "name".
    {
        this.name = name;
        this.log = new ArrayList<String>();
    }

    public void insert(String element)
    // Places element into this StringLog.
    {
        log.add(element);
    }

    public boolean uniqInsert(String element)
    // Inserts element unless an identical string already exists (case-sensitive).
    // Returns true if inserted, otherwise false.
    {
        if (this.contains(element))
            return false;
        this.insert(element);
        return true;
    }

    public boolean delete(String element)
    // Deletes the first occurrence of element (case-sensitive).
    // Returns true if deleted, otherwise false.
    {
        for (int i = 0; i < log.size(); i++)
        {
            if (element.equals(log.get(i)))
            {
                log.remove(i); // shift handled by ArrayList
                return true;
            }
        }
        return false;
    }

    public int deleteAll(String element)
    // Deletes all occurrences of element (case-sensitive).
    // Returns the number of deletions.
    {
        int deletions = 0;
        while (delete(element))
            deletions++;
        return deletions;
    }

    public boolean isFull()
    // ArrayList grows dynamically, never full.
    {
        return false;
    }

    public boolean isEmpty()
    // Returns true if this StringLog is empty, otherwise returns false.
    {
        return log.isEmpty();
    }

    public int size()
    // Returns the number of Strings in this StringLog.
    {
        return log.size();
    }

    public boolean contains(String element)
    // Returns true if element is in this StringLog (case-sensitive), otherwise false.
    {
        for (int i = 0; i < log.size(); i++)
        {
            if (element.equals(log.get(i)))
                return true;
        }
        return false;
    }

    public int howMany(String element)
    // Returns the number of times element occurs in this StringLog (case-sensitive).
    {
        int count = 0;
        for (int i = 0; i < log.size(); i++)
        {
            if (element.equals(log.get(i)))
                count++;
        }
        return count;
    }

    public void clear()
    // Makes this StringLog empty.
    {
        log.clear();
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
        for (int i = 0; i < log.size(); i++)
            logString = logString + (i + 1) + ". " + log.get(i) + "\n";
        return logString;
    }
}