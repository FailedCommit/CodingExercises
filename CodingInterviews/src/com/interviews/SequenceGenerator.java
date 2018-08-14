package com.interviews;

public class SequenceGenerator {

  public static void main(String[] args) {
    SequenceGenerator s = new SequenceGenerator();
    s.printSequence(5, 5);
  }

  /**
   * Prints a sequence of a's and b's such that:<br>
   * 1. There are no more than 2 consequent characters.<br>
   * 2. Total length of sequence is equal A + B.
   * 
   * @param A possible counts of 'a' in the resulting string.
   * @param B possible counts of 'b' in the resulting string.
   */
  public void printSequence(int A, int B) { // 3 2
    int len = A + B;
    int aC = 2;
    int bC = 2;

    for (int i = 0; i < len; i++) { // aa
      if (A >= B && aC > 0) {
        System.out.print("a");
        if (bC == 0)
          bC = 2;
        aC--;
        A--;
      } else { // if(B >= A && bC > 0)
        System.out.print("b");
        if (aC == 0)
          aC = 2;
        bC--;
        B--;
      }
    }
  }
}
//Zalando
