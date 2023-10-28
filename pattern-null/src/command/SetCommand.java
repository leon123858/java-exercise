package command;

import java.util.ArrayList;

public abstract class SetCommand extends Command{
    public SetCommand(String[] args) {
        super(args);
    }

    public <T>void setData(T data, ArrayList<T> dataArr) {
        dataArr.add(data);
    }
}
