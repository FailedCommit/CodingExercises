package com.utils;

public class Utils {

  public static boolean isValidIndex(int[][] a, int i, int j) {
    return !(i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1);
  }
  
  public static void swap(int[] a, int srcIndex, int destIndex) {
    int temp = a[srcIndex];
    a[srcIndex] = a[destIndex];
    a[destIndex] = temp;
  }
}
