package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
  
  /**
   * Time complexity : O(n^2). We need to consider every sub-array possible.
   * Space complexity : O(1). Constant space is used.
   */
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    for (int start = 0; start < nums.length; start++) {
        int sum=0;
        for (int end = start; end < nums.length; end++) {
            sum+=nums[end];
            if (sum == k)
                count++;
        }
    }
    return count;
  }
  
  /**
   * Time complexity : O(n). The entire nums array is traversed only once.
   * Space complexity : O(n). Hashmap map can contain upto n distinct entries in the worst case.
   */
  public int subarraySumWithHashMap(int[] nums, int k) {
    int count = 0, sum = 0;
    Map< Integer, Integer > map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.containsKey(sum - k))
            count += map.get(sum - k);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {-1, -1, 1, 1};
    int k = 0;
    
    int[] a1 = {1, 1, 1};
    int k1 = 2;
    
    SubArraySum sas = new SubArraySum();
    System.out.println("Total SubArrays: " + sas.subarraySumWithHashMap(a, k));
    System.out.println("Total SubArrays: " + sas.subarraySumWithHashMap(a1, k1));
  }

}
