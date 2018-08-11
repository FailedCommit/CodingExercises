package com.tools;

public class Fibonacci {

  public static void main(String[] args) {
    int n = 2;
    System.out.println("You input: " + n);
    Fibonacci fibonacci = new Fibonacci();
    System.out.println("\nPrinting whole series Iteratively:");
    fibonacci.fibonacciIterative(n);
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





