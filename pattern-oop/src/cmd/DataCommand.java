package cmd;

import data.DataStore;
import data.Record;

public class DataCommand implements Command {
    String[] args;

    DataCommand(String[] args) {
        this.args = args;
    }

    public void execute(DataStore dataStore) {
        // args => [Item] [Value]
        assert args.length == 2;
        int value = Integer.parseInt(args[1]);
        assert value >= 0;
        Record item = new Record(args[0], value);
        dataStore.addRecord(item);
    }
}
