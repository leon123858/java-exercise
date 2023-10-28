package command;

import utils.AbstractPerson;
import utils.AverageCalculator;
import utils.Calculator;

import java.util.ArrayList;

public class GetWeightAvgCommand extends GetWeightCommand {
    public GetWeightAvgCommand(String[] args) {
        super(args);
    }

    /**
     * @param dataArr ArrayList<AbstractPerson>
     */
    @Override
    public void execute(ArrayList<AbstractPerson> dataArr) {
        Calculator calculator = new AverageCalculator();
        System.out.println(calculator.calculate(getWeights(dataArr)));
    }
}
