package com.tools;

/**
 * Illustrates the concept of processing two arrays using a two pointers.
 * 
 * Pay special attention to common length is processed in one go and for difference there
 * are two loops but at given point only one will be executed. 
 * 
 * Notice how complexity is calculated. Even though, there are multiple loops but complexity is still linear time.
 */
public class MergeSortedArrays {

  /**
   * Prints the contents of two sorted arrays in increasing order.
   * 
   * Follow-up 1. return a merged equivalent of these two arrays instead of printing.
   * 
   * Follow-up 2. instead of 2 arrays, there are n arrays and n is not known. Merge all the arrays into 1, maintaining
   * the sort order, of course.
   */
  private void mergeArrays(int[] arr1, int[] arr2) {
    int i = 0;
    int j = 0;

    while (i < arr1.length && j < arr2.length) { // O(min(m, n))
      if (arr1[i] < arr2[j]) {
        System.out.println(arr1[i++]);
      } else {
        System.out.println(arr2[j++]);
      }
    }
    while (j < arr2.length) { // O(m)
      System.out.println(arr2[j++]);
    }
    while (i < arr1.length) { // O(n)
      System.out.println(arr1[i++]);
    }
  } // O(max(m, n)) - total complexity

  public static void main(String[] args) {
    int[] arr1 = new int[] {1, 2};
    int[] arr2 = new int[] {2, 3};

    MergeSortedArrays msa = new MergeSortedArrays();
    msa.mergeArrays(arr1, arr2); // Expected: 1, 2, 2, 3
  }
}
