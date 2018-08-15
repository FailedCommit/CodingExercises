package com.leetcode;

public class ValidPalindrome {
  
  public static void main(String[] args) {
    ValidPalindrome vp = new ValidPalindrome();
    System.out.println(vp.isPalindrome(""));
    System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(vp.isPalindrome("A"));
    System.out.println(vp.isPalindrome("race a car"));
    System.out.println(vp.isPalindrome("N,IT;I.;N"));

  }

  /**
   * Given a string, determines if it is a palindrome,
   *   considering only alphanumeric characters and ignoring cases.
   *   empty string is considered a palindrome.
   */
  public boolean isPalindrome(String s) {
    if(s.isEmpty()) return true;
    s = s.toLowerCase();
    int i = 0;
    int j = s.length() - 1;

    while (j > i) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(j);

      if (!isValidCharacter(c1)) {
        i++;
        continue;
      } else if (!isValidCharacter(c2)) {
        j--;
        continue;
      }

      if (c1 != c2)
        return false;

      i++;
      j--;
    }
    return true;
  }

  private boolean isValidCharacter(int c) {
    return ((c >= 97 && c <= 122) || (c >= 48 && c <= 57));
  }
}
