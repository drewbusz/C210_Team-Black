public interface StringLogInterface {
    void insert(String element);
    boolean contains(String element);
    int size();
    boolean isFull();
    void clear();
    String getName();

    boolean isEmpty();
    int howMany(String element);
    boolean uniqInsert(String element);
    int deleteAll(String element);
}