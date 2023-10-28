package command;

import utils.AbstractPerson;

import java.util.ArrayList;

public abstract class GetWeightCommand extends GetCommand{
    public GetWeightCommand(String[] args) {
        super(args);
    }

    protected ArrayList<Integer> getWeights(ArrayList<AbstractPerson> dataArr) {
        ArrayList<Integer> weights = new ArrayList<>();
        for (AbstractPerson person : getTargetPersons(dataArr)) {
            weights.add(person.getWeight());
        }
        return weights;
    }
}
