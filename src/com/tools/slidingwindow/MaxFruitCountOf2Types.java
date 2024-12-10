package com.tools.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        // TODO: Write code here
        int start = 0;
        int total = 0;
        Set<Character> set = new HashSet<>();
        for(int end = 0; end < arr.length; end++) {
            char ch = arr[end];
            set.add(ch);
            while(set.size() > 2) {
                set.remove(arr[start++]);
            }
            total = Math.max(total, end - start + 1);
        }


        return total;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'C', 'C', 'C', 'A', 'B', 'A', 'A', 'B', 'C', 'C', 'D'})); // 5 should be the answer
        String s = "Assertion Failed";
        assert 5 == MaxFruitCountOf2Types.findLength(new char[]{'C', 'C', 'C', 'A', 'B', 'A', 'A', 'B', 'C', 'C', 'D'}) : s;
        System.out.println(s);

    }
}
