package displayer;

import data.Record;

import java.util.ArrayList;

public class SpreadsheetDisplayer implements Displayer {
    @Override
    public void display(ArrayList<Record> records) {
        for (Record record : records) {
            System.out.printf("%s %d%n", record.item, record.value);
        }
    }
}
