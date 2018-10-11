package com.tools;

import java.util.Arrays;

/**
 * Given an array, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Demonstrates two-pointer concept with both pointers moving in the same direction.
 * 
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeros {
  public void moveZeroes(int[] a) {
    int i = 0;
    int j = 0;

    while (j < a.length) {
      if (a[j] == 0) j++;
      else a[i++] = a[j++];
    }
    while (i < a.length) {
      a[i++] = 0;
    }
  }

  public static void main(String[] args) {
    MoveZeros mz = new MoveZeros();
    
    int a1[] = {0, 1, 0, 3, 12};
    mz.moveZeroes(a1);
    System.out.println(Arrays.toString(a1));

  }

}
