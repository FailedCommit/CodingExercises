package com.tools.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        // TODO: Write code here

        int len = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();
        for(int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            if(!set.add(ch)) {
                set.clear();
                set.add(ch);
                start = end;
            }
            len = Math.max(len, end - start + 1);
        }

        return len;
    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
