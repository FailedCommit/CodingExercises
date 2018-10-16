package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {
  
  public int findPairCountsWithTwoPointer(int[] a, int k) { // Time: O(n log n), Space: O(1)
    if(a.length <= 1) return 0;
    
    Arrays.sort(a);
    int start = 0;
    int end = 0;
    int pairCount = 0;
    
    while(start < a.length && end < a.length) {
      if(start == end || a[start] + k > a[end]) end++;
      else if(a[start] + k < a[end]) start++;
      else {
        pairCount++;
        start++;
        while(end < a.length - 1 && a[end] == a[end + 1]) end++;
        end++;
      }
    }
    return pairCount;
  }
  
  public int findPairCountsWithMap(int[] a, int k) { // Time: O(n), Space: O(n)
    int pairCount = 0;
    if(a == null || a.length <= 1 || k < 0) return pairCount;
    
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : a) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if(k == 0) {
        // Count duplicate elements
        if(entry.getValue() >= 2) pairCount++;
      } else {
        if(map.containsKey(entry.getKey() + k)) pairCount++;
      }
    }
    
    return pairCount;
  }
  
  
  public static void main(String[] args) {
    KDiffPairs kdiff = new KDiffPairs();
    
    int[] a = {3, 1, 4, 1, 5};
    System.out.println(kdiff.findPairCountsWithTwoPointer(a, 2)); // 2
    System.out.println(kdiff.findPairCountsWithMap(a, 2));
    
    int[] b = {1, 2, 3, 4, 5};
    System.out.println(kdiff.findPairCountsWithTwoPointer(b, 1)); // 4
    
    int[] c = {1, 3, 1, 5, 4};
    System.out.println(kdiff.findPairCountsWithTwoPointer(c, 0)); // 1
    
    int[] d = {1};
    System.out.println(kdiff.findPairCountsWithTwoPointer(d, 1)); // 0
    System.out.println(kdiff.findPairCountsWithMap(d, 1)); // 0
    
    int[] e = {1, 2};
    System.out.println(kdiff.findPairCountsWithTwoPointer(e, 4)); // 0
    System.out.println(kdiff.findPairCountsWithMap(e, 4)); // 0
    
    int[] f = {1, 1, 1, 1, 1, 1, 1};
    System.out.println(kdiff.findPairCountsWithTwoPointer(f, 0)); // 1
    
    int[] g = {1, 2, 2, 2};
    System.out.println(kdiff.findPairCountsWithTwoPointer(g, 1)); // 1
  }
}
