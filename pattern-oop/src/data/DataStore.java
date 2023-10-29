package data;

import displayer.ChartType;

import java.util.ArrayList;

public class DataStore {
    ArrayList<ChartType> charts = new ArrayList<>();
    ArrayList<Record> records = new ArrayList<>();

    public ArrayList<ChartType> getCharts() {
        return charts;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void addChart(ChartType chartType) {
        charts.add(chartType);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public void upsertRecord(String item, int value) {
        for (Record record : records) {
            if (record.item.equals(item)) {
                record.value = value;
                return;
            }
        }
        addRecord(new Record(item, value));
    }
}
