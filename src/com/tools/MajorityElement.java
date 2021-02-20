package com.tools;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears "more than n/2 times".
 */
public class MajorityElement {

  public static void main(String[] args) {
    int[] a = {3, 2, 3};
    int[] b = {2, 2, 1, 1, 1, 2, 2};

    MajorityElement me = new MajorityElement();
    System.out.println(me.findMajorityElement_Moore(a));
    System.out.println(me.findMajorityElement_Moore(b));
  }

  /**
   * Moore's Voting Algo works only for item that exists more than n/2 times.
   */
  private int findMajorityElement_Moore(int[] nums) {
    int majority = 0;
    int count = 0;

    for (int num : nums) {
      if (count == 0) majority = num;
      if (majority != num) count--;
      else count++;
    }

    return majority;
  }

  public int majorityElement_Sorting(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
