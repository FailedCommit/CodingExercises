package com.tools.misc;

import java.util.Arrays;

public class SubArrayAverage {
    public static void main(String[] args) {
        int[] input = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] averages = average(input, 5);
        System.out.println(Arrays.toString(averages));
    }

    private static double[] average(int[] input, int windowSize) {
        double[] result = new double[input.length - windowSize + 1];
        double windowSum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            windowSum += input[windowEnd];
            if(windowEnd >= windowSize - 1) {
                result[windowStart] = windowSum / windowSize;
                windowSum -= input[windowStart++];
            }
        }
        return result;
    }
}