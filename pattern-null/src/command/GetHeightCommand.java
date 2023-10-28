package command;

import utils.AbstractPerson;

import java.util.ArrayList;

public abstract class GetHeightCommand extends GetCommand {
    public GetHeightCommand(String[] args) {
        super(args);
    }

    protected ArrayList<Integer> getHeights(ArrayList<AbstractPerson> dataArr) {
        ArrayList<Integer> heights = new ArrayList<>();
        for (AbstractPerson person : getTargetPersons(dataArr)) {
            heights.add(person.getHeight());
        }
        return heights;
    }
}
