package com.tools;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

  public static void main(String[] args) {
    LongestSubString ls = new LongestSubString();
    System.out.println(ls.lengthOfLongestSubstring("")); // 0
    System.out.println(ls.lengthOfLongestSubstring(" ")); // 1
    System.out.println(ls.lengthOfLongestSubstring("au")); // 2
    System.out.println(ls.lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(ls.lengthOfLongestSubstring("abcadaaa")); // 4
    System.out.println(ls.lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(ls.lengthOfLongestSubstring("pwwkew")); // 3
    System.out.println(ls.lengthOfLongestSubstring("ohvhjdml")); // 6
  }
  
  /**
   * Given a string, finds the length of the longest substring without repeating characters.
   */
  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int i = 0;
    int j = 0;
    int len = s.length();
    Set<Character> set = new HashSet<>();
    while(i < len && j < len) {
      if(set.contains(s.charAt(j))) {
        set.remove(s.charAt(i++));
      } else {
        set.add(s.charAt(j++));
        max = Math.max(max, j - i);
      }
    }
      
    return max;
  }
}
