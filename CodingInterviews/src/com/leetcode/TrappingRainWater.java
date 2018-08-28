package com.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {
  
  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int leftMax = 0, rightMax = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if(height[left] >= leftMax) leftMax = height[left];
            else ans += leftMax - height[left];
            ++left;
        }
        else {
          if(height[right] >= rightMax) rightMax = height[right];
          else ans += rightMax - height[right];
            --right;
        }
    }
    return ans;
 }
  
  public int trapUsingStacks(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty()) break;
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current++);
        }
        return ans;
  }

  public static void main(String[] args) {
    TrappingRainWater rw = new TrappingRainWater();
    
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
    System.out.println(rw.trap(height));
    System.out.println(rw.trapUsingStacks(height));
    
    int[] height2 = {5,4,1,2}; // 1
    System.out.println(rw.trap(height2));
    System.out.println(rw.trapUsingStacks(height2));
  }

}
