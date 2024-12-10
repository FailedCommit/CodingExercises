package com.tools.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here

        int len = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            Character endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            while (map.size() > k) {
                Character startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                int count = map.get(startChar);
                if (map.get(startChar) == 0) map.remove(startChar);
                start++;
            }
            len = Math.max(len, end - start + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
