import java.util.ArrayList;

public class CustomListImp implements CustomList{
    private final ArrayList<String> list;
    private final String name;

    public CustomListImp(String name) {
        this.list = new ArrayList<String>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(String value) {
        list.add(value);
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String getNode(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CustomIterator iterator() {
        return new CustomIteratorImp();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int length() {
        return list.size();
    }

    private class CustomIteratorImp implements CustomIterator {
        private int index;

        public CustomIteratorImp() {
            this.index = 0;
        }

        public boolean hasNext() {
            return index < list.size();
        }

        public String next() {
            return list.get(index++);
        }
    }
}
