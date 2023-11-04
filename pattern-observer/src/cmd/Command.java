package cmd;

import data.DataStore;

public interface Command {
    static CommandType getCommandType(String arg) {
        return CommandType.valueOf(arg);
    }

    public void execute(DataStore dataStore);
}
