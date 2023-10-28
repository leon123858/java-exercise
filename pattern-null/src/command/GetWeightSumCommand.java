package command;

import utils.AbstractPerson;
import utils.Calculator;
import utils.SumCalculator;

import java.util.ArrayList;

public class GetWeightSumCommand extends GetWeightCommand {

    public GetWeightSumCommand(String[] args) {
        super(args);
    }

    /**
     * @param dataArr ArrayList<AbstractPerson>
     */
    @Override
    public void execute(ArrayList<AbstractPerson> dataArr) {
        Calculator calculator = new SumCalculator();
        System.out.println(calculator.calculate(getWeights(dataArr)));
    }
}
