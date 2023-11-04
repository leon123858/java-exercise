package Command;

public class CommandFactory {
    public static Command createCommand(String originCommand) {
        String[] commandSplit = originCommand.split(" ");
        if (commandSplit.length < 2) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return switch (commandSplit[1]) {
            case "add" -> new AddCommand(commandSplit);
            case "display" -> new DisplayCommand(commandSplit);
            default -> new DefineCommand(commandSplit);
        };
    }
}
