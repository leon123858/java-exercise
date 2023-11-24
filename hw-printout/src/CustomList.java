public interface CustomList {
    CustomIterator iterator();

    int size();
    int length();
    void add(String content);
    String get(int index);
    String getNode(int index);
}
