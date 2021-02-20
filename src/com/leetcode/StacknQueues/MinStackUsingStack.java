package com.leetcode.StacknQueues;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 */
public class MinStackUsingStack {
  
  private final Stack<Integer> stack;
  private final Stack<Integer> minStack;
  private int min;

  public MinStackUsingStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
      min = Integer.MAX_VALUE;
  }
  
  public void push(int x) {
      stack.push(x);
      minStack.push(min);
      min = (x < min) ? x : min;
  }
  
  public int pop() {
      int val = stack.pop();
      min = minStack.pop();
      
      return val;
  }
  
  public int top() {
      return stack.peek();
  }
  
  public int getMin() {
      return min;
  }

  public static void main(String[] args) {
    MinStackUsingStack minStack = new MinStackUsingStack();
    minStack.push(10);
    minStack.push(2);
    minStack.push(7);
    minStack.push(1);
    minStack.push(3);
    minStack.push(1);
    
    System.out.println(minStack.getMin()); // 1
    System.out.println(minStack.pop()); // 1
    System.out.println(minStack.getMin()); // 1
    System.out.println(minStack.pop()); // 3
    System.out.println(minStack.pop()); // 1
    System.out.println(minStack.getMin()); // 2
    
    minStack.push(0);
    
    System.out.println(minStack.getMin()); // 0
  }
}
