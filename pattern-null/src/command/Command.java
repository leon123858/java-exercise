package command;

import utils.AbstractPerson;

import java.util.ArrayList;

public abstract class Command {
    public String[] args;
    public int length;

    public Command(String[] args) {
        this.args = args;
        this.length = args.length;
    }

    public abstract void execute(ArrayList<AbstractPerson> dataArr);
}
