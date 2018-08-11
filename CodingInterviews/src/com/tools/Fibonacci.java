package com.tools;

public class Fibonacci {

  public static void main(String[] args) {
    int n = 4;
    System.out.println("You input: " + n);
    Fibonacci fibonacci = new Fibonacci();
    System.out.println("\nRecurive: " + fibonacci.recursive(n));
    System.out.println("\nPrinting whole series Recurively:");
    fibonacci.recursivePrint(n, 1, 1);
    System.out.println("\nRecursion similar to Iteration: ");
    fibonacci.fibonacciRecursiveOther(1, 1, n);
    System.out.println("\nPrinting whole series Iteratively:");
    fibonacci.fibonacciIterative(n);
  }
  
  /**
   * Finds n-th fibonacci number using recursive algo.
   */
  private int recursive(int n) {
    if(n <= 1) return 1;
    int res = recursive(n-1) + recursive(n-2);
    return res;
  }
  
  /**
   * Prints n fibonacci numbers using recursive algo.
   */
  private int recursivePrint(int n, int a, int b) {
    System.out.print(a + " ");
    if(n == 0 || n == 1) return 1;
    int sum = a+b; 
    return recursivePrint(n-1, b, sum);
  }
  
  /** 
   * An alternate recursive approach which derives from iterative approach
   *  to print n fibonacci numbers
   */
  private void fibonacciRecursiveOther(int a, int b, int n) {
    int sum;
    if(n > 0) {
      System.out.print(a + " ");
      sum = a + b;
      a = b;
      b = sum;
      fibonacciRecursiveOther(a, b, n-1);
    }
  }
  
  /**
   * Iterative approach to print n fibonacci numbers.
   */
  private void fibonacciIterative(int n) {
    if(n == 0 || n == 1) {
      System.out.print(1);
      return;
    }
    
    int a = 1;
    int b  =1;
    
    System.out.print(a + " " + b + " ");
    
    for(int i = 3; i <= n; i++) {
      int c = a + b;
      System.out.print(c + " ");
      a = b;
      b = c;
    } 
  }
}





