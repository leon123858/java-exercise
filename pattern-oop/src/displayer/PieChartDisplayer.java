package displayer;

import data.Record;

import java.util.ArrayList;

public class PieChartDisplayer implements Displayer {
    @Override
    public void display(ArrayList<Record> records) {
        // get sum od records.item
        int sum = 0;
        for (Record record : records) {
            sum += record.value;
        }
        // print [Item] [Percentage]%
        for (Record record : records) {
            float percent = (float) (100 * record.value) / sum;
            // convert percent to one decimal place
            System.out.printf("%s %.1f%%%n", record.item, percent);
        }
    }
}
