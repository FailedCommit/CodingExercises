package com.leetcode;

public class NeedleInTheHayStack {

  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    } else if (needle.length() > haystack.length()) {
      return -1;
    } else if (haystack.length() == needle.length()) {
      if (haystack.equals(needle)) {
        return 0;
      } else {
        return -1;
      }
    } else {
      for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        if (haystack.substring(i, i + needle.length()).equals(needle)) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    NeedleInTheHayStack nih = new NeedleInTheHayStack();
     System.out.println(nih.strStr("a", ""));
     System.out.println(nih.strStr("a", "a"));
     System.out.println(nih.strStr("a", "b"));
     System.out.println(nih.strStr("aa", "a"));
     System.out.println(nih.strStr("aab", "ca"));
    System.out.println(nih.strStr("hello", "ll"));
  }
}
