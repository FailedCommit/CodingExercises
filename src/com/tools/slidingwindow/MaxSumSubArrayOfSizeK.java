package com.tools.slidingwindow;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here

        int max = 0;
        int start = 0;
        int sum = 0;
        for(int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if(end >= k-1) {
                max = Math.max(max, sum);
//                System.out.println("sum:" + sum + " max" + max);
                sum -= arr[start++];
//                System.out.println("sum:" + sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
