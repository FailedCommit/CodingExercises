package com.leetcode.StacknQueues;

import java.util.Stack;

/**
 * Reverses the given Stack of integers.
 *
 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty.
 * When the stack becomes empty, insert all held items one by one at the bottom of the stack.
 */
public class StackReverser {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    StackReverser reverser = new StackReverser();
    System.out.print("Input: ");
    reverser.printStack(stack);
    reverser.reverseStack(stack);
    System.out.print("Output: ");
    reverser.printStack(stack);
  }
  
  /**
   * Holds all values in Function Call Stack until the stack becomes empty.
   */
  public void reverseStack(Stack<Integer> stack) {
    if(stack.empty()) return;
    int data = stack.pop();
    reverseStack(stack);
    insertAtBottom(stack, data);
  }

  /**
   * When the stack becomes empty, insert all held items one by one at the bottom of the stack.
   */
  private void insertAtBottom(Stack<Integer> stack, int data) {
    if(stack.empty()) {
      stack.push(data);
      return;
    }
    int temp = stack.pop();
    insertAtBottom(stack, data);
    stack.push(temp);
  }

  public void printStack(Stack<Integer> stack) {
    int top = stack.size();
    while(top > 0) {
      System.out.print(stack.get(--top) + " ");
    }
    System.out.print("\n");
  }
}
