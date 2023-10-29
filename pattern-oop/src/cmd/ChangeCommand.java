package cmd;

import data.DataStore;
import displayer.ChartType;
import displayer.DisplayerFactory;

public class ChangeCommand implements Command {
    String[] args;

    ChangeCommand(String[] args) {
        this.args = args;
    }

    public void execute(DataStore dataStore) {
        // args => [ChartType] [Item] [Value]
        assert args.length == 3;
        int value = Integer.parseInt(args[2]);
        assert value >= 0;
        dataStore.upsertRecord(args[1], value);
        // print "[ChartType] change [Item] [Value]." to stdout
        System.out.println(args[0] + " change " + args[1] + " " + args[2] + ".");
        // display
        for (ChartType chartType : dataStore.getCharts()) {
            DisplayerFactory.getDisplayer(chartType).display(dataStore.getRecords());
        }
    }
}
