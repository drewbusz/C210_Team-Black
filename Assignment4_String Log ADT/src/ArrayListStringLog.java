import java.util.ArrayList;

public class ArrayListStringLog implements StringLogInterface {
    private String name;
    private ArrayList<String> log;

    public ArrayListStringLog(String name) {
        this.name = name;
        this.log = new ArrayList<>();
    }

    @Override
    public void insert(String element) {
        log.add(element);
    }

    @Override
    public boolean contains(String element) {
        for (String s : log) {
            if (s.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return log.size();
    }

    @Override
    public boolean isFull() {
        return false; // ArrayLists dynamically resize
    }

    @Override
    public void clear() {
        log.clear();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEmpty() {
        return log.isEmpty();
    }

    @Override
    public int howMany(String element) {
        int count = 0;
        for (String s : log) {
            if (s.equalsIgnoreCase(element)) count++;
        }
        return count;
    }

    @Override
    public boolean uniqInsert(String element) {
        if (!contains(element)) {
            insert(element);
            return true;
        }
        return false;
    }

    @Override
    public int deleteAll(String element) {
        int count = 0;
        while (log.removeIf(e -> e.equalsIgnoreCase(element))) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Log: " + name + "\n");
        for (int i = 0; i < log.size(); i++) {
            result.append((i + 1) + ". " + log.get(i) + "\n");
        }
        return result.toString();
    }
}