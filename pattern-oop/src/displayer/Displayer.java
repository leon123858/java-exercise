package displayer;

import data.DataStore;
import data.Record;

import java.util.ArrayList;

public interface Displayer {
    public void display(ArrayList<Record> records);
}
