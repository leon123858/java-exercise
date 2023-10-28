package utils;

import java.util.ArrayList;

public class SumCalculator implements Calculator {
    public int calculate(ArrayList<Integer> dataArr) {
        int sum = 0;
        for (int data : dataArr) {
            sum += data;
        }
        return sum;
    }
}
