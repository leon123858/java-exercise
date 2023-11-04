package cmd;

public class CommandFactory {
    public static Command getCommand(String originalCommand) {
        String[] args = originalCommand.split(" ");
        CommandType commandType = Command.getCommandType(args[0]);
        String[] parameters = new String[args.length - 1];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        return switch (commandType) {
            case data -> new DataCommand(parameters);
            case addChart -> new AddChartCommand(parameters);
            case change -> new ChangeCommand(parameters);
            default -> throw new IllegalStateException("Unexpected value: " + commandType);
        };
    }
}
