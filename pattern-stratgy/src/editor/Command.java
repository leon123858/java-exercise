package editor;

import java.util.ArrayList;

public class Command {
    public CommandType type;
    public CommandHandler handler;
    public String[] args;
    public Command(String originArgs, ArrayList<Element> data) {
        String[] args = originArgs.split(" ");
        this.type = CommandType.valueOf(args[0]);
        this.args = new String[args.length - 1];
        System.arraycopy(args, 1, this.args, 0, args.length - 1);
        switch (this.type) {
            case CommandType.Text, CommandType.GraphicalElement:
                this.handler = new ElementHandler(data);
                break;
            case CommandType.ChangeSize:
                this.handler = new EditHandler(data);
                break;
            case CommandType.Require:
                this.handler = new RequireHandler(data);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.type);
        }
    }

    public void execute() {
        this.handler.handle(this.args);
    }
}
