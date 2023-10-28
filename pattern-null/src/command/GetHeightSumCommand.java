package command;

import utils.AbstractPerson;
import utils.AverageCalculator;
import utils.Calculator;
import utils.SumCalculator;

import java.util.ArrayList;

public class GetHeightSumCommand extends GetHeightCommand{
    public GetHeightSumCommand(String[] args) {
        super(args);
    }

    /**
     * @param dataArr ArrayList<AbstractPerson>
     */
    @Override
    public void execute(ArrayList<AbstractPerson> dataArr) {
        Calculator calculator = new SumCalculator();
        System.out.println(calculator.calculate(getHeights(dataArr)));
    }
}
