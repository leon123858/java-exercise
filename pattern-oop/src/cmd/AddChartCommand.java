package cmd;

import data.DataStore;
import data.Record;
import displayer.ChartType;

public class AddChartCommand implements Command {
    String[] args;

    AddChartCommand(String[] args) {
        this.args = args;
    }

    public void execute(DataStore dataStore) {
        // args => [ChartType]
        assert args.length == 1;
        ChartType chartType = ChartType.valueOf(args[0]);
        dataStore.addChart(chartType);
    }
}
