public class UseStringLog {
    public static void main(String[] args) {
        try {
            ArrayStringLog log = new ArrayStringLog("TestLog", 10);

            System.out.println("Inserting elements...");
            log.insert("Apple");
            log.insert("Banana");
            log.insert("Cherry");
            log.insert("Apple");
            log.insert("apple");

            System.out.println("\nCurrent log:\n" + log);

            System.out.println("isEmpty(): " + log.isEmpty());
            System.out.println("howMany(\"apple\"): " + log.howMany("apple"));

            System.out.println("Attempting uniqInsert(\"banana\")...");
            System.out.println("Inserted? " + log.uniqInsert("banana"));
            System.out.println("Attempting uniqInsert(\"Mango\")...");
            System.out.println("Inserted? " + log.uniqInsert("Mango"));

            System.out.println("\nAfter unique inserts:\n" + log);

            System.out.println("Deleting all 'apple'...");
            int deleted = log.deleteAll("apple");
            System.out.println("Deleted count: " + deleted);
            System.out.println("\nLog after deletions:\n" + log);

            System.out.println("Clearing log...");
            log.clear();
            System.out.println("isEmpty() after clear: " + log.isEmpty());

        } catch (IllegalStateException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
    }
}