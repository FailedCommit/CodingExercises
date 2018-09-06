package com.tools;

import java.util.Arrays;

/**
 * Illustrates Kadane's algorithm to find maximum sum of a contiguous sub-array.
 */
public class MaxSumSubArray {

  public static void main(String[] args) {
    int[] a0 = {1, 2, 5, 2, 7, 1, 9};
    int[] a1 = {-1, -2, -2, -3};
    int[] a2 = {-2, -3, 4, -1, -2, 1, 5, -3};

    MaxSumSubArray mssa = new MaxSumSubArray();
    System.out.println("Given: " + Arrays.toString(a0) + "\nMaxSum: " + mssa.findMaxSum(a0)
        + "\nMaxSumSubArray: " + Arrays.toString(mssa.findMaxSumWithSubArray(a0)));
    System.out.println("\n\nGiven: " + Arrays.toString(a1) + "\nMaxSum: " + mssa.findMaxSum(a1)
        + "\nMaxSumSubArray: " + Arrays.toString(mssa.findMaxSumWithSubArray(a1)));
    System.out.println("\n\nGiven: " + Arrays.toString(a2) + "\nMaxSum: " + mssa.findMaxSum(a2)
        + "\nMaxSumSubArray: " + Arrays.toString(mssa.findMaxSumWithSubArray(a2)));
  }

  private int findMaxSum(int[] a) {
    if (a == null || a.length == 0) {
      return -1;
    } else if (a.length == 1) {
      return a[0];
    }

    int curr_max = a[0];
    int global_max = a[0];

    for (int i = 1; i < a.length; i++) {
      curr_max = Math.max(a[i], curr_max + a[i]);
      global_max = Math.max(global_max, curr_max);
    }
    return global_max;
  }
  
  /**
   * Finds the max sum of a contiguous sub-array and the sub-array as well.
   */
  private int[] findMaxSumWithSubArray(int[] a) {
    int[] maxSumSubArray = new int[] {};
    if (a == null || a.length == 0) {
      return maxSumSubArray;
    } else if (a.length == 1) {
      return a;
    }

    int size = a.length;
    int globalMax = Integer.MIN_VALUE, currMax = 0, start = 0, end = 0, s = 0;
    for (int i = 0; i < size; i++) {
      currMax += a[i];

      if (globalMax < currMax) {
        globalMax = currMax;
        start = s;
        end = i;
      }

      if (currMax < 0) {
        currMax = 0;
        s = i + 1;
      }
    }
    maxSumSubArray = new int[end - start + 1];
    int j = 0;
    for (int i = start; i <= end; i++) {
      maxSumSubArray[j++] = a[i];
    }

    return maxSumSubArray;
  }
}
