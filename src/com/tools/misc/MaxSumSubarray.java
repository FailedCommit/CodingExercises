package com.tools.misc;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] input = new int[] {2, 1, 5, 1, 3, 2};
        System.out.println(maxSumSubarray(input, 3));

        input = new int[] {2, 3, 4, 1, 5};
        System.out.println(maxSumSubarray(input, 2));
    }

    private static int maxSumSubarray(int[] input, int k) {
        int max = 0;
        int sum = 0;
        int winStart = 0;
        for(int winEnd = 0; winEnd < input.length; winEnd++) {
            sum += input[winEnd];
            if(winEnd >= (k - 1)) {
                max = max < sum ? sum : max;
                sum -= input[winStart++];
            }
        }
        return max;
    }
}