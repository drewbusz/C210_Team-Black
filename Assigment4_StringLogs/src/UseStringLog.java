/*
 * File: UseStringLog.java
 * Purpose: Simple example of the use of a StringLog with additional test cases to show that added methods in action.
 * @author: Team Black - Drew Busz, Maram Algaradi, Tyrone Chandler, Marla Rush, Harrison Usigbe
 * @date: 10/15/2025
 * @version: 1.0
 */
//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------
public class UseStringLog
{
    public static void main(String[] args)
    {
        StringLogInterface sample;
        sample = new ArrayStringLog("Example Use");

        System.out.println("Is empty? " + sample.isEmpty()); // true, no strings inserted

        sample.insert("Elvis");
        sample.insert("elvis");
        sample.insert("King Louis XII");
        sample.insert("Captain Kirk");

        System.out.println("Is empty? " + sample.isEmpty()); // false, strings have been inserted

        System.out.println(sample);
        System.out.println("uniqInsert('Elvis'): " + sample.uniqInsert("Elvis")); // duplicate (case-insensitive)
        System.out.println("uniqInsert('ELVIS'): " + sample.uniqInsert("ELVIS")); // duplicate (case-insensitive)
        System.out.println("uniqInsert('Spock'): " + sample.uniqInsert("Spock")); // true (new string)

        int c1 = sample.howMany("Elvis");
        System.out.println("howMany('Elvis') = " + c1); // case-insensitive count

        sample.delete("Elvis"); // deletes one Elvis (case-insensitive)
        int removed = sample.deleteAll("Elvis"); // deletes remaining Elvis entries (case-insensitive)
        System.out.println("deleteAll('Elvis') removed: " + removed);

        System.out.println(sample); //show final state after deletions
        System.out.println("The size of the log is " + sample.size());
        System.out.println("Elvis is in the log: " + sample.contains("Elvis"));
        System.out.println("Santa is in the log: " + sample.contains("Santa"));

        // BONUS
        StringLogInterface listLog = new ArrayListStringLog("ArrayList Demo");

        System.out.println("Is empty? " + listLog.isEmpty()); // true

        listLog.insert("Elvis");
        listLog.insert("elvis");
        listLog.insert("King Louis XII");
        listLog.insert("Captain Kirk");

        System.out.println("Is empty? " + listLog.isEmpty()); // false

        System.out.println(listLog);
        System.out.println("uniqInsert('Elvis'): " + listLog.uniqInsert("Elvis")); // false because duplicate
        System.out.println("uniqInsert('ELVIS'): " + listLog.uniqInsert("ELVIS")); // true because different case
        System.out.println("uniqInsert('Spock'): " + listLog.uniqInsert("Spock")); // true 

        int c2 = listLog.howMany("Elvis");
        System.out.println("howMany('Elvis') = " + c2); // case-sensitive count

        listLog.delete("Elvis"); // deletes exact "Elvis"
        int removed2 = listLog.deleteAll("Elvis"); // deletes remaining exact "Elvis"
        System.out.println("deleteAll('Elvis') removed: " + removed2);

        System.out.println(listLog);
        System.out.println("The size of the log is " + listLog.size());
        System.out.println("Elvis is in the log: " + listLog.contains("Elvis"));
        System.out.println("Santa is in the log: " + listLog.contains("Santa"));
    }
}