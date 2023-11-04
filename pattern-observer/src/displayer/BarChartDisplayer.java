package displayer;

import data.Record;

import java.util.ArrayList;
import java.util.Arrays;

public class BarChartDisplayer implements Displayer {
    @Override
    public void display(ArrayList<Record> records) {
        for (Record record : records) {
            // print [=*value] [item]
            char[] equalsArray = new char[record.value];
            Arrays.fill(equalsArray, '=');
            // join char array to string
            String equalsString = new String(equalsArray);
            System.out.printf("%s %s%n", equalsString, record.item);
        }
    }
}
