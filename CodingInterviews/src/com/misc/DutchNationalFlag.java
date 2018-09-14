package com.misc;

import java.util.Arrays;
import static com.utils.Utils.swap;

/**
 * Sorts the given array of 0s, 1s and 2s such that all 0s are at the beginning
 * all 1s in the middle and all 2s in the end.
 */
public class DutchNationalFlag {
  
  private void sort(int[] a, int lo, int mid, int hi) {
    while(mid <= hi) {
      switch(a[mid]) {
        case 0:
          swap(a, lo, mid);
          mid++;
          lo++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(a, mid, hi);
          hi--;
          break;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {2, 1, 0, 0, 2, 2, 2, 1, 2, 0, 0, 1, 0, 2, 1, 0};
    int[] b = {1, 0, 2, 0, 1, 2, 0, 2, 0};
    
    DutchNationalFlag dnf = new DutchNationalFlag();
    dnf.sort(a, 0, 0, a.length-1);
    System.out.println(Arrays.toString(a));
    
    dnf.sort(b, 0, 0, b.length-1);
    System.out.println(Arrays.toString(b));
  }
}
