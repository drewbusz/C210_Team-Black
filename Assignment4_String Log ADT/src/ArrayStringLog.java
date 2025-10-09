public class ArrayStringLog implements StringLogInterface {
    private String name;
    private String[] log;
    private int lastIndex = -1;

    public ArrayStringLog(String name, int maxSize) {
        this.name = name;
        log = new String[maxSize];
    }

    @Override
    public void insert(String element) {
        if (isFull()) {
            throw new IllegalStateException("The log is full. Cannot insert new element.");
        }
        lastIndex++;
        log[lastIndex] = element;
    }

    @Override
    public boolean contains(String element) {
        for (int i = 0; i <= lastIndex; i++) {
            if (log[i].equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }

    @Override
    public boolean isFull() {
        return lastIndex == (log.length - 1);
    }

    @Override
    public void clear() {
        for (int i = 0; i <= lastIndex; i++) {
            log[i] = null;
        }
        lastIndex = -1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public int howMany(String element) {
        int count = 0;
        for (int i = 0; i <= lastIndex; i++) {
            if (log[i].equalsIgnoreCase(element)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean uniqInsert(String element) {
        if (contains(element)) {
            return false;
        }
        insert(element);
        return true;
    }

    private boolean delete(String element) {
        for (int i = 0; i <= lastIndex; i++) {
            if (log[i].equalsIgnoreCase(element)) {
                for (int j = i; j < lastIndex; j++) {
                    log[j] = log[j + 1];
                }
                log[lastIndex] = null;
                lastIndex--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteAll(String element) {
        int count = 0;
        while (delete(element)) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Log: " + name + "\n");
        for (int i = 0; i <= lastIndex; i++) {
            result.append((i + 1) + ". " + log[i] + "\n");
        }
        return result.toString();
    }
}