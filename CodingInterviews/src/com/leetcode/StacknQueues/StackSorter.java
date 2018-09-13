package com.leetcode.StacknQueues;

import java.util.Arrays;
import java.util.Stack;

/** Sorts the given stack. */
public class StackSorter {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(3);
    s.push(2);
    s.push(1);
    
    Stack<Integer> s2 = new Stack<>();
    s2.push(20);
    s2.push(30);
    s2.push(10);
    s2.push(5);
    
    StackSorter ss = new StackSorter();
    System.out.println(Arrays.toString(ss.sort(s).toArray())); // 1, 2, 3
    System.out.println(Arrays.toString(ss.sort(s2).toArray())); // 5, 10, 20, 30
  }

  public Stack<Integer> sort(Stack<Integer> s) {
    if (s == null || s.size() <= 1)
      return s;
    Stack<Integer> ts = new Stack<>();
    while (!s.isEmpty()) {
      int temp = s.pop();
      while (!ts.isEmpty() && ts.peek() > temp) {
        s.push(ts.pop());
      }
      ts.push(temp);
    }
    if (s.isEmpty()) return ts;
    return s;
  }
}
