package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    Arrays.sort(nums);
    int[] result = new int[2];
    int low = 0;
    int max = nums.length - 1;
    while(low < max) {
        if(nums[low] + nums[max]  == target) {
          result[0] = map.get(nums[low]);
          result[1] = map.get(nums[max]);
          break;
        }
        else if(nums[low] > target) {
          low++;
        } else if(nums[max] > target) {
          max--;
        }
    }
    return result;
}

  public static void main(String[] args) {
    int[] result = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println(result[0] + " " +  result[1]);
    
    int[] result1 = new TwoSum().twoSum(new int[]{3, 2, 4}, 6);
    System.out.println(result1[0] + " " +  result1[1]);
    
    int[] result2 = new TwoSum().twoSum(new int[]{3, 3}, 6);
    System.out.println(result2[0] + " " +  result2[1]);
  }
}
