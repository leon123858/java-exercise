package data;

public class Record {
    public String item;
    public int value;

    public Record(String item, int value) {
        assert value >= 0;
        assert item != null;

        this.item = item;
        this.value = value;
    }
}
