package com.leetcode.StacknQueues;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 */
public class MinStack {
  public Elem top;

  public void push(int x) {
    if (top == null) top = new Elem(x, x);
    else {
      Elem e = new Elem(x, Math.min(x, top.min));
      e.next = top;
      top = e;
    }
  }

  public int pop() {
    if (top == null) return -1;
    int val = top.value;
    
    Elem temp = top.next;
    top.next = null;
    top = temp;
    temp = null;
    
    return val;
  }

  public int top() {
    if (top == null) return -1;
    return top.value;
  }

  public int getMin() {
    if (top == null) return -1;
    return top.min;
  }
  
  class Elem {
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
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
