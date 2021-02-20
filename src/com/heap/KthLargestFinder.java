package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestFinder {

  /**
   * Finds Kth largest using PriorityQueue
   */
  public int findKthLargestUsingPQ(int[] nums, int k) {
    Queue<Integer> pq = new PriorityQueue<>();
    for (int i : nums) {
      pq.offer(i);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }

  /**
   * Finds Kth largest using Sorting technique
   */
  public int findKthLargestUsingSorting(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 1, 5, 6, 4};
    int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    
    KthLargestFinder klf = new KthLargestFinder();
    
    int k = 2;
    System.out.println("Using PQ: " + klf.findKthLargestUsingPQ(a, k) +
                      " Using Sorting: " + klf.findKthLargestUsingSorting(a, k));
    
    k = 6;
    System.out.println("Using PQ: " + klf.findKthLargestUsingPQ(b, k) +
                      " Using Sorting: " + klf.findKthLargestUsingSorting(b, k));
  }
}
