package com.tools.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        //TODO: Insert your code
        int start = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for(int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while(sum >= S) {
                len = Math.min(len, end-start+1);
                sum -= arr[start++];
            }
        }

        return len;
    }
    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
