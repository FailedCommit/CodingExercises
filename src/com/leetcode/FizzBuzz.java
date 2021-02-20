package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

  public List<String> fizzBuzz(int n) {
    List<String> fizBuzz = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        fizBuzz.add("FizzBuzz");
      } else if (i % 3 == 0) {
        fizBuzz.add("Fizz");
      } else if (i % 5 == 0) {
        fizBuzz.add("Buzz");
      } else {
        fizBuzz.add(String.valueOf(i));
      }
    }
    return fizBuzz;
  }

  public static void main(String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    List<String> fizBuzz = fizzBuzz.fizzBuzz(1);
    System.out.println(Arrays.toString(fizBuzz.toArray()));
    
    fizBuzz = fizzBuzz.fizzBuzz(15);
    System.out.println(Arrays.toString(fizBuzz.toArray()));
  }

}
