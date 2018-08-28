package com.leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class MissingPositive {
  
  /**
   * Considers 0 as the first positive integer.
   * If we have to consider 1 as the first positive integer, we will have to update
   * the array indices as array indices start from 0;
   */
  int firstMissingPositiveAnd0(int A[]) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      // when the ith element is not i
      while (A[i] != i) {
        // no need to swap when ith element is out of range [0,n]
        if (A[i] < 0 || A[i] >= n)
          break;

        // handle duplicate elements
        if (A[i] == A[A[i]])
          break;
        // swap elements
        int temp = A[i];
        A[i] = A[temp];
        A[temp] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      if (A[i] != i)
        return i;
    }

    return n;
  }
  
  /**
   * Considers 1 as the first positive integer, so we need to shift 1 offset. The ith element is i+1.
   */
  int firstMissingPositive(int A[]) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      // when the ith element is not i + 1
      while (A[i] != i + 1) {
        // no need to swap when ith element is out of range [0,n]
        if (A[i] <= 0 || A[i] >= n)
          break;

        // handle duplicate elements
        if (A[i] == A[A[i] - 1])
          break;
        
        // swap elements
        int temp = A[i];
        A[i] = A[temp - 1];
        A[temp - 1] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      if (A[i] != i + 1)
        return i + 1;
    }

    return n;
  }

  public static void main(String[] args) {
    MissingPositive mp = new MissingPositive();
    int[] a1 = {1,2,0,4}; // 3 3
    System.out.println(mp.firstMissingPositiveAnd0(a1) + " " + mp.firstMissingPositive(a1));
    int[] a2 = {3,4,-1,1}; // 0 2
    System.out.println(mp.firstMissingPositiveAnd0(a2) + " " + mp.firstMissingPositive(a2));
    int[] a3 = {7,8,9,11,12}; // 0 1
    System.out.println(mp.firstMissingPositiveAnd0(a3) + " " + mp.firstMissingPositive(a3));
  }
}
