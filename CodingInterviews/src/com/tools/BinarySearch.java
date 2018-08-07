package com.tools;

/**
 * Illustrates BinarySearch algorithm and a follow-up question of finding the range of given element.
 * 
 * BinarySearch should be the first line of thought for searching in a "sorted" array.
 * 
 * Alternate Question: Count occurrences of n in a given sorted array ( Ans. lastOccurrence - firstOccurrence).
 *
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 3, 3, 4, 5};
     BinarySearch bs = new BinarySearch();
     int x = 4;
     
     int idx = bs.search(a, x, 0, a.length-1);
     if(idx != -1) {
       System.out.println(bs.findFirstOccurence(a, x, 0, idx));
       System.out.println(bs.findLastOccurence(a, x, idx, a.length-1));
     }
  }

  /**
   * Searches the given element in a sorted array using BinarySearch algorithm.
   */
  private int search(int[] a, int x, int lo, int hi) {
    if(lo > hi) return -1;
    int mid = lo + (hi - lo)/2; // Avoids overflow
    if(a[mid] == x) return mid;
    else if(a[mid] < x)  return search(a, x, mid+1, hi);
    else return search(a, x, lo, mid-1);
  }
  
  /**
   * Finds the first occurrence of the given element in a sorted array.
   */
  private int findFirstOccurence(int[] a, int x, int lo, int hi) {
    if(lo > hi) return lo;
    int mid = lo + (hi - lo)/2; // Avoids overflow
    if(a[mid] == x)return findFirstOccurence(a, x, lo, mid-1);
    else return findFirstOccurence(a, x, mid+1, hi);
  }
  
  /**
   * Finds the first occurrence of the given element in a sorted array.
   */
  private int findLastOccurence(int[] a, int x, int lo, int hi) {
    if(lo > hi) return hi;
    int mid = lo + (hi - lo)/2; // Avoids overflow
    if(a[mid] == x) return findLastOccurence(a, x, mid + 1, hi);
    else return findLastOccurence(a, x, lo, mid - 1);
  }
}
