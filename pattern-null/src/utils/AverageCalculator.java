package utils;

import java.util.ArrayList;

public class AverageCalculator extends SumCalculator {
    public int calculate(ArrayList<Integer> dataArr) {
        int sum = super.calculate(dataArr);
        return Math.round((float) sum / dataArr.size()) ;
    }
}
