package com.tools;

/**
 * Illustrates the concept of processing an array "both ways" using a single pointer.
 * 
 * Pay special attention to how even and odd length arrays are handled.
 */
public class MaxMiner {
  
  /**
   *  Prints the elements of a given sorted array in pairs of max - min.
   */
  private void printMinMax(int[] arr) {
    for(int i = 0; i < ((arr.length) / 2); i++) {
      System.out.print(" " +  arr[arr.length - 1 - i] + "-" + arr[i]);
    }
    // This is the critical part of this question.
    // Handles the piece which is extra for odd length arrays.
    if(arr.length % 2 != 0) {
      System.out.print(" " +  arr[arr.length / 2]);
    }
  }
  
  // ----------- Notes on Complexity -----------
  //
  // The loop runs for half of the array length so its complexity is O(n/2).
  // The if condition to handle case of odd length runs only once so it's O(1) ie constant time
  //
  // Total complexity: O(n/2) + O(1) => O(n/2) => O(n) -- Linear time
  //
  // -------------------------------------------
  
   public static void main(String[] args) {
    MaxMiner mm = new MaxMiner();
    int[] a1 = new int[] {1, 2, 4, 7, 9};
    mm.printMinMax(a1); // Expected - {1, 9, 2, 7, 4}
    System.out.println();
    int[] a2 = new int[] {1, 2, 4, 7};
    mm.printMinMax(a2); // Expected - 1, 9, 2, 7}
  }
}
