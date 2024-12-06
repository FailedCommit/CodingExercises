package com.tools.slidingwindow;

import java.util.List;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        // TODO: Insert Code here
        return null;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[]{"cat", ""});
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"});
        System.out.println(result);
    }
}
