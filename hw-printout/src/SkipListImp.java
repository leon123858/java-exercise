import java.util.ArrayList;

public class SkipListImp implements CustomList{
    private final ArrayList<String> list;
    private final String name;

    public SkipListImp(String name) {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNode(int index) {
        return "SkipNode:" + list.get(index);
    }

    public CustomIterator iterator() {
        return new CustomIteratorImp();
    }

    @Override
    public int size () {
        return list.size();
    }

    @Override
    public int length() {
        throw new UnsupportedOperationException("Not supported yet.");
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
            return "SkipNode:" + list.get(index++);
        }
    }
}
