package command;

public class CommandFactory {
    public static Command create(String originCommand) {
        String[] args = originCommand.split(" ");
        return switch (args[0]) {
            case "Person" -> {
                if (args.length != 5) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length == 5;
                String[] parameter = {args[1], args[2], args[3], args[4]};
                yield new SetPersonCommand(parameter);
            }
            case "Job" -> {
                if (args.length != 2) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length == 2;
                String[] parameter = {args[1]};
                yield new GetJobCommand(parameter);
            }
            case "WeightAverage" -> {
                if (!(args.length > 1)) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length > 1;
                String[] parameter = new String[args.length - 1];
                System.arraycopy(args, 1, parameter, 0, args.length - 1);
                yield new GetWeightAvgCommand(parameter);
            }
            case "WeightSum" -> {
                if (!(args.length > 1)) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length > 1;
                String[] parameter = new String[args.length - 1];
                System.arraycopy(args, 1, parameter, 0, args.length - 1);
                yield new GetWeightSumCommand(parameter);
            }
            case "HeightAverage" -> {
                if (!(args.length > 1)) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length > 1;
                String[] parameter = new String[args.length - 1];
                System.arraycopy(args, 1, parameter, 0, args.length - 1);
                yield new GetHeightAvgCommand(parameter);
            }
            case "HeightSum" -> {
                if (!(args.length > 1)) {
                    throw new IllegalArgumentException("Invalid command");
                }
//                assert args.length > 1;
                String[] parameter = new String[args.length - 1];
                System.arraycopy(args, 1, parameter, 0, args.length - 1);
                yield new GetHeightSumCommand(parameter);
            }
            default -> throw new IllegalArgumentException("Invalid command");
        };
    }
}
