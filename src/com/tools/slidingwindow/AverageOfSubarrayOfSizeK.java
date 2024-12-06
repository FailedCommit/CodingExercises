package com.tools.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of sub arrays of size K: " + Arrays.toString(result));
    }
}
